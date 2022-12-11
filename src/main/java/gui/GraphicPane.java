package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import logic.LineTool;
import logic.iTool;

import java.util.ArrayList;

public class GraphicPane extends StackPane {
    static ArrayList<Line> lines; // How can we access this List in another class? For computing the lengths for example.
    private final ImageView iv1;
    private Label DisplayLabel;
    // the currently used tool
    private iTool tool;
    private Pane drawingPane;

    public GraphicPane() {
        // create a Pane for drawing
        this.iv1 = new ImageView();
        drawingPane = new Pane();
        Button clear = new Button("Zeichnung bereinigen");
        DisplayLabel = new Label("");
        tool = new LineTool();

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


        // connect the mouse events from the drawing pane to the currently used tool
        drawingPane.setOnMouseReleased(event -> {tool.onMouseRelease(event, drawingPane);});
        drawingPane.setOnMouseClicked(event -> {tool.onMouseClicked(event, drawingPane);});
        drawingPane.setOnMousePressed(event -> {tool.onMousePressed(event, drawingPane);});
        drawingPane.setOnMouseDragged(event -> {tool.onMouseDragged(event, drawingPane);});

        clear.setOnAction(event -> {
            drawingPane.getChildren().clear();
            drawingPane.getChildren().add(iv1);
            lines.clear();
            DisplayLabel.setText("");
        });

        // arrangement of the components
        HBox hBox = new HBox();
        hBox.getChildren().addAll(clear, DisplayLabel);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        hBox.autosize();
        VBox box = new VBox();
        box.getChildren().addAll(drawingPane,hBox);
        box.setAlignment(Pos.CENTER);
        box.autosize();
        this.getChildren().add(box);
    }

    public static ArrayList<Line> getLines() {
        return lines;
    }

    public void setImage(Image image) {
        if(image != null) {
            iv1.setImage(image);
        }
    }

    // updates the display text
    public void changeDisplayText(String text) {
        DisplayLabel.setText(text);
    }

    // changes currently used tool
    public void changeTool(iTool tool) {
        // if previous tool is not null -> call the cleanup method
        // to remove unused lines for example
        if (this.tool != null) {
            this.tool.onCleanUp(drawingPane);
        }
        // assign the new tool
        this.tool = tool;
    }

    public ImageView getImageView() {
        return iv1;
    }
}
