package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.AisEntity;
import org.springframework.data.repository.CrudRepository;

public interface AisRepository extends CrudRepository<AisEntity, Long> {
    AisEntity findByChannelId(Long channelId);
    AisEntity findByChannel(String channel);
}
