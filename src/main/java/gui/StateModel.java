package gui;

import javafx.scene.paint.Color;
import logic.iTool;

import java.util.ArrayList;
import java.util.List;

public class StateModel {
    /**
     * not really sure what I am doing... but it works with some errors
     * how can we resolve the static problem?
     * how can we add non methods to the observers?
     * where do you have to add the StateModel? In the tools or in the panes?
     */
    private Color color;
    private double strokeWidth;
    private final List<StateObserver> observers;
    // tools evt. auch im stateModel abspeichern
    //private iTool tool;

    public StateModel() {
        observers = new ArrayList<>();
    }

    public void setColor(Color color) {
        this.color = color;
        sendChange();
    }

    public Color getColor() {
        return color;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
        sendChange();
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void addObserver(StateObserver observer) {
        observers.add(observer);
    }

    private void sendChange() {
        for (StateObserver observer : observers) {
            observer.stateChanged();
        }
    }
}
