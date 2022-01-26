package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.mappers.VesselRecordMapper;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselRecordService {
    private final VesselRecordRepository vesselRecordRepository;
    private final VesselRepository vesselRepository;

    public VesselRecordService(VesselRecordRepository vesselRecordRepository, VesselRepository vesselRepository) {
        this.vesselRecordRepository = vesselRecordRepository;
        this.vesselRepository = vesselRepository;
    }

    public void add(List<VesselDto> vesselDtoList) {
        for (VesselDto vesselDto: vesselDtoList) {
            VesselEntity vesselEntity = vesselRepository.findByMmsi(vesselDto.getMmsi());
            vesselRecordRepository.save(VesselRecordMapper.INSTANCE.toEntity(vesselDto, vesselEntity));
        }
    }
}
