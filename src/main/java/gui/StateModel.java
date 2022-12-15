package gui;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class StateModel {
    /**
     * not really sure what I am doing... but it works with some errors
     * how can we resolve the static problem?
     * how can we add non methods to the observers?
     * where do you have to add the StateModel? In the tools or in the panes?
     */
    private static Color color;
    private static double strokeWidth;
    private final List<StateObserver> observers;

    public StateModel() {
        observers = new ArrayList<>();
    }

    public static void setColor(Color color) {
        StateModel.color = color;
        //sendChange();
    }

    public static Color getColor() {
        return color;
    }

    public static void setStrokeWidth(double strokeWidth) {
        StateModel.strokeWidth = strokeWidth;
        //sendChange();
    }

    public static double getStrokeWidth() {
        return strokeWidth;
    }

    public void addObserver(StateObserver observer) {
        observers.add(observer);
    }

    /*
    private static void sendChange() {
        for (StateObserver observer : observers) {
            observer.stateChanged();
        }
    }
     */
}
