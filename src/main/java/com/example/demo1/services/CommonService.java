package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CommonService {
    void invoke() throws IOException;
}
