package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.mappers.VesselRecordMapper;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис записей по судну.
 */
@Service
public class VesselRecordService {
    /**
     * Поле репозиторий записей по судну.
     */
    private final VesselRecordRepository vesselRecordRepository;
    /**
     * Поле репозиторий суден.
     */
    private final VesselRepository vesselRepository;

    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param vesselRecordRepository репозиторий записей по судну.
     * @param vesselRepository репозиторий суден.
     */
    public VesselRecordService(VesselRecordRepository vesselRecordRepository, VesselRepository vesselRepository) {
        this.vesselRecordRepository = vesselRecordRepository;
        this.vesselRepository = vesselRepository;
    }

    /**
     * Функция добавления судна в репозиторий.
     * @param vesselDtoList список объектов передачи данных судна.
     */
    @Async
    public void add(List<VesselDto> vesselDtoList) {
        for (VesselDto vesselDto: vesselDtoList) {
            VesselEntity vesselEntity = vesselRepository.findByMmsi(vesselDto.getMmsi());
            if (vesselEntity != null) {
                vesselRecordRepository.save(VesselRecordMapper.INSTANCE.toEntity(vesselDto, vesselEntity));
            }
        }
    }
}
