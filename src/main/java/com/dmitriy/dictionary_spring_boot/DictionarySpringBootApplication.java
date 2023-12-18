package com.dmitriy.dictionary_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DictionarySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionarySpringBootApplication.class, args);
    }

}
