package com.example.demo1.services.Impl;

import com.example.demo1.models.InformationOfVowelsInWord;
import com.example.demo1.services.CreateResultService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<InformationOfVowelsInWord> info = createInformationAboutVowels.info(getListFromString.words(text));
        info.sort((i1, i2) -> i2.getTotalCountOfSymbol().compareTo(i1.getTotalCountOfSymbol()));
        List<String> result = new ArrayList<>();
        List<Double> countOfVowels = new ArrayList<>();
        String characterSequence = info.get(0).getCharacterSequence();
        int totalCount = info.get(0).getTotalCountOfSymbol();
        boolean flagAdd=false;
        for (InformationOfVowelsInWord el : info) {
            if (!el.getTotalCountOfSymbol().equals(totalCount) || !el.getCharacterSequence().equals(characterSequence)) {
                if (flagAdd) {
                    String s = "(" + characterSequence + "," + totalCount + ")" + "->" + countOfVowels.stream()
                            .reduce(0.0, Double::sum) / countOfVowels.size();
                    result.add(s);
                    flagAdd = false;
                }
                countOfVowels = new ArrayList<>();
                characterSequence = el.getCharacterSequence();
                totalCount = el.getTotalCountOfSymbol();
            }
            countOfVowels.add(el.getCountOfVowels()*1.0);
            flagAdd=true;
        }
        if (flagAdd) {
            String s ="("+ characterSequence +","+totalCount+ ")"+"->" + countOfVowels.stream()
                    .reduce(0.0, Double::sum) / countOfVowels.size();
            result.add(s);
        }
        return result;
    }
}
