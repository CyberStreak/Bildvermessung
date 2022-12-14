package io;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void readFile() {
        File dataFile = new File(".\\data\\test-image-05.json");

        // Test 1: Check filename
        assertEquals("test-image-05.json", dataFile.getName());
    }
}