package io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TxtReaderImageTest {

    @Test
    void getImage() {
        TxtReaderImage reader = new TxtReaderImage():
        reader.read(new File("data/test-image-01.txt"));
        // wie kann man die einzelnen Variablen der Klasse testen?
        // wie hat man zugriff?
        assertEquals();
    }

    @Test
    void fileNotFound() {
        TxtReaderImage reader = new TxtReaderImage();
        // File wurde nicht gefunden, zeigt aber einen falschen Test an.
        // wie überprüft man Files?
        assertThrows(FileNotFoundException.class, () -> reader.read(new File("")));
    }
}