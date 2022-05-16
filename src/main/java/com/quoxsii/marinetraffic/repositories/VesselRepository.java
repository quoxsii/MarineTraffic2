package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Репозиторий сущностей суден.
 */
public interface VesselRepository extends CrudRepository<VesselEntity, Long> {
    /**
     * Метод поиска всех записей в репозитории.
     * @param pageable параметры для пагинации.
     * @return возвращает страницу с суднами.
     */
    Page<VesselEntity> findAll(Pageable pageable);
    /**
     * Метод поиска в репозитории по морскому идентификатору мобильной службы судна.
     * @param mmsi морской идентификатор мобильной службы судна.
     * @return возвращает сущность судно.
     */
    VesselEntity findByMmsi(String mmsi);
    Page<VesselEntity> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
