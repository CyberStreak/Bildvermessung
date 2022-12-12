package io;

import logic.ImageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class TxtReaderImage implements ImageDataReader {
    // Daten aus dem Text lesen.
    @Override
    public Optional<ImageGenerator> read(File file) {

        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
            return Optional.empty();
        }

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