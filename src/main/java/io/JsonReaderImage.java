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

public class JsonReaderImage implements ImageDataReader {

    @Override
    public Optional<ImageGenerator> read(File file) throws FileNotFoundException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(file.getAbsolutePath());

        Object obj;
        try {
            obj = jsonparser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject imgJsonobj = (JSONObject)obj;

        // read file metadata
        String description = (String) imgJsonobj.get("description");
        String image_file = (String) imgJsonobj.get("image_file");
        Double image_resolution = (Double) imgJsonobj.get("image_resolution");
        String image_resolution_unit = (String) imgJsonobj.get("image_resolution_unit");

        // pass the strings back to the calling Class
        ImageGenerator image = new ImageGenerator(description, file.getParent() + File.separator + image_file, image_resolution, image_resolution_unit);
        return Optional.of(image);

    }
}
