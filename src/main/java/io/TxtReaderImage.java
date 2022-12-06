package io;

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

        // FileNotFoundException
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(imageData);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + imageData.getAbsolutePath());
            return Optional.empty();
        }

        // .txt Datein sind nicht gleich aufgebaut Methode kann sich so nicht immmer wiederholen.
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

    @Override
    public void read(String fileName) {

    }
}