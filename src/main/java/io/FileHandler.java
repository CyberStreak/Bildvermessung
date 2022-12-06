package io;

import java.io.File;
import java.io.FileNotFoundException;



public class FileHandler {

    public static void readFile(File file) {
        if(file == null) {
            return;
        }

        String ext = FileHandler.getExtension(file);
        ImageDataReader reader = null;

        if(!ext.isEmpty()) {
            if(ext == "json") {
                reader = new JsonReaderImage();
            }
            else if(ext == "txt") {
                reader = new TxtReaderImage(file);
            }
            // use else if to add more readers
        }

        if(reader != null)
        {
            try {
                reader.read(file.getName());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String getExtension(File file) {
        String fileName = file.getName();
        System.out.print(fileName);
        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            return fileName.substring(index).toLowerCase();
        }

        return "";
    }
}
