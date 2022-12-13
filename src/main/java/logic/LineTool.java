package logic;

import gui.MainPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LineTool implements iTool {
    // stores the current Line that is being drawn or previously was drawn
    private Line currentLine = null;
    // Länge der Linie wird gebraucht um vergleich ziehen zu können
    // private double length = 0;

    @Override
    public void onMouseRelease(MouseEvent event, Pane drawingPane) {
        // calculates the length of the drawn line
        double measuredPixels = CalculationUtil.calculatelineLength(currentLine);
        // Imageview from the GraphicsPane for calculating the effective real world length
        ImageView view = MainPane.Instance.getGraphicPane().getImageView();
        // ImageGenerator from the GraphicsPane for calculating the effective real world length
        ImageGenerator generator = MainPane.Instance.getCurrentImageGenerator();

        if ( view != null && generator != null) {
            // calculate the size relation between on disk size and display size and multiply it by the ratio from the meta file
            // and by the amount of pixels measured from the line
            double length = generator.getImg().getWidth() / view.getFitWidth() * generator.getResolution() * measuredPixels;
            // Update the display text
            MainPane.Instance.getGraphicPane().changeDisplayText("Länge: " + (float) length + " " + generator.getResolutionUnit());
        }
        else {
            System.out.println("Could not calculate line because either ImageView or ImageGenerator are null");
        }
    }

    @Override
    public void onMouseClicked(MouseEvent event, Pane drawingPane) {

    }

    @Override
    public void onMousePressed(MouseEvent event, Pane drawingPane) {
        // remove the previous line from the drawing Pane
        if(currentLine != null) {
            drawingPane.getChildren().remove(currentLine);
        }

        // generate and add a new line starting from the mouse position
        currentLine = new Line();
        drawingPane.getChildren().add(currentLine);
        currentLine.setStartX(event.getX());
        currentLine.setStartY(event.getY());
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
        currentLine.setStrokeWidth(4);
        currentLine.setStroke(javafx.scene.paint.Color.LIGHTGREEN);
    }

    @Override
    public void onMouseDragged(MouseEvent event, Pane drawingPane) {
        // while draggin update the end point to the mouse position
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
    }

    @Override
    public void onCleanUp(Pane drawingPane) {
        // remove the drawn line from the drawing Pane
        if(currentLine != null) {
            drawingPane.getChildren().remove(currentLine);
        }
    }
}
