package io;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface ImageDataReader {
    Optional<ImageGenerator> readData();

    void read(String fileName) throws FileNotFoundException;
}
