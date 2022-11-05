package com.example.demo1.services.Impl;

import com.example.demo1.services.FileWriterToResourcesService;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class FileWriterToResourcesServiceImpl implements FileWriterToResourcesService {
    @Override
    public void writeToFile(String fileName, List<String> result) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        for (String str : result) {
            str = str + "\r\n";
            outputStream.write(str.getBytes());
        }
        outputStream.close();
    }
}
