package com.devmind.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.devmind.domain.Interest;
import com.devmind.domain.Speaker;
import com.devmind.domain.Talk;
import com.devmind.repository.InterestRepository;
import com.devmind.repository.SpeakerRepository;
import com.devmind.repository.TalkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Initialize the data
 */
@Component
public class Initializer {

    @Autowired
    private ResourceLoader resourceLoader;

        @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private TalkRepository talkRepository;

    @PostConstruct
    public void init() {

        ObjectMapper objectMapper = new ObjectMapper();

        //The Json file is loaded
        try {
            List<Talk> talks = objectMapper.readValue(
                    resourceLoader.getResource("classpath:talks.json").getFile(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Talk.class));

            for (Talk talk : talks) {
                List<Speaker> speakers = new ArrayList<>();
                List<Interest> interests = new ArrayList<>();

                if (talk.getInterests() != null) {
                    talk.getInterests().forEach(interest -> {
                        interest.setTalk(null);
                        interests.add(interestRepository.save(interest));
                    });
                }
                if (talk.getSpeakers() != null) {
                    talk.getSpeakers().forEach(speaker -> {
                        speaker.setTalk(null);
                        speakers.add(speakerRepository.save(speaker));
                    });
                }

                talk.clearSpeakers();
                talk.clearInterests();

                Talk persisted = talkRepository.save(talk);

                persisted.addAllSpeakers(speakers);
                persisted.addAllInterests(interests);

                persisted.getInterests().forEach(interest -> interestRepository.save(interest));
                persisted.getSpeakers().forEach(speaker -> speakerRepository.save(speaker));

            }



        } catch (IOException e) {
            throw new RuntimeException("Impossible to load datas", e);
        }


    }
}
