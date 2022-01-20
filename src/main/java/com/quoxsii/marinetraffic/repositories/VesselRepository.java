package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import org.springframework.data.repository.CrudRepository;

public interface VesselRepository extends CrudRepository<VesselEntity, Long> {
    VesselEntity findByMmsi(String mmsi);
}
