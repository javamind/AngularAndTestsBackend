package com.devmind.repository;

import com.devmind.domain.Speaker;
import com.devmind.domain.Talk;
import org.springframework.data.repository.CrudRepository;

public interface TalkRepository extends CrudRepository<Talk, Long> {
}
