package com.devmind.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.devmind.AngularAndTestsApplication;
import com.devmind.domain.Speaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularAndTestsApplication.class)
public class SpeakerRepositoryTest {

    @Autowired
    private SpeakerRepository repository;

    @Test
    public void should_find_speaker_by_firstname() throws Exception {
        repository.save(new Speaker().setFirstname("Dan").setLastname("North"));
        assertThat(repository.findByFirstname("Dan").iterator().next().getLastname()).isEqualTo("North");
    }
}