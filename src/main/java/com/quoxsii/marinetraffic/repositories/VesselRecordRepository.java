package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.models.Vessel;
import org.springframework.data.repository.CrudRepository;

public interface VesselRecordRepository extends CrudRepository<VesselRecordEntity, Long> {
}
