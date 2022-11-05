package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import com.example.demo1.services.CreateResultService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CreateResultServiceImpl implements CreateResultService {
    private final CreateInformationAboutVowelsImpl createInformationAboutVowels;
    private final GetListFromStringImpl getListFromString;

    public CreateResultServiceImpl(CreateInformationAboutVowelsImpl createInformationAboutVowels, GetListFromStringImpl getListFromString) {
        this.createInformationAboutVowels = createInformationAboutVowels;
        this.getListFromString = getListFromString;
    }

    @Override
    public List<String> getResult(String text) {
        List<InformationOfVowelsInWord> info = createInformationAboutVowels.getInformationAboutCountOfVowelsAndTotalCountOfSymbol(getListFromString.getListWordsFromInputText(text));
        List<String> result = new ArrayList<>();
        Map<String, Map<Integer, List<InformationOfVowelsInWord>>> groupByCharacterSequenceAndTotalCountSymbol = info
                .stream()
                .collect(Collectors.groupingBy(InformationOfVowelsInWord::getCharacterSequence, Collectors.groupingBy(InformationOfVowelsInWord::getTotalCountOfSymbol)));
        groupByCharacterSequenceAndTotalCountSymbol.forEach((key, value) -> value.forEach((key1, value1) -> {
            List<Double> countOfVowels = value1.stream().map(informationOfVowelsInWord -> informationOfVowelsInWord.getCountOfVowels() * 1.0).collect(Collectors.toList());
            addStringToListOfResult(result, countOfVowels, key, key1);
        }));
        return result;
    }

    private static void addStringToListOfResult(List<String> result, List<Double> countOfVowels, String characterSequence, int totalCount) {
        String s = "(" + characterSequence + "," + totalCount + ")" + "->" + countOfVowels.stream()
                .reduce(0.0, Double::sum) / countOfVowels.size();
        result.add(s);
    }
}
