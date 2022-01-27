package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс конвертации для муршруты судна.
 */
@Mapper
public interface VesselRouteMapper {
    /**
     * Объект реализующий интерфейс конвертации для муршруты судна.
     */
    VesselRouteMapper INSTANCE = Mappers.getMapper( VesselRouteMapper.class );

    /**
     * Функция конвертации объекта передачи данных в сущность.
     * @param vesselDto объект передачи данных судна.
     * @param vesselEntity сущность пост.
     * @return возвращает сущность муршрут судна.
     */
    @Mapping(target = "id", ignore = true)
    VesselRouteEntity toEntity(VesselDto vesselDto, VesselEntity vesselEntity);
}
