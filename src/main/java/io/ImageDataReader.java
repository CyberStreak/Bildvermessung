package io;

import logic.ImageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

public interface ImageDataReader {
    Optional<ImageGenerator> readData();

    Optional<ImageGenerator> read(File file) throws FileNotFoundException;
}
