package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий сущностей судов.
 */
public interface VesselRepository extends CrudRepository<VesselEntity, Long> {
    /**
     * Функция поиска в репозитории по морскому идентификатору мобильной службы судна.
     * @param mmsi морской идентификатор мобильной службы судна.
     * @return возвращает сущность судно.
     */
    VesselEntity findByMmsi(String mmsi);
}
