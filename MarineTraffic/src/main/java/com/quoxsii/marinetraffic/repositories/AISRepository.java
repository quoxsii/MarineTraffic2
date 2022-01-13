package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.AISEntity;
import org.springframework.data.repository.CrudRepository;

public interface AISRepository extends CrudRepository<AISEntity, Long> {
    AISEntity findByChannelId(Integer channelId);
}
