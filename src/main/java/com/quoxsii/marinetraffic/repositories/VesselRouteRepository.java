package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий сущностей муршрутов по суднам.
 */
public interface VesselRouteRepository extends CrudRepository<VesselRouteEntity, Long> {
    /**
     * Метод получения последнего местонахождения судна.
     * @param vesselEntity сущность судно.
     * @return возвращает сущность маршрут судна.
     */
    VesselRouteEntity findTopByVesselEntityOrderByIdDesc(VesselEntity vesselEntity);
}
