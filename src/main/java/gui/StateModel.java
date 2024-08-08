package gui;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class StateModel {
    private Color color;
    private double strokeWidth;
    private final List<StateObserver> observers;
    private double imgHeight;
    private double imgWidth;

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

    public void setImgWidth(double width) {
        this.imgWidth = width;
        sendChange();
    }

    public double getImgWidth() {
        return imgWidth;
    }

    public void setImgHeight(double height) {
        this.imgHeight = height;
        sendChange();
    }

    public double getImgHeight() {
        return imgHeight;
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
