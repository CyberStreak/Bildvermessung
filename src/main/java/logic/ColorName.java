package logic;

import javafx.scene.paint.Color;

public class ColorName {
    public Color color;
    public String label;

    // constructor to set the cells of the comboBox
    public ColorName(Color c, String l) {
        this.color = c;
        this.label = l;
    }

    // toString method to display the text of the color
    @Override
    public String toString() {
        return label;
    }
}
