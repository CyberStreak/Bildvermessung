package logic;

import javafx.scene.shape.Line;

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

        // Swap values if the 2nd one of each pair is smaller
        double temp;

        if (x1 > x2){
            temp = x1;
            x1 = x2;
            x2 = temp;
        }

        if (x3 > x4){
            temp = x3;
            x3 = x4;
            x4 = temp;
        }

        if (y1 > y2){
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        if (y3 > y4){
            temp = y3;
            y3 = y4;
            y4 = temp;
        }

        // Calculate the angle of line1 using the atan2 function
        double angle1 = Math.atan2(y2 - y1, x2 - x1);
        System.out.println("Angle 1 = " + Math.toDegrees(angle1));

        // Calculate the angle of line2 using the atan2 function
        double angle2 = Math.atan2(y4 - y3, x4 - x3);
        System.out.println("Angle 2 = " + Math.toDegrees(angle2));

        // Swap angles if they are not in ascending order
        if (angle1 > angle2){
            temp = angle1;
            angle1 = angle2;
            angle2 = temp;
        }

        // Subtract the two angles to find the angle between the lines
        double angleBetween = angle1 - angle2;

        // Convert the angle from radians to degrees
        return Math.abs(Math.toDegrees(angleBetween));
    }

    // calculate the length of a single line
    public static double calculateLineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
