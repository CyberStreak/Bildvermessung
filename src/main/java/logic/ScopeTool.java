package logic;

import gui.MainPane;
import gui.StateModel;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class ScopeTool implements iTool{
    private Line currentLine;
    private static final ArrayList<Line> lines = new ArrayList<>();

    public static ArrayList<Line> getLines() {
        return lines;
    }

    @Override
    public void onMousePressed(MouseEvent event, Pane drawingPane) {
        // generate and add a new line starting from the mouse position
        currentLine = new Line();
        drawingPane.getChildren().add(currentLine);
        currentLine.setStartX(event.getX());
        currentLine.setStartY(event.getY());
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
        currentLine.setStrokeWidth(StateModel.getStrokeWidth());
        currentLine.setStroke(StateModel.getColor());
    }

    @Override
    public void onMouseDragged(MouseEvent event, Pane drawingPane) {
        // while draggin update the end point to the mouse position
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
    }

    @Override
    public void onMouseRelease(MouseEvent event, Pane drawingPane) {
        // store the created lines in a list
        lines.add(currentLine);
        System.out.println(lines);

        // calculates the length of the drawn line
        double measuredPixels = totalLength(lines);

        // Imageview from the GraphicsPane for calculating the effective real world length
        ImageView view = MainPane.Instance.getGraphicPane().getImageView();
        // ImageGenerator from the GraphicsPane for calculating the effective real world length
        ImageGenerator generator = MainPane.Instance.getCurrentImageGenerator();

        if ( view != null && generator != null) {
            // calculate the size relation between on disk size and display size and multiply it by the ratio from the meta file
            // and by the amount of pixels measured from the line
            double length = generator.getImg().getWidth() / view.getFitWidth() * generator.getResolution() * measuredPixels;
            // Update the display text
            //MainPane.Instance.getGraphicPane().changeDisplayText("Länge: " + (float) length + " " + generator.getResolutionUnit());

            double kmeters = 0;
            double meters = 0;
            double cmeters = 0;
            double mmeters = 0;

            if (generator.getResolutionUnit().equals("mm")) {
                kmeters = (float) length/1000000;
                meters = (float) length/1000;
                cmeters = (float) length/10;
                mmeters = (float) length;
            }

            if (generator.getResolutionUnit().equals("cm")) {
                kmeters = (float) length/100000;
                meters = (float) length/100;
                cmeters = (float) length;
                mmeters = (float) length * 10;
            }

            if (generator.getResolutionUnit().equals("m")) {
                kmeters = (float) length/1000;
                meters = (float) length;
                cmeters = (float) length * 100;
                mmeters = (float) length * 1000;
            }
            if (generator.getResolutionUnit().equals("km")) {
                kmeters = (float) length;
                meters = (float) length * 1000;
                cmeters = (float) length * 100000;
                mmeters = (float) length * 1000000;
            }
            MainPane.Instance.getGraphicPane().changeDisplayText("Länge: \t" + String.format("%.3f", meters) + " m" + " | " + String.format("%.4f", kmeters) + " km | " + String.format("%.2f", cmeters) + " cm | " + String.format("%.1f", mmeters) + " mm");

        }
        else {
            System.out.println("Could not calculate line because either ImageView or ImageGenerator are null");
        }
    }

    @Override
    public void onMouseClicked(MouseEvent event, Pane drawingPane) {

    }

    @Override
    public void onCleanUp(Pane drawingPane) {// remove the drawn line from the drawing Pane
        if(currentLine != null) {
            drawingPane.getChildren().remove(currentLine);
            lines.clear();
        }
    }

    public double totalLength(ArrayList<Line> lines) {
        double total = 0;
        for (Line line : lines) {
            double length = CalculationUtil.calculateLineLength(line);
            total += length;
        }
        return total;
    }
}
