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

/**
 * Initialize the data
 */
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
                if (talk.getSpeakers() != null) {
                    for (Speaker speaker : talk.getSpeakers()) {
                        speakers.add(speakerRepository.save(speaker));
                    }

                }
                talk.clearSpeakers().addAllSpeakers(speakers);

                List<Interest> interests = new ArrayList<>();
                if (talk.getInterests() != null) {
                    for (Interest interest : talk.getInterests()) {
                        interests.add(interestRepository.save(interest));
                    }

                }
                talk.clearInterests().addAllInterests(interests);

                talkRepository.save(talk);
            }



        } catch (IOException e) {
            throw new RuntimeException("Impossible to load datas", e);
        }


    }
}
