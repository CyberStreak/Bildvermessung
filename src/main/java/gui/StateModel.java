package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.ArrayList;
import java.util.List;

public class StateModel {
    /**
     * Not really sure what I am doing...
     */
    private Line line;
    private final List<StateObserver> observers;

    public StateModel() {
        observers = new ArrayList<>();
    }

    public void setColor(Color color) {

        line.setStroke(color);
        sendChange();
    }

    public void setStrokeWidth(double strokeWidth) {
        line.setStrokeWidth(strokeWidth);
        sendChange();
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
