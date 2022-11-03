package com.example.demo1.services.Impl;

import com.example.demo1.services.CommonService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CommonServiceImpl implements CommonService {

    private final FileReaderFromResourcesServiceImpl fileReaderFromResourcesService;
    private final CreateResultServiceImpl createResultService;
    private final FileWriterToResourcesServiceImpl fileWriterToResourcesService;

    public CommonServiceImpl(FileReaderFromResourcesServiceImpl fileReaderFromResourcesService, CreateResultServiceImpl createResultService, FileWriterToResourcesServiceImpl fileWriterToResourcesService) {
        this.fileReaderFromResourcesService = fileReaderFromResourcesService;
        this.createResultService = createResultService;
        this.fileWriterToResourcesService = fileWriterToResourcesService;
    }

    @Override
    public void invoke() throws IOException {
        String readFromFile = fileReaderFromResourcesService.readFromFile("input.txt");
        List<String> result = createResultService.getResult(readFromFile);
        fileWriterToResourcesService.writeToFile("output.txt",result);
    }
}
