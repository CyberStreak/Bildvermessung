package logic;

import javafx.scene.image.Image;

public class ImageGenerator {

    /**
     * Herr Bordbeck hat das Bild auch hier erstellen lasse.
     * Ist allerdings umständlicher mit dem Umgang in der cmd Zeile, javafx muss immer mitgegeben werden.
     * Muss evt. für die mögliche Ausführung auf der cmd Zeile umgeschrieben werden.
     */
    private final Image img = new Image("C:\\Users\\milic\\IdeaProjects\\praktikum-programmieren-ii\\src\\main\\java\\data" + getImageFile());

    /**
     * Die benötigten Daten aus dem Text
     */
    private final String description;
    private final String imageFile;
    private final String resolution;

    // Konstruktor der Klasse
    public ImageGenerator(String description, String imageFile, String resolution) {
        this.description = description;
        this.imageFile = imageFile;
        this.resolution = resolution;
    }

    // Getter Methoden
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

    // Methode schreiben um die Masseinheit und den Wert aus der resolution zu trennen.
    // String tokenizer könnte eine Lösung sein


}
