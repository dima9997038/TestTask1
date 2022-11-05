package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetListWordsFromString {
    List<String> getListWordsFromInputText(String data);
}
