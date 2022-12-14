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
import logic.AngleTool;
import logic.ImageGenerator;
import logic.LineTool;
import logic.ScopeTool;

import java.io.File;

public class ControlPane extends StackPane {

    public ControlPane(/*StateModel stateModel*/) {
        Button loadButton = new Button(">>Daten laden<<");
        Button measureLength = new Button("Länge messen");
        Button measureScope = new Button("Umfang messen");
        Button measureDegree = new Button("Winkel messen");

        measureLength.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new LineTool()));
        measureDegree.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new AngleTool()));
        measureScope.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new ScopeTool()));

        // colors appear in hex
        ComboBox<Color> colorComboBox = new ComboBox<>();
        colorComboBox.setEditable(false);
        colorComboBox.getItems().add(Color.WHITE);
        colorComboBox.getItems().add(Color.BLACK);
        colorComboBox.getItems().add(Color.YELLOWGREEN);

        colorComboBox.setOnAction(event -> {
            Color selectedColor = colorComboBox.getValue();
            if (selectedColor == Color.WHITE) {
                StateModel.setColor(Color.WHITE);
            } else if (selectedColor == Color.BLACK) {
                StateModel.setColor(Color.BLACK);
            } else if (selectedColor == Color.YELLOWGREEN) {
                StateModel.setColor(Color.YELLOWGREEN);
            }
        });

        /*
        // don't really now how to handle the stateModel
        // how can I add non methods to the observer?
        StateModel.addObserver(() -> {
            stateModel.setColor();
        });
         */

        Slider strokeWidth = new Slider(5, 20, 12);
        strokeWidth.setShowTickMarks(true);
        strokeWidth.setShowTickLabels(true);
        strokeWidth.setMajorTickUnit(3);
        strokeWidth.setSnapToTicks(true);

        strokeWidth.valueProperty().addListener(observable -> {
            StateModel.setStrokeWidth(strokeWidth.getValue()/5);
        });



        // define 1st text box & label for the file information
        Label label = new Label();
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        // define 2nd text box for displaying measurements as they are taken -- this needs to be dynamic !!!
        Label label2 = new Label();
        TextArea textArea2 = new TextArea();
        textArea2.setEditable(false);

        //CheckBox nightMode = new CheckBox("Nachtmodus");

        /**
         * 1. Mit dem Button das Textfile laden
         * 2. textFile unterscheiden zwischen .txt und .json mit fileReader()
         * 3. aus dem textFile ein Objekt generieren
         */
        loadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Metadaten laden..");
            // Filter um Daten laden zu können..
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.json"));

            File dataFile = fileChooser.showOpenDialog(null);

            ImageGenerator imgGenerator = FileHandler.readFile(dataFile);
            MainPane.Instance.setCurrentImageGenerator(imgGenerator);
            if(imgGenerator != null) {
                // Image ins statemodel setzen unm es abspeichern zu können.
                MainPane.Instance.getGraphicPane().setImage(imgGenerator.getImg());

                // 1st text box to display file/image information that doesn't change as measurements are taken
                textArea.clear();
                textArea.setWrapText(true);
                textArea.appendText("-- Image information --\n");
                textArea.appendText(imgGenerator.getDescription()+"\n");
                textArea.appendText(imgGenerator.getResolution()+" "+imgGenerator.getResolutionUnit()+" per pixel\n\n");
                textArea.appendText(imgGenerator.getWidth().intValue()+" x "+imgGenerator.getHeight().intValue()+" pixels\n");
                textArea.appendText((double)Math.round(imgGenerator.getWidth().intValue() * imgGenerator.getResolution() * 100)/100 + imgGenerator.getResolutionUnit() + " x " + (double)Math.round(imgGenerator.getHeight().intValue() * imgGenerator.getResolution() * 100)/100 + imgGenerator.getResolutionUnit() +"\n\n");
                textArea.appendText(imgGenerator.getImageFile());

                // 2nd text box to display measurements -- this block needs to be transferred to where these measurements are calculated!
                textArea2.clear();
                textArea2.setWrapText(true);
                textArea2.appendText("-- Measurements --\n");
                textArea2.appendText(" mm\n");
                textArea2.appendText(" cm\n");
                textArea2.appendText(" m\n");
                textArea2.appendText(" km\n");
            }
        });

        // Horizontale Anordnung für die Linieneinstellungen
        HBox hBox = new HBox();
        hBox.getChildren().addAll(colorComboBox, strokeWidth);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        // put the components in a vertical box
        VBox controlPane = new VBox();
        controlPane.getChildren().addAll(loadButton,measureLength, measureDegree, measureScope, hBox ,textArea, textArea2);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(controlPane);
    }
}
