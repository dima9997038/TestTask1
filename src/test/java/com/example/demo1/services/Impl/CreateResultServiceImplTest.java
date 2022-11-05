package com.example.demo1.services.Impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CreateResultServiceImplTest {
    @Autowired
    CreateInformationAboutVowelsImpl createInformationAboutVowels;
    @Autowired
    GetListFromStringImpl getListFromString;

    @Test
    @DisplayName("Test converting input string into output string")
    void getResultShouldReturnGrouperVowels() {
        CreateResultServiceImpl createResultService = new CreateResultServiceImpl(createInformationAboutVowels, getListFromString);
        List<String> result = createResultService.getResult("Platon made bamboo boats.");
        assertEquals(result.toString(), "[({a, o},6)->2.5, ({a, o},5)->2.0, ({a, e},4)->2.0]");
        List<String> result1 = createResultService.getResult("Hello World!!!");
        assertEquals(result1.toString(), "[({e, o},5)->2.0, ({o},5)->1.0]");
        List<String> result2 = createResultService.getResult("Java program");
        assertEquals(result2.toString(), "[({a, o},7)->2.0, ({a},4)->2.0]");
    }
}