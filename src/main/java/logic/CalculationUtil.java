package logic;

import gui.GraphicPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class CalculationUtil {
    public static double calculateAngel(Line line1, Line line2) {
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
        return Math.toDegrees(angleBetween);
    }

    public static double calculatelineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
