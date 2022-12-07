package gui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import logic.ImageGenerator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GraphicPane extends StackPane {
    private ImageGenerator imageGenerator;
    private ImageView iv1;
    private Canvas canvas;
    static GraphicsContext gc;

    public GraphicPane() {
        canvas = new Canvas(500, 750);
        gc = canvas.getGraphicsContext2D();

        iv1 = new ImageView();
        iv1.setFitHeight(750);
        iv1.setFitWidth(500);
        // image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel
        iv1.setSmooth(true);
        iv1.setPreserveRatio(true);
        iv1.setCache(true);

        /**
         * Muss man ausserhalb des MausEvents Linien und Punkte hinzufügen oder innerhalb?
         */
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gc.beginPath();
                gc.moveTo(event.getX(), event.getY());
                gc.stroke();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
                gc.closePath();
                gc.beginPath();
                gc.moveTo(event.getX(), event.getY());
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
                gc.closePath();
            }
        });

        VBox box = new VBox(iv1);
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
