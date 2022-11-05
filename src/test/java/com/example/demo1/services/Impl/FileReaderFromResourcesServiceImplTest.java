package com.example.demo1.services.Impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FileReaderFromResourcesServiceImplTest {
    
    @Autowired
    FileReaderFromResourcesServiceImpl fileReaderFromResourcesService;

    @Test
    @DisplayName("Test IOException when reading non-existent file")
    public void whenIOExceptionThrown() {
        Exception exception = assertThrows(IOException.class, () -> {
            fileReaderFromResourcesService.readFromFile("in.txt");
        });
        String expectedMessage = "class path resource [in.txt] cannot be opened because it does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}