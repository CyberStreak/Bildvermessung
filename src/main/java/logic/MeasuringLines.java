package logic;

import gui.GraphicPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class MeasuringLines {
    ArrayList<Line> lines = GraphicPane.getLines();

    public double lineLength(Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to measure each line in the array list
    public void measureLines() {
        for (Line line : lines) {
            double length = lineLength(line);
            System.out.println("Length of line: " + length);
        }
    }

    // Method to measure the total length of the lines in the array, needed to compute the scope
    public double totalLength() {
        double total = 0;
        for (Line line : lines) {
            double length = lineLength(line);
            total += length;
        }
        return total;
    }
}
