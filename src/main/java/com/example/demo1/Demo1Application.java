package com.example.demo1;

import com.example.demo1.services.CommonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {


    private final CommonService commonService;

    public Demo1Application(CommonService commonService) {
        this.commonService = commonService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Demo1Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        commonService.invoke();
    }
}
