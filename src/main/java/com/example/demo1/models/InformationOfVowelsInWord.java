package com.example.demo1.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Builder
public class InformationOfVowelsInWord {
    private String characterSequence;
    private Integer countOfVowels;
    private Integer totalCountOfSymbol;

}
