package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreateResultService {
    List<String> getResult(String text);
}
