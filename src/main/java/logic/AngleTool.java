package logic;

import gui.MainPane;
import gui.StateModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class AngleTool implements iTool{
    // stores the two lines
    private Line line1 = null;
    private Line line2 = null;
    // stores the current line (line1 or line2) which the user is currently drawing
    private Line currentLine = null;

    // stores the state, 0 = not started, 1 = the first line has been started drawing, 2 = second line has been started drawing
    private int state = 0;
    @Override
    public void onMouseRelease(MouseEvent event, Pane drawingPane) {
        // if we are done drawing the second line
        if(state == 2) {
            // reset state
            state = 0;
            // update display text to the measured angle
            float Angle = (float)CalculationUtil.calculateAngel(line1, line2);
            float Complement = 360 - Angle;
            MainPane.Instance.getGraphicPane().changeDisplayText("Winkel zwischen den Linien: " + Angle+" | "+Complement);
        }
    }

    @Override
    public void onMouseClicked(MouseEvent event, Pane drawingPane) {

    }

    @Override
    public void onMousePressed(MouseEvent event, Pane drawingPane) {
        // if we just started drawing the first line
        if(state == 0) {
            // remove previous drawn lines
            if(line1 != null) {
                drawingPane.getChildren().remove(line1);
            }
            // remove previous drawn lines
            if(line2 != null) {
                drawingPane.getChildren().remove(line2);
            }
            // generate a new line starting from mouse position
            line1 = generateLine(event.getX(), event.getY(), event.getX(), event.getY());
            currentLine = line1;
        }
        // if first line already has been drawn
        else if(state == 1) {
            // generate second line
            line2 = generateLine(line1.getEndX(), line1.getEndY(), event.getX(), event.getY());
            currentLine = line2;
        }

        // add line to the drawing pane (either line1 or line2)
        drawingPane.getChildren().add(currentLine);
        // increase the state by one
        state++;
    }

    @Override
    public void onMouseDragged(MouseEvent event, Pane drawingPane) {
        // update the endpoint of the line while dragging
        currentLine.setEndX(event.getX());
        currentLine.setEndY(event.getY());
        System.out.println("Line length: "+CalculationUtil.calculateLineLength(currentLine));
    }

    @Override
    public void onCleanUp(Pane drawingPane) {
        // delete all previously drawn lines
        if(line1 != null) {
            drawingPane.getChildren().remove(line1);
        }

        if(line2 != null) {
            drawingPane.getChildren().remove(line2);
        }
    }

    // generates a new line
    private Line generateLine(double x1, double y1, double x2, double y2) {
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        line.setStrokeWidth(StateModel.getStrokeWidth());
        line.setStroke(StateModel.getColor());
        return line;
    }
}
