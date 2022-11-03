package com.example.demo1.services;

import com.example.demo1.models.InformationOfVowelsInWord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreateInformationAboutVowels {
    List<InformationOfVowelsInWord> info(List<String> words);
}
