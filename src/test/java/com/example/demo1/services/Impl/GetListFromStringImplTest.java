package com.example.demo1.services.Impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GetListFromStringImplTest {

    @Autowired
    GetListFromStringImpl getListFromString;

    @Test
    @DisplayName("Test input String to List")
    void getListFromStringTest() {
        List<String> words = getListFromString.words("Platon made bamboo boats.");
        assertEquals(words.toString(), "[platon, made, bamboo, boats]");
    }
}