package gui;

import io.FileHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import logic.AngleTool;
import logic.ImageGenerator;
import logic.LineTool;
import logic.ScopeTool;

import java.io.File;

public class ControlPane extends StackPane {
    private final int DEFAULT_LINE_WIDTH = 3;

    public ControlPane(StateModel stateModel) {
        // components for buttons
        Button loadButton = new Button(">>Daten laden<<");
        Button measureLength = new Button("Länge messen");
        Button measureScope = new Button("Umfang messen");
        Button measureDegree = new Button("Winkel messen");

        // event for the tools
        measureLength.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new LineTool(stateModel)));
        measureDegree.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new AngleTool(stateModel)));
        measureScope.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new ScopeTool(stateModel)));

        // comboBox for the stroke color
        Label labelColor = new Label("Strichfarbe:");
        ComboBox<Color> colorComboBox = new ComboBox<>();
        colorComboBox.setEditable(false);
        colorComboBox.getItems().add(Color.YELLOWGREEN);
        colorComboBox.getItems().add(Color.WHITE);
        colorComboBox.getItems().add(Color.BLACK);
        colorComboBox.getItems().add(Color.HOTPINK);

        // displaying the cells of the comboBox in color
        colorComboBox.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Color> call(ListView<Color> param) {
                return new ListCell<>() {
                    {
                        super.setPrefWidth(100);
                    }

                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setStyle("");
                        } else {
                            setText(item.toString());
                            setStyle("-fx-background-color: " + item.toString().replace("0x", "#"));
                        }
                    }
                };
            }
        });

        // set the chosen color for the stateModel
        colorComboBox.setOnAction(event -> {
            Color selectedColor = colorComboBox.getValue();
            if (selectedColor == Color.WHITE) {
                stateModel.setColor(Color.WHITE);
            } else if (selectedColor == Color.BLACK) {
                stateModel.setColor(Color.BLACK);
            } else if (selectedColor == Color.HOTPINK) {
                stateModel.setColor(Color.HOTPINK);
            } else if (selectedColor == Color.YELLOWGREEN) {
                stateModel.setColor(Color.YELLOWGREEN);
            }
        });

        // slider for the stroke width
        Label widthOfStroke = new Label("Strichdicke:");
        Slider strokeWidth = new Slider(1, 5, DEFAULT_LINE_WIDTH);
        strokeWidth.setShowTickMarks(true);
        strokeWidth.setShowTickLabels(true);
        strokeWidth.setMajorTickUnit(2);
        strokeWidth.setSnapToTicks(true);

        strokeWidth.valueProperty().addListener(observable -> stateModel.setStrokeWidth(strokeWidth.getValue()));

        // define 1st text box & label for the file information
        Label imageInfo = new Label("Bildinformationen");
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        /*
         1. load metadata with the button
         2. choose the right reader
         3. generate the image and imageObject
         */
        loadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Metadaten laden..");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.json"));
            File dataFile = fileChooser.showOpenDialog(null);

            ImageGenerator imgGenerator = FileHandler.readFile(dataFile);
            MainPane.Instance.setCurrentImageGenerator(imgGenerator);
            if(imgGenerator != null) {
                // set the image for the imageView
                MainPane.Instance.getGraphicPane().setImage(imgGenerator.getImg());

                // 1st text box to display file/image information that doesn't change as measurements are taken
                textArea.clear();
                textArea.setWrapText(true);
                textArea.appendText(imgGenerator.getDescription()+"\n");
                textArea.appendText(imgGenerator.getResolution()+" "+imgGenerator.getResolutionUnit()+" per pixel\n\n");
                textArea.appendText(imgGenerator.getWidth().intValue()+" x "+imgGenerator.getHeight().intValue()+" pixels\n");
                textArea.appendText((double)Math.round(imgGenerator.getWidth().intValue() * imgGenerator.getResolution() * 100)/100 + " "+ imgGenerator.getResolutionUnit() + " x " + (double)Math.round(imgGenerator.getHeight().intValue() * imgGenerator.getResolution() * 100)/100 + " "+imgGenerator.getResolutionUnit() +"\n\n");
                textArea.appendText(imgGenerator.getImageFile());
            }

            stateModel.setColor(Color.YELLOWGREEN);
            stateModel.setStrokeWidth(DEFAULT_LINE_WIDTH);
        });

        // vertical box for the stroke changes
        VBox colorInfo = new VBox();
        colorInfo.getChildren().addAll(labelColor, colorComboBox);
        VBox strokeInfo = new VBox();
        strokeInfo.getChildren().addAll(widthOfStroke, strokeWidth);
        // horizontal box for the stroke changes
        HBox hBox = new HBox();
        hBox.getChildren().addAll(colorInfo, strokeInfo);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        // vertical box for all components
        VBox controlPane = new VBox();
        controlPane.getChildren().addAll(loadButton,measureLength, measureDegree, measureScope, hBox , imageInfo ,textArea);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(controlPane);
    }
}
