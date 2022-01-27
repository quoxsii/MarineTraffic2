package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс конвертации для записи по судну.
 */
@Mapper
public interface VesselRecordMapper {
    /**
     * Объект реализующий интерфейс конвертации для записи по судну.
     */
    VesselRecordMapper INSTANCE = Mappers.getMapper( VesselRecordMapper.class );

    /**
     * Функция конвертации объекта передачи данных в сущность.
     * @param vesselDto объект передачи данных судна.
     * @param vesselEntity сущность пост.
     * @return возвращает сущность запись по судну.
     */
    @Mapping(target = "id", ignore = true)
    VesselRecordEntity toEntity(VesselDto vesselDto, VesselEntity vesselEntity);
}
