package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.mappers.VesselRouteMapper;
import com.quoxsii.marinetraffic.repositories.VesselRouteRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис муршрутов судна.
 */
@Service
public class VesselRouteService {
    /**
     * Поле репозиторий муршрутов судна.
     */
    private final VesselRouteRepository vesselRouteRepository;
    /**
     * Поле репозиторий суден.
     */
    private final VesselRepository vesselRepository;

    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param vesselRouteRepository репозиторий муршрутов судна.
     * @param vesselRepository репозиторий суден.
     */
    public VesselRouteService(VesselRouteRepository vesselRouteRepository, VesselRepository vesselRepository) {
        this.vesselRouteRepository = vesselRouteRepository;
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
                vesselRouteRepository.save(VesselRouteMapper.INSTANCE.toEntity(vesselDto, vesselEntity));
            }
        }
    }
}
