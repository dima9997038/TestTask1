package com.example.demo1.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FileWriterToResourcesService {
    void writeToFile(String fileName, List<String> result) throws IOException;
}
