package com.devmind;

import com.devmind.domain.Interest;
import com.devmind.domain.Speaker;
import com.devmind.domain.Talk;
import com.devmind.init.Initializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class AngularAndTestsConfig extends SpringBootRepositoryRestMvcConfiguration{

    @Bean
    public Initializer initializer(){
        return new Initializer();
    }

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Interest.class);
        config.exposeIdsFor(Speaker.class);
        config.exposeIdsFor(Talk.class);
    }

}
