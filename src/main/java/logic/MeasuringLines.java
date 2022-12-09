package logic;

import javafx.scene.shape.Line;

public class MeasuringLines {
    // Was für Variablen braucht es? Line oder Liste
    Line line;

    public MeasuringLines(Line line1) {
        this.line = line1;
    }

    public double measuringLines(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        double x = x1 - x2;
        double y = y1 - y2;
        return Math.sqrt(x + y);
    }
}
