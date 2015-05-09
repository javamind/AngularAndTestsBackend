package com.devmind;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class AngularAndTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularAndTestsApplication.class, args);
    }
}
