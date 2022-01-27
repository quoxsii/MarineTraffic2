package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Репозиторий сущностей муршрутов по суднам.
 */
public interface VesselRouteRepository extends CrudRepository<VesselRouteEntity, Long> {
    List<VesselRouteEntity> findByVesselEntity(VesselEntity vesselEntity);
}
