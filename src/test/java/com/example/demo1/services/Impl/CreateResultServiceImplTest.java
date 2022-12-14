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
        assertEquals(result.toString(), "[({a, o},5)->2.0, ({a, o},6)->2.5, ({a, e},4)->2.0]");
    }

    @Test
    @DisplayName("Test converting empty input string into output string")
    void getResultShouldReturnGrouperVowelsFromEmptyString() {
        CreateResultServiceImpl createResultService = new CreateResultServiceImpl(createInformationAboutVowels, getListFromString);
        List<String> result = createResultService.getResult("");
        assertEquals(result.toString(), "[]");
    }
}