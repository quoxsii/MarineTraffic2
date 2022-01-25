package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    PostEntity findByUrl(String url);
}
