package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class GraphicPane extends StackPane {
    // Start variablen für die Maus als instanz definieren
    private final ImageView iv1;
    double x1 = 0;
    double y1 = 0;
    // double x2 = 0; für Winkel benötigt
    // double y2 = 0; für Winkel benötigt

    public GraphicPane() {
        // create a Pane for drawing
        this.iv1 = new ImageView();
        Pane drawingPane = new Pane();
        Button clear = new Button("Zeichnung bereinigen");
        drawingPane.setStyle("-fx-background-color: red");
        drawingPane.getChildren().add(iv1);

        // Settings for the image
        this.iv1.setFitHeight(500);
        this.iv1.setFitWidth(500);
        // image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel
        this.iv1.setSmooth(true);
        this.iv1.setPreserveRatio(true);
        this.iv1.setCache(true);

        // Liste mit den gespeicherten Koordinaten der Linien
        List<Line> lines = new ArrayList<>();

        /**
         * Start- und Endpunkte wurden als instanz Variablen kreiert durch MausClick erzeugt
         */
        drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            // x und y als startpunkt festlegen
            x1 = event.getX();
            y1 = event.getY();
        });

        drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            // Linien generieren / Pane und Liste hinzufügen
            Line line = new Line();
            line.setStartX(x1);
            line.setStartY(y1);
            line.setEndX(event.getX());
            line.setEndY(event.getY());
            line.setStroke(Color.GREENYELLOW);
            lines.add(line);
            drawingPane.getChildren().add(line);
            // Wo werden die Linien ausserhalb der Liste gespeichert?
        });

        /**
         * löscht die gesamte Pane. kann nicht neu über loadbutton geladen werden.
         * Wie greift man auf die Linien zu?
         * Wie kann man die generierte Liste in eine andere Klasse übernehmen
         */
        clear.setOnAction(event -> {
            drawingPane.getChildren().clear();
        });

        //Vertikalen anordnung der Komponenten
        VBox box = new VBox();
        box.getChildren().addAll(drawingPane, clear);
        box.setAlignment(Pos.CENTER);
        box.autosize();
        this.getChildren().add(box);
    }

    public void setImage(Image image) {
        if(image != null) {
            iv1.setImage(image);
        }
    }
}
