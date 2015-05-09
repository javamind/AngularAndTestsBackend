package com.devmind;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularAndTestsApplication.class)
public class AngularAndTestsApplicationTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void contextLoads() {
        assertThat(resourceLoader.getResource("talks.json").exists()).isTrue();
    }
}
