package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
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
        List<String> words = new ArrayList<>();
        words.add("Platon");
        words.add("made");
        words.add("bamboo");
        List<InformationOfVowelsInWord> info = createInformationAboutVowels.getInformationAboutCountOfVowelsAndTotalCountOfSymbol(words);
        assertEquals(info.toString(), "[InformationOfVowelsInWord(characterSequence={a, o}, countOfVowels=2, totalCountOfSymbol=6), InformationOfVowelsInWord(characterSequence={a, e}, countOfVowels=2, totalCountOfSymbol=4), InformationOfVowelsInWord(characterSequence={a, o}, countOfVowels=3, totalCountOfSymbol=6)]");
    }

}