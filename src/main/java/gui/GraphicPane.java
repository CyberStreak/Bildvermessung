package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import logic.ImageGenerator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class GraphicPane extends StackPane {
    // Start variablen für die Maus als instanz definieren
    //private ImageGenerator imageGenerator; // Variable ist null, Fehler bevor die App gestartet wird.
    private final ImageView iv1;
    private double x1;
    private double y1;

    public GraphicPane() {

        //StackPane funktioniert nicht, ScrollPane versuchen oder den ImageView wegnehmen.
        Pane drawingPane = new Pane();

        // Settings for the image
        iv1 = new ImageView();
        iv1.setFitHeight(750); // Bild passt sich nicht an das Fenster an
        iv1.setFitWidth(750); // Bild passt sich nicht an das Fenster an
        // image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel
        iv1.setSmooth(true);
        iv1.setPreserveRatio(true);
        iv1.setCache(true);

        // Liste mit den gespeicherten Koordinaten der Linien
        List<Line> lines = new ArrayList<>();

        /**
         * Start- und Endpunkte wurden als instanz Variablen kreiert
         */
        drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            // x und y als startpunkt festlegen
                x1 = event.getX();
                y1 = event.getY();
        });

        drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            // Linie zeichnen
            Line line = new Line();
            line.setStartX(x1);
            line.setStartY(y1);
            line.setEndX(event.getX());
            line.setEndY(event.getY());
            line.setStroke(Color.GREENYELLOW);
            line.setStrokeWidth(10);
        });

        VBox box = new VBox();
        box.getChildren().addAll(drawingPane, iv1);
        box.setStyle("-fx-background-color: red");
        // Padding etc.
        this.getChildren().add(box);
    }

    public void setImage(Image image) {
        if(image != null) {
            iv1.setImage(image);
        }
    }



}
