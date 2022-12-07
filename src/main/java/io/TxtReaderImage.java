package io;

import logic.ImageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class TxtReaderImage implements ImageDataReader {

    // Das File der MetaDaten als Varibale
    private final File imageData;

    // Konstruktor der Klasse
    public TxtReaderImage(File imageData) {
        this.imageData = imageData;
    }

    // Daten aus dem Text lesen.
    @Override
    public Optional<ImageGenerator> readData() {

        /**
         * Reader um .txt Dateien lesen zu können
         * @return Das Bild als Objekt.
         */
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
         * resolution und resolutionUnit sollte hier getrennt werden.
         */
        String description = "";
        String imageFile = "";
        String resolution = "";
        while (fileScanner.hasNextLine()) {
            description = fileScanner.nextLine().split("description:")[1].trim();
            imageFile = fileScanner.nextLine().split("image-file:")[1].trim();
            resolution = fileScanner.nextLine().split("resolution:")[1].trim();
        }

        ImageGenerator image = new ImageGenerator(description, imageFile, resolution); // resolution wurde im ImageGenerator auf double angepasst.
        return Optional.of(image);
    }

    @Override
    public void read(String fileName) {
    }
}