package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Репозиторий сущностей записей по суднам.
 */
public interface VesselRecordRepository extends CrudRepository<VesselRecordEntity, Long> {
    List<VesselRecordEntity> findByVesselEntity(VesselEntity vesselEntity);
}
