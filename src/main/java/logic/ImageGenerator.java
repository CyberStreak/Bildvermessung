package logic;

import javafx.scene.image.Image;

public class ImageGenerator {
    private final Image img;
    private final String description;
    private final String imageFile;
    private final Double resolution;
    private final String resolutionUnit;

    public ImageGenerator(String description, String imageFile, Double resolution, String resolutionUnit) {
        this.description = description;
        this.imageFile = imageFile;
        this.resolution = resolution;
        this.resolutionUnit = resolutionUnit;
        img = new Image("file:" + imageFile);
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

    public Double getResolution() {
        return resolution;
    }

    public String getResolutionUnit() { return resolutionUnit; }
}
