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
            // if clauses with == didn't work !!! See change below with if(ext.equals ()
            if(ext.equals(".json")) {
                //Checkpoint!
                System.out.println("We're passing this file to the JsonReaderImage class now: "+file);
                // We need to prove that the 'file' variable passed to JSonReaderImage makes it there (see comment and Checkpoint there)!!!
                reader = new JsonReaderImage();

            }
            else if(ext.equals(".txt")) {

                //Checkpoint!
                System.out.println("We're passing this file to the TxtReaderImage class now: "+file);
                // We need to prove that the 'file' variable passed to TxtReaderImage makes it there (insert a System.out to check).
                reader = new TxtReaderImage();
            }
            // use else if to add more filetypes pointing to their TO BE DEVELOPED readers
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
        System.out.println("Filename used in FileHandler.getExtension: "+fileName);
        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            return fileName.substring(index).toLowerCase();
        }

        return "";
    }
}
