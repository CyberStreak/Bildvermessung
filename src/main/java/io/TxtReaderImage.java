package io;

import logic.ImageGenerator;

import javax.imageio.ImageReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class TxtReaderImage implements ImageDataReader {

    // Daten aus dem Text lesen.

    public Optional<ImageGenerator> readData() {
        /**
         * Reader um .txt Dateien lesen zu können
         * @return Das Bild als Objekt.
         */
        /*Scanner fileScanner;
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
        /*String description = "";
        String imageFile = "";
        String resolution = "";
        while (fileScanner.hasNextLine()) {
            description = fileScanner.nextLine().split("description:")[1].trim();
            imageFile = fileScanner.nextLine().split("image-file:")[1].trim();
            resolution = fileScanner.nextLine().split("resolution:")[1].trim();
        }
        //ImageGenerator image = new ImageGenerator(description, imageFile, resolution, "");
        return Optional.of(image);*/
        return null;
    }
    @Override
    public Optional<ImageGenerator> read(File file) {

        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
            return Optional.empty();
        }

        /**
         * .txt Dateien sind nicht gleich aufgebaut.
         * Methode muss durchlaufen bis alle Variablen gefüllt sind oder mit if statements nach den Schlagwörtern suchen.
         */
        String description = "";
        String imageFile = "";
        //String resolution = "";
        String fileContent = "";
        while (fileScanner.hasNextLine()) {
            fileContent += fileScanner.nextLine() + "\n";
        }

        //System.out.print(resolution);

        String[] resolutionArray = getValue("resolution: ", fileContent).split(" ");
        Double resolution = 0.0;
        String resolutionUnit = "";
        if(resolutionArray.length == 2) {
            resolution = Double.parseDouble(resolutionArray[0]);
            resolutionUnit = resolutionArray[1];
        }

        // Für alle Betriebssysteme möglich -> File.seperator
        String filePath = file.getParent() + File.separator + getValue("image-file: ", fileContent);
        // image-file:
        ImageGenerator image = new ImageGenerator(getValue("description: ", fileContent),
                                                  filePath,
                                                  resolution,
                                                  resolutionUnit);
        return Optional.of(image);
    }

    private String getValue(String key, String str) {
        String[] sArray = str.split(key);
        if(sArray.length == 2) {
            String right = sArray[1];
            return right.split("\\n")[0];
        }

        return null;
    }
}