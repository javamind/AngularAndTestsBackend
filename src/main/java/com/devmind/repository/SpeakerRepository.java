package com.devmind.repository;

import java.util.Collection;

import com.devmind.domain.Speaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

    @RestResource(path = "by-firstname")
    Collection<Speaker> findByFirstname(@Param("name") String firstname);

}
