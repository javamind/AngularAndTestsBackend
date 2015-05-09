package com.devmind.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import com.devmind.AngularAndTestsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ehret_g on 09/05/15.
 */
public class ObjectMapperTest {

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void should_deserialize_speaker() throws IOException {
        String speaker = "{\"id\": 2841,\n" +
                "        \"firstname\": \"Dan\",\n" +
                "        \"lastname\": \"North\",\n" +
                "        \"urlimage\": \"http://www.gravatar.com/avatar/33cfb4d051a768c06f7fb380c7c2abe3\",\n" +
                "        \"url\": \"http://www.mix-it.fr/api/members/2841\"}";

        Speaker speakerDeserialized = objectMapper.readValue(speaker.getBytes(), Speaker.class);
        assertThat(speakerDeserialized).isNotNull()
                .isEqualToComparingFieldByField(
                        new Speaker()
                                .setId(2841L)
                                .setFirstname("Dan")
                                .setLastname("North")
                                .setUrlimage("http://www.gravatar.com/avatar/33cfb4d051a768c06f7fb380c7c2abe3")
                                .setUrl("http://www.mix-it.fr/api/members/2841"));
    }

    @Test
    public void should_deserialize_talk() throws IOException {
        String talk = "{\"speakers\": [\n" +
                "      {\n" +
                "        \"id\": 2841,\n" +
                "        \"firstname\": \"Dan\",\n" +
                "        \"lastname\": \"North\",\n" +
                "        \"urlimage\": \"http://www.gravatar.com/avatar/33cfb4d051a768c06f7fb380c7c2abe3\",\n" +
                "        \"url\": \"http://www.mix-it.fr/api/members/2841\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"id\": 2471,\n" +
                "    \"title\": \"The Three Ages of Innovation\",\n" +
                "    \"summary\": \"There are distinct ages in the growth of an idea or a product, and innovation can and should occur in all of these, and involve everyone.\",\n" +
                "    \"description\": \"Innovation isn’t a separate activity that happens once at the beginning of a project. It isn’t the exclusive domain of an Innovation Director or a “Creative” team. Innovation is the ability to continually see things through fresh eyes, however familiar they become; to apply a different perspective to something you have done a hundred times; to challenge your hard-won assumptions and to believe you may be wrong, however right you feel.\\r\\n\\r\\nDan argues that there are three distinct ages in the growth of an idea or a product, and that innovation can and should occur in all of these. It should be the responsibility of everyone involved, all the time. He wants you to be as excited about the possibility of innovation as he is.\",\n" +
                "    \"language\": \"en\",\n" +
                "    \"ideaForNow\": \"Understand there are different distinct modes of working, and that each of these have different goals. Seek opportunities to innovate even in situations that seem unexciting.\",\n" +
                "    \"format\": \"Keynote\",\n" +
                "    \"level\": \"Beginner\",\n" +
                "    \"start\": \"2015-04-16T09:15:00.000+02:00\",\n" +
                "    \"end\": \"2015-04-16T09:40:00.000+02:00\",\n" +
                "    \"room\": \"Grand Amphi\"}";

        Talk talkDeserialized = objectMapper.readValue(talk.getBytes(), Talk.class);
        assertThat(talkDeserialized).isNotNull();
        assertThat(talkDeserialized.getSpeakers().size()).isEqualTo(1);
        assertThat(talkDeserialized.getTitle()).isEqualTo("The Three Ages of Innovation");

    }


    @Test
    public void should_deserialize_talks() throws IOException {
        String talks = "[{" +
                "    \"id\": 2471,\n" +
                "    \"title\": \"The Three Ages of Innovation\"\n" +
                "}, {" +
                "    \"id\": 2472,\n" +
                "    \"title\": \"Second example\"\n" +
                "}]";

        List<Talk> talkDeserialized = objectMapper.readValue(talks.getBytes(),objectMapper.getTypeFactory().constructCollectionType(List.class, Talk.class));
        assertThat(talkDeserialized).isNotNull().hasSize(2);

    }

}
