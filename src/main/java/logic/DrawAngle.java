package logic;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class DrawAngle extends Node {
    // Was für Variablen braucht es? -> Line oder Liste
    Line line1;
    Line line2;

    public DrawAngle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        this.line1 = line;
        Line line2 = new Line();
        line2.setStartX(x2);
        line2.setStartY(y2);
        line2.setEndX(x3);
        line2.setEndY(y3);
        this.line2 = line2;
        line.setStroke(Color.YELLOWGREEN);
        line2.setStroke(Color.YELLOWGREEN);
    }

    /*
    public double getDegree(double length1, double length2) {
        return double degree;
    }
    */

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

