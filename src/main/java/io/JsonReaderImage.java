package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Optional;
import java.util.Scanner;

import logic.ImageGenerator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        // This is our checkpoint to see if the call from FileHandler works (currently not).
        System.out.println("We're in the JSON Reader now, the file name is: "+fileName);

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(fileName);

        //Object obj=jsonparser.parse(reader);
        //JSONObject testjsonobj=(JSONObject)obj;
        //String descr=(String) testjsonobj.get("description");

    }
}
