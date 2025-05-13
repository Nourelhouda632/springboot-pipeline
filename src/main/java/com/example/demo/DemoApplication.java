package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        // Commentaire pour déclencher le pipeline Jenkins
        SpringApplication.run(DemoApplication.class, args);
    }

}