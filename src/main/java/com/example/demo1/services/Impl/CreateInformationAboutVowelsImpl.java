package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import com.example.demo1.services.CreateInformationAboutVowels;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreateInformationAboutVowelsImpl implements CreateInformationAboutVowels {
    @Override
    public List<InformationOfVowelsInWord> getInformationAboutCountOfVowelsAndTotalCountOfSymbol(List<String> words) {
        List<InformationOfVowelsInWord> result = new ArrayList<>();
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        for (String word : words) {
            InformationOfVowelsInWord informationOfVowelsInWord = new InformationOfVowelsInWord(null, 0, 0);
            int countOfVowels = 0;
            int totalCountOfSymbol = 0;
            Set<Character> characterSet = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                totalCountOfSymbol++;
                if (vowelsSet.contains(word.charAt(j))) {
                    characterSet.add(word.charAt(j));
                    countOfVowels++;
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
