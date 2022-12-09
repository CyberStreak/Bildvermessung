package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import logic.DrawAngle;

import java.util.ArrayList;

public class GraphicPane extends StackPane {
    ArrayList<Line> lines; // kann man diese Liste einer anderen Klasse geben?
    private final ImageView iv1;
    double x1 = 0;
    double y1 = 0;
    double x2 = 0;
    double y2 = 0;
    int clicks = 1;

    public GraphicPane() {
        // create a Pane for drawing
        this.iv1 = new ImageView();
        Pane drawingPane = new Pane();
        Button clear = new Button("Zeichnung bereinigen");
        Label anzeige = new Label("");
        drawingPane.setStyle("-fx-background-color: red");
        drawingPane.getChildren().add(iv1);

        // Settings for the image
        this.iv1.setFitHeight(750);
        this.iv1.setFitWidth(750);
        // image.getWidth() / iv1.getWidth() * imageGenerator.getResolution() * gemessenePixel
        this.iv1.setSmooth(true);
        this.iv1.setPreserveRatio(true);
        this.iv1.setCache(true);

        // Liste mit den gespeicherten Koordinaten der Linien
        lines = new ArrayList<>();

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
            System.out.println(lines);
            drawingPane.getChildren().add(line);
            // Wo werden die Linien ausserhalb der Liste gespeichert?
        });

        /*
        -> verursacht andauernde Maus fehler beim reinen drüber fahren
        drawingPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    switch(clicks) {
                        case 1:
                            anzeige.setText("Bitte Eckpunkt des Winkels anwählen.");
                            x1 = event.getX();
                            y1 = event.getY();
                            clicks += 1;
                            System.out.println("Maus wurde 1mal gedrückt");
                        case 2:
                            anzeige.setText("Bitte Ende das Ende der zweiten linien wählen.");
                            x2 = event.getX();
                            y2 = event.getY();
                            clicks += 1;
                            System.out.println("Maus wurde 2mal gedrückt");
                        case 3:
                            clicks = 1;
                            DrawAngle angle = new DrawAngle(x1, y1, x2, y2, event.getX(), event.getY());
                            drawingPane.getChildren().add(angle);
                            break;
                    }
        });
         */

        clear.setOnAction(event -> {
            drawingPane.getChildren().clear();
            drawingPane.getChildren().add(iv1);
            lines.clear();
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
