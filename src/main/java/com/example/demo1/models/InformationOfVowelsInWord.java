package com.example.demo1.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class InformationOfVowelsInWord {
    private String characterSequence;
    private Integer countOfVowels;
    private Integer totalCountOfSymbol;

}
