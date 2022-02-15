package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import com.quoxsii.marinetraffic.models.Vessel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Интерфейс конвертации для судна.
 */
@Mapper(componentModel = "spring")
public interface VesselMapper {
    /**
     * Метод конвертации объекта передачи данных в сущность.
     * @param vesselDto объект передачи данных судна.
     * @param postEntity сущность пост.
     * @return возвращает сущность судно.
     */
    @Mapping(source = "vesselDto.name", target = "name")
    @Mapping(target = "id", ignore = true)
    VesselEntity toEntity(VesselDto vesselDto, PostEntity postEntity);

    /**
     * Метод конвертации сущности в модель.
     * @param vesselEntity сущность судно.
     * @param vesselRouteEntity сущность муршрут судна.
     * @return возвращает модель судно.
     */
    Vessel toModel(VesselEntity vesselEntity, VesselRouteEntity vesselRouteEntity);
}
