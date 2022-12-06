package io;

import javafx.scene.image.Image;

public class ImageGenerator {

    // nicht sicher ob Bild hier generiert werden soll oder doch lieber in einer seperaten Klasse..
    Image img = new Image("C:\\Users\\milic\\IdeaProjects\\praktikum-programmieren-ii\\src\\main\\java\\data" + getImageFile());

    private final String description;
    private final String imageFile;
    private final String resolution;

    public ImageGenerator(String description, String imageFile, String resolution) {
        this.description = description;
        this.imageFile = imageFile;
        this.resolution = resolution;
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

    public String getResolution() {
        return resolution;
    }

    // Methode schreiben um die Masseinheit und den Wert aus der resolution zu trennen..


}
