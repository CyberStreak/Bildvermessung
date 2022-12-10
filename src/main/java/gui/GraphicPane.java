package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import logic.DrawAngle;

import java.util.ArrayList;

public class GraphicPane extends StackPane {
    ArrayList<Line> lines; // How can we access this List in another class? For computing the lengths for example.
    private final ImageView iv1;
    // should this variables be private?
    double x1 = 0;
    double y1 = 0;
    double x2 = 0;
    double y2 = 0;
    private int clicks = 1;

    public GraphicPane() {
        // create a Pane for drawing
        this.iv1 = new ImageView();
        Pane drawingPane = new Pane();
        Button clear = new Button("Zeichnung bereinigen");
        Label anzeige = new Label("");

        // setting for the pane
        drawingPane.setStyle("-fx-background-color: red");
        drawingPane.getChildren().add(iv1);

        // Settings for the image
        // image resizes itself to the pane and gets smaller with it, but it doesn't get bigger anymore
        this.iv1.setSmooth(true);
        this.iv1.setPreserveRatio(true);
        this.iv1.setCache(true);
        this.iv1.fitHeightProperty().bind(drawingPane.heightProperty());
        this.iv1.fitWidthProperty().bind(drawingPane.widthProperty());
        //image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel

        // list for the coordinates of the line
        lines = new ArrayList<>();

        // First created Line here, didn't work properly -> comments line 63

        // Set the starting point of the line when the user presses the mouse button
        drawingPane.setOnMousePressed(event -> {
            x1 = event.getX();
            y1 = event.getY();
        });

        /*
        // Set the ending point of the line and the settings
        drawingPane.setOnMouseDragged(event -> {
            // When the line is created external and the setting are set up here the window and image resizes itself,
            // but it gets an error code and just one line is visible
        });
         */

        // Add the line to the pane and list
        drawingPane.setOnMouseReleased(event -> {
            // Create a Line
            Line line = new Line();
            line.setStartX(x1);
            line.setStartY(y1);
            line.setEndX(event.getX());
            line.setEndY(event.getY());
            line.setStrokeWidth(2);
            line.setStroke(Color.YELLOWGREEN);
            drawingPane.getChildren().add(line);
            lines.add(line);
            System.out.println(lines);
        });

        // The two mouse events don't get along with each other, as the mouse is released it generates a line,
        // played around with the DRAGGED gesture look at the comments at line 63
        // Maybe the DrawAngle constructor should connect Points? Or should the line drawing be handled different?
        // Handle mouse clicks for drawing angles
        drawingPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            switch (clicks) {
                case 1 -> {
                    anzeige.setText("Bitte Eckpunkt des Winkels anwählen.");
                    x1 = event.getX();
                    y1 = event.getY();
                    clicks += 1;
                    System.out.println("Maus wurde 1mal gedrückt");
                }
                case 2 -> {
                    anzeige.setText("Bitte Ende das Ende der zweiten linien wählen.");
                    x2 = event.getX();
                    y2 = event.getY();
                    clicks += 1;
                    System.out.println("Maus wurde 2mal gedrückt");
                }
                case 3 -> {
                    DrawAngle angle = new DrawAngle(x1, y1, x2, y2, event.getX(), event.getY());
                    drawingPane.getChildren().add(angle);
                    clicks = 1;
                }
            }
        });

        clear.setOnAction(event -> {
            drawingPane.getChildren().clear();
            drawingPane.getChildren().add(iv1);
            clicks = 1;
            lines.clear();
            anzeige.setText("");
        });

        // arrangement of the components
        HBox hBox = new HBox();
        hBox.getChildren().addAll(clear, anzeige);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        hBox.autosize();
        VBox box = new VBox();
        box.getChildren().addAll(drawingPane,hBox);
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
