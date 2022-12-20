package logic;

import javafx.scene.shape.Line;

public class CalculationUtil {

    // calculate the length of a single line
    public static double calculateLineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // calculate the angle of two lines
    public static double calculateAngle(Line line1, Line line2) {
        return Math.toDegrees(Math.acos(dotProduct(line1, line2)/(calculateLineLength(line1) * calculateLineLength(line2))));
    }

    // dotProduct for the angle calculation
    public static double dotProduct(Line line1, Line line2) {
        double x1 = line1.getEndX() - line1.getStartX();
        double y1 = line1.getEndY() - line1.getStartY();
        double x2 = line2.getEndX() - line2.getStartX();
        double y2 = line2.getEndY() - line2.getStartY();

        return x1 * x2 + y1 * y2;
    }
}
