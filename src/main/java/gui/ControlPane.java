package gui;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.AngleTool;
import logic.ImageGenerator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import io.FileHandler;
import logic.LineTool;
import logic.ScopeTool;

import java.io.File;

public class ControlPane extends StackPane {

    public ControlPane(/*StateModel stateModel*/) {
        Button loadButton = new Button(">>Daten laden<<");
        Button measureLength = new Button("Länge messen");
        Button measureScope = new Button("Umfang messen");
        Button measureDegree = new Button("Winkel messen");
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        measureLength.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new LineTool()));
        measureDegree.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new AngleTool()));
        measureScope.setOnAction(event -> MainPane.Instance.getGraphicPane().changeTool(new ScopeTool()));

        // colors appear in hex
        ComboBox<Color> colorComboBox = new ComboBox<>();
        colorComboBox.setEditable(false);
        colorComboBox.getItems().add(Color.WHITE);
        colorComboBox.getItems().add(Color.BLACK);
        colorComboBox.getItems().add(Color.POWDERBLUE);

        /*
        colorComboBox.setOnAction(event -> {
            Color selectedColor = colorComboBox.getValue();
            if (selectedColor == Color.WHITE) {
                stateModel.setColor(Color.WHITE);
            } else if (selectedColor == Color.BLACK) {
                stateModel.setColor(Color.BLACK);
            } else if (selectedColor == Color.POWDERBLUE) {
                stateModel.setColor(Color.POWDERBLUE);
            }
        });

        // don't really now how to handle the stateModel
        stateModel.addObserver(() -> {
            stateModel.setColor();
        });
         */

        Slider strokeWidth = new Slider(1, 5, 3);
        strokeWidth.setShowTickMarks(true);
        strokeWidth.setShowTickLabels(true);
        strokeWidth.setMajorTickUnit(2);
        strokeWidth.setSnapToTicks(true);

        /*
        strokeWidth.valueProperty().addListener(observable -> {
            stateModel.setStrokeWidth(strokeWidth.getValue()/4);
        });
         */

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

                textArea.clear();
                textArea.appendText("--- Image information ---\n");
                textArea.appendText(imgGenerator.getDescription()+"\n");
                textArea.appendText(imgGenerator.getResolution()+" "+imgGenerator.getResolutionUnit()+" per Pixel\n\n");
                textArea.appendText(imgGenerator.getWidth().intValue()+" x "+imgGenerator.getHeight().intValue()+" (Width x height in pixel)\n");
                textArea.appendText((double)Math.round(imgGenerator.getWidth().intValue() * imgGenerator.getResolution() * 100)/100 + imgGenerator.getResolutionUnit() + " x " + (double)Math.round(imgGenerator.getHeight().intValue() * imgGenerator.getResolution() * 100)/100 + imgGenerator.getResolutionUnit() + " (Width x height in metrischer Einheit)\n\n");
                textArea.appendText(imgGenerator.getImageFile()+"\n\n");
                textArea.appendText("--- Debug information ---\n");
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
        controlPane.getChildren().addAll(loadButton,measureLength, measureDegree, measureScope, hBox ,textArea);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(controlPane);
    }
}
