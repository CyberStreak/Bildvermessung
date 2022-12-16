package io;

import logic.ImageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;


public class FileHandler {

    public static ImageGenerator readFile(File file) {
        if(file == null) {
            return null;
        }
        String ext = FileHandler.getExtension(file);
        ImageDataReader reader = null;

        if(!ext.isEmpty()) {
            if(ext.equals(".json")) {
                reader = new JsonReaderImage();
            }

            else if(ext.equals(".txt")) {
                reader = new TxtReaderImage();
            }
        }

        if(reader != null)
        {
            try {
                Optional<ImageGenerator> imageOptional = reader.read(file);
                if (imageOptional.isPresent()) {
                    return imageOptional.get();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    // checking the file extension for the needed reader
    private static String getExtension(File file) {
        String fileName = file.getName();

        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            return fileName.substring(index).toLowerCase();
        }

        return "";
    }
}
