package logic;

import javafx.scene.shape.Line;

import java.util.ArrayList;

public class MeasuringLines {
    // Was für Variablen braucht es? Line oder Liste
    Line line;

    public MeasuringLines(Line line) {
        this.line = line;
    }

    public double lineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
