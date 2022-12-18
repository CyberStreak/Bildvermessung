package logic;

import javafx.scene.paint.Color;

public class ColorName {
    public Color color;
    public String label;

    public ColorName(Color c, String l) {
        this.color = c;
        this.label = l;
    }

    @Override
    public String toString() {
        return label;
    }
}
