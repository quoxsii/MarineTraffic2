package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.models.Vessel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс конвертации для судна.
 */
@Mapper
public interface VesselMapper {
    /**
     * Объект реализующий интерфейс конвертации для судна.
     */
    VesselMapper INSTANCE = Mappers.getMapper( VesselMapper.class );

    /**
     * Функция конвертации объекта передачи данных в сущность.
     * @param vesselDto объект передачи данных судна.
     * @param postEntity сущность пост.
     * @return возвращает сущность судно.
     */
    @Mapping(source = "vesselDto.name", target = "name")
    @Mapping(source = "postEntity", target = "postEntity")
    VesselEntity toEntity(VesselDto vesselDto, PostEntity postEntity);

    /**
     * Функция конвертации сущности в модель.
     * @param vesselEntity сущность судно.
     * @param vesselRecordEntity сущность запись по судну.
     * @return возвращает модель судно.
     */
    Vessel toModel(VesselEntity vesselEntity, VesselRecordEntity vesselRecordEntity);
}
