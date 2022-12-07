package logic;

import javafx.scene.image.Image;

public class ImageGenerator {

    /**
     * Herr Bordbeck hat das Bild auch hier erstellen lasse.
     * Ist allerdings umständlicher mit dem Umgang in der cmd Zeile, javafx muss immer mitgegeben werden.
     * Muss evtl. für die mögliche Ausführung auf der cmd Zeile umgeschrieben werden.
     */
    private final Image img = new Image("C:\\Users\\milic\\IdeaProjects\\praktikum-programmieren-ii\\src\\main\\java\\data" + getImageFile());

    // Besprochene änderung hinzugefügt, TxtReader muss angepasst werden.
    private final String description;
    private final String imageFile;
    private final double resolution;
    private final String resolutionUnit;

    public ImageGenerator(String description, String imageFile, double resolution, String resolutionUnit) {
        this.description = description;
        this.imageFile = imageFile;
        this.resolution = resolution;
        this.resolutionUnit = resolutionUnit;
    }

    public Image getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public String getImageFile() {
        return imageFile;
    }

    public double getResolution() {
        return resolution;
    }

    public String getResolutionUnit() {
        return resolutionUnit;
    }
}
