package io;

import logic.ImageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class TxtReaderImage implements ImageDataReader {
    private final File imageData;

    // Konstruktor der Klasse
    public TxtReaderImage(File imageData) {
        this.imageData = imageData;
    }

    /**
     * Reader um .txt Dateien lesen zu können
     * @return Das Bild als Objekt.
     */
    @Override
    public Optional<ImageGenerator> readData() {

        // FileNotFoundException
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(imageData);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + imageData.getAbsolutePath());
            return Optional.empty();
        }


        /**
         * .txt Dateien sind nicht gleich aufgebaut.
         * Methode muss durchlaufen bis alle Variablen gefüllt sind oder mit if statements nach den Schlagwörtern suchen.
         */
        String description = "";
        String imageFile = "";
        String resolution = "";
        while (fileScanner.hasNextLine()) {
            description = fileScanner.nextLine().split("description:")[1].trim();
            imageFile = fileScanner.nextLine().split("image-file:")[1].trim();
            resolution = fileScanner.nextLine().split("resolution:")[1].trim();
        }
        ImageGenerator image = new ImageGenerator(description, imageFile, resolution);
        return Optional.of(image);
    }

    /**
     * Muss man hier was anpassen? Wie kan das zusammenspiel funktionieren?
     * @param fileName -> Wird der Name des Files mitgegeben oder das ganze File?
     */
    @Override
    public void read(String fileName) {

    }
}