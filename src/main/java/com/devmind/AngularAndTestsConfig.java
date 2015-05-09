package com.devmind;

import com.devmind.init.Initializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AngularAndTestsConfig {

    @Bean
    public Initializer initializer(){
        return new Initializer();
    }
}
