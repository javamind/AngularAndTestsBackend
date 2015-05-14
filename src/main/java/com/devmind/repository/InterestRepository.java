package com.devmind.repository;

import com.devmind.domain.Interest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InterestRepository extends CrudRepository<Interest, Long> {

}
