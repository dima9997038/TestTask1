package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import com.example.demo1.services.CreateInformationAboutVowels;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CreateInformationAboutVowelsImpl implements CreateInformationAboutVowels {
    @Override
    public List<InformationOfVowelsInWord> info(List<String> words) {
        List<InformationOfVowelsInWord> result = new ArrayList<>();
        for (String word : words) {
            InformationOfVowelsInWord informationOfVowelsInWord = new InformationOfVowelsInWord(null, 0, 0);
            int countOfVowels = 0;
            int totalCountOfSymbol = 0;
            Set<Character> characterSet = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                totalCountOfSymbol++;
                switch (word.charAt(j)) {
                    case 'a':
                        characterSet.add('a');
                        countOfVowels++;
                        break;
                    case 'e':
                        characterSet.add('e');
                        countOfVowels++;
                        break;
                    case 'i':
                        characterSet.add('i');
                        countOfVowels++;
                        break;
                    case 'o':
                        characterSet.add('o');
                        countOfVowels++;
                        break;
                    case 'u':
                        characterSet.add('u');
                        countOfVowels++;
                        break;
                    case 'y':
                        characterSet.add('y');
                        countOfVowels++;
                        break;
                }
            }
            informationOfVowelsInWord.setCharacterSequence(characterSet.toString().replace('[', '{').replace(']', '}'));
            informationOfVowelsInWord.setCountOfVowels(countOfVowels);
            informationOfVowelsInWord.setTotalCountOfSymbol(totalCountOfSymbol);
            result.add(informationOfVowelsInWord);
        }
        return result;
    }
}
