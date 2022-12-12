package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Optional;

import logic.ImageGenerator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import javax.json.stream.JsonParser;
//import javax.json.stream.JsonParser.Event;

public class JsonReaderImage implements ImageDataReader {

    JSONParser parser = new JSONParser();

    @Override
    public Optional<ImageGenerator> read(File file) throws FileNotFoundException {
        // Checkpoint to make sure the call from FileHandler hits here
        // ... and it does. POSSIBLE PROBLEM: fileName doesn't have the path anymore
        System.out.println("We're in the JSON Reader now, the file name is: "+ file.getName());

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(file.getAbsolutePath());

        Object obj = null;
        try {
            obj = jsonparser.parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject imgJsonobj = (JSONObject)obj;

        // The next 8 lines of code are proving that we read the files correctly
        String description = (String) imgJsonobj.get("description");
        String image_file = (String) imgJsonobj.get("image_file");
        Double image_resolution = (Double) imgJsonobj.get("image_resolution");
        String image_resolution_unit = (String) imgJsonobj.get("image_resolution_unit");

        // ... and also we can access these variables
        System.out.println("description: "+description);
        System.out.println("image_file: "+image_file);
        System.out.println("image_resolution: "+image_resolution);
        System.out.println("image_resolution_unit: "+image_resolution_unit);

        //NOW: these strings need to be passed back to the calling Classes (is it FileHandler.java???)
        //IMPORTANT NOTE: Class ImageGenerator may have the following issues:
        // (1) image_resolution_unit (String!) missing: needed to calculate what one pixel means
        // (2) image_resolution currently is a String: can this be changed to Double?

        // By fixing (1) & (2) above, these may work pico bello:
         ImageGenerator image = new ImageGenerator(description, file.getParent() + File.separator + image_file, image_resolution, image_resolution_unit);
        return Optional.of(image);

    }
}
