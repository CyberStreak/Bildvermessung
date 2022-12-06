package io;

import logic.ImageGenerator;

import java.io.FileNotFoundException;
import java.util.Optional;

public interface ImageDataReader {
    Optional<ImageGenerator> readData();

    void read(String fileName) throws FileNotFoundException;
}
