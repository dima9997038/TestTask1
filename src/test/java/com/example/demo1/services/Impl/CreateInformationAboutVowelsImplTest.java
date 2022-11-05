package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CreateInformationAboutVowelsImplTest {

    @Autowired
    CreateInformationAboutVowelsImpl createInformationAboutVowels;

    @Test
    @DisplayName("Test create information about vowels")
    void createInformationAboutVowels() {
        List<String> words = new ArrayList<>(Arrays.asList("Platon","made","bamboo"));
        List<InformationOfVowelsInWord> info = createInformationAboutVowels.getInformationAboutCountOfVowelsAndTotalCountOfSymbol(words);
        InformationOfVowelsInWord expected1=new InformationOfVowelsInWord("{a, o}",2,6);
        InformationOfVowelsInWord expected2=new InformationOfVowelsInWord("{a, e}",2,4);
        InformationOfVowelsInWord expected3=new InformationOfVowelsInWord("{a, o}",3,6);
        List<InformationOfVowelsInWord> expected = new ArrayList<>();
        expected.add(expected1);
        expected.add(expected2);
        expected.add(expected3);
        assertEquals(info,expected);
    }
}