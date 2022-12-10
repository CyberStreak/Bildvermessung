package logic;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class DrawAngle extends Node {
    // Was für Variablen braucht es? -> Line, Liste oder variablen?
    Line line1;
    Line line2;

    public DrawAngle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        line.setStroke(Color.YELLOWGREEN);
        this.line1 = line;
        Line line2 = new Line();
        line2.setStartX(x2);
        line2.setStartY(y2);
        line2.setEndX(x3);
        line2.setEndY(y3);
        line2.setStroke(Color.YELLOWGREEN);
        this.line2 = line2;
    }

    public double lineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double angleBetweenLines(Line line1, Line line2) {
        double x1 = line1.getStartX();
        double y1 = line1.getStartY();
        double x2 = line1.getEndX();
        double y2 = line1.getEndY();
        double x3 = line2.getStartX();
        double y3 = line2.getStartY();
        double x4 = line2.getEndX();
        double y4 = line2.getEndY();

        // Calculate the angle of line1 using the atan2 function
        double angle1 = Math.atan2(y2 - y1, x2 - x1);

        // Calculate the angle of line2 using the atan2 function
        double angle2 = Math.atan2(y4 - y3, x4 - x3);

        // Subtract the two angles to find the angle between the lines
        double angleBetween = angle1 - angle2;

        // Convert the angle from radians to degrees
        double angleInDegrees = Math.toDegrees(angleBetween);

        return angleInDegrees;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

