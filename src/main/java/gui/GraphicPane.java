package gui;

import logic.ImageGenerator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GraphicPane extends StackPane {
    private ImageGenerator imageGenerator;
    static GraphicsContext gc;

    public GraphicPane() {
        Canvas canvas = new Canvas(500, 750);
        gc = canvas.getGraphicsContext2D();

        ImageView iv1 = new ImageView();
        iv1.setImage(imageGenerator.getImg()); // imageGenerator ist null, Objekt kann aber nicht vor dem Lesen der Datei erstellt werden.
        iv1.setFitHeight(300);
        iv1.setFitWidth(500);
        iv1.setSmooth(true);
        iv1.setPreserveRatio(true);
        iv1.setCache(true);

        /**
         * Das Bild auf den canvas bringen und darauf zeichnen mit der Maus.
         */
        gc.drawImage(iv1.getImage(), 0, 500);

        /**
         * Muss man ausserhalb des MausEvents Linien und Punkte hinzufügen oder innerhalb?
         */
        canvas.setOnMouseClicked( event -> {
            gc.setStroke(Color.PAPAYAWHIP);
        });


        VBox box = new VBox();
        // Padding etc.
        this.getChildren().add(box);
    }

}
