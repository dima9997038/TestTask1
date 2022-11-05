package com.example.demo1.services.Impl;

import com.example.demo1.services.FileReaderFromResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FileReaderFromResourcesServiceImpl implements FileReaderFromResourcesService {
    final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ResourceLoader resourceLoader;
    public FileReaderFromResourcesServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Override
    public String readFromFile(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        InputStream inputStream = resource.getInputStream();
        String text = null;
        try {
            text = new String(FileCopyUtils.copyToByteArray(inputStream), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
        return text;
    }
}
