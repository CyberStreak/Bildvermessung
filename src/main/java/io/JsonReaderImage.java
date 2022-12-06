package io;
import java.io.FileNotFoundException;
import java.io.FileReader;

import logic.ImageGenerator;
import org.json.simple.parser.JSONParser;


import java.util.Optional;

//import javax.json.stream.JsonParser;
//import javax.json.stream.JsonParser.Event;


public class JsonReaderImage implements ImageDataReader {
    JSONParser parser = new JSONParser();

    // Das hat es vorgeschlagen, weiss nicht ob es wirklich gebraucht wird.
    @Override
    public Optional<ImageGenerator> readData() {
        return Optional.empty();
    }

    @Override
    public void read(String fileName) throws FileNotFoundException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(".\\data\\test-image-01.json");

        //Object obj=jsonparser.parse(reader);

        //JSONObject testjsonobj=(JSONObject)obj;

        //String descr=(String) testjsonobj.get("description");




    }
}
