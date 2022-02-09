package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Интерфейс конвертации для муршруты судна.
 */
@Mapper(componentModel = "spring")
public interface VesselRouteMapper {
    /**
     * Функция конвертации объекта передачи данных в сущность.
     * @param vesselDto объект передачи данных судна.
     * @param vesselEntity сущность пост.
     * @return возвращает сущность муршрут судна.
     */
    @Mapping(target = "id", ignore = true)
    VesselRouteEntity toEntity(VesselDto vesselDto, VesselEntity vesselEntity);
}
