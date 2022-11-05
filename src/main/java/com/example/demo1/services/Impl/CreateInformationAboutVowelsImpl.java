package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import com.example.demo1.services.CreateInformationAboutVowels;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CreateInformationAboutVowelsImpl implements CreateInformationAboutVowels {

    private static final Set<Character> VOWELS_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

    @Override
    public List<InformationOfVowelsInWord> getInformationAboutCountOfVowelsAndTotalCountOfSymbol(List<String> words) {
        return words.stream().map(word -> {
                    int countOfVowels = 0;
                    int totalCountOfSymbol = 0;
                    SortedSet<Character> characterSet = new TreeSet<>();
                    for (int j = 0; j < word.length(); j++) {
                        totalCountOfSymbol++;
                        if (VOWELS_SET.contains(word.charAt(j))) {
                            characterSet.add(word.charAt(j));
                            countOfVowels++;
                        }
                    }
                    return InformationOfVowelsInWord.builder()
                            .characterSequence(characterSet.toString().replace('[', '{').replace(']', '}'))
                            .countOfVowels(countOfVowels)
                            .totalCountOfSymbol(totalCountOfSymbol)
                            .build();
                }
        ).collect(Collectors.toList());
    }
}
