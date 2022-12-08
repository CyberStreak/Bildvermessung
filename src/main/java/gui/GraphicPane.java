package gui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import logic.ImageGenerator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GraphicPane extends StackPane {
    private ImageGenerator imageGenerator;
    private final ImageView iv1;

    public GraphicPane() {

        //StackPane funktioniert nicht, ScrollPane versuchen oder den ImageView wegnehmen.
        Pane drawingPane = new Pane();
        drawingPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        // Settings for the image
        iv1 = new ImageView();
        iv1.setFitHeight(500); // Bild passt sich nicht an das Fenster an
        iv1.setFitWidth(500); // Bild passt sich nicht an das Fenster an
        // image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel
        iv1.setSmooth(true);
        iv1.setPreserveRatio(true);
        iv1.setCache(true);

        // Linie muss ausserhalb generiert werden.
        Line start = new Line();

        // Liste mit den gespeicherten Koordinaten der Linien
        List<Line> lines = new ArrayList<>();

        /**
         * Muss man ausserhalb des MausEvents Linien und Punkte hinzufügen oder innerhalb?
         */
        drawingPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Line erste = new Line();
            erste.setStartX(event.getX());
            erste.setStartY(event.getY());
            erste.setStroke(Color.HOTPINK);

            // Über die mouseEvents auf die Linie zugreifen.
            // Linien start
        });

        /*
        drawingPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
            gc.closePath();
            gc.beginPath();
            gc.moveTo(event.getX(), event.getY());

            // Linie zielort
        });

        drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
            gc.closePath();

            // Liste füllen
        });

         */


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
