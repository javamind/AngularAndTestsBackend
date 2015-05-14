package com.devmind.repository;

import com.devmind.domain.Talk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TalkRepository extends CrudRepository<Talk, Long> {
}
