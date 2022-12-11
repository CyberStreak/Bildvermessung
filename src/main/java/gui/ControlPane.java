package gui;

import logic.AngleTool;
import logic.ImageGenerator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import io.FileHandler;
import logic.LineTool;

import java.io.File;

public class ControlPane extends StackPane {
    //public ImageGenerator imageGenerator; // Warum wird die Variabel bei private nicht gebraucht und public schon? (Bleibt null)

    public ControlPane() {
        Button loadButton = new Button(">>Daten laden<<");
        Button measureLength = new Button("Länge messen");
        Button measureScope = new Button("Umfang messen");
        Button measureDegree = new Button("Winkel messen");

        measureLength.setOnAction(event -> {MainPane.Instance.getGraphicPane().changeTool(new LineTool());});
        measureDegree.setOnAction(event -> {MainPane.Instance.getGraphicPane().changeTool(new AngleTool());});


        ComboBox measureUnit = new ComboBox();
        measureUnit.setEditable(false);
        measureUnit.getItems().addAll("mm", "cm", "m", "km");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        CheckBox nightMode = new CheckBox("Nachtmodus");

        /**
         * 1. Mit dem Button das Textfile laden
         * 2. textFile unterscheiden zwischen .txt und .json mit fileReader()
         * 3. aus dem textFile ein Objekt generieren
         */
        loadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Metadaten laden..");
            // Filter um Daten laden zu können..
            fileChooser.getExtensionFilters().addAll(
                   new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.json"));

            File dataFile = fileChooser.showOpenDialog(null);

            ImageGenerator imgGenerator = FileHandler.readFile(dataFile);
            MainPane.Instance.setCurrentImageGenerator(imgGenerator);
            if(imgGenerator != null) {
                // Image ins statemodel setzen unm es abspeichern zu können.
                MainPane.Instance.getGraphicPane().setImage(imgGenerator.getImg());

                /**
                 * Grund fürs nicht funktionieren (s. Blockcomment unten) war: Ausserhalb 'imgGenerator'
                 * Zusätzlich noch zusammengefasst, ohne Definition von Zwischenvariablen.
                 */
                textArea.clear();
                textArea.appendText("--- Image information ---\n");
                textArea.appendText(imgGenerator.getDescription()+"\n");
                textArea.appendText(imgGenerator.getResolution()+" "+imgGenerator.getResolutionUnit()+" per Pixel\n\n");
                textArea.appendText(imgGenerator.getImageFile()+"\n\n");
                textArea.appendText("--- Debug information ---\n");
            }
        });

        /**
         * Alles in die Box rein
         */
        VBox controlPane = new VBox();
        controlPane.getChildren().addAll(loadButton,measureLength, measureDegree, measureScope, measureUnit, textArea, nightMode );
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().add(controlPane);
    }
}
