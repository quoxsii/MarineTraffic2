package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.mappers.VesselMapper;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VesselService {
    private final VesselRepository vesselRepository;
    private final VesselRecordRepository vesselRecordRepository;

    public VesselService(VesselRepository vesselRepository, VesselRecordRepository vesselRecordRepository) {
        this.vesselRepository = vesselRepository;
        this.vesselRecordRepository = vesselRecordRepository;
    }

    public List<Vessel> getAll() {
        List<Vessel> vesselList = new ArrayList<>();
        for (VesselEntity vesselEntity : vesselRepository.findAll()) {
            List<VesselRecordEntity> vesselRecordEntityList = vesselRecordRepository.findByVesselEntity(vesselEntity);
            vesselList.add(VesselMapper.INSTANCE.toModel(vesselEntity, vesselRecordEntityList.get(vesselRecordEntityList.size() - 1)));
        }
        return vesselList;
    }

    public Vessel getByMmsi(String mmsi) throws VesselNotFoundException {
        VesselEntity vesselEntity = vesselRepository.findByMmsi(mmsi);
        if(vesselEntity == null) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        List<VesselRecordEntity> vesselRecordEntityList = vesselRecordRepository.findByVesselEntity(vesselEntity);
        return VesselMapper.INSTANCE.toModel(vesselEntity, vesselRecordEntityList.get(vesselRecordEntityList.size() - 1));
    }

    public void update(PostEntity postEntity, List<VesselDto> vesselDtoList) {
        for (VesselDto vesselDto : vesselDtoList) {
            VesselEntity vesselEntity = VesselMapper.INSTANCE.toEntity(vesselDto, postEntity);
            if (vesselRepository.findByMmsi(vesselEntity.getMmsi()) == null) {
                vesselRepository.save(vesselEntity);
            }
        }
    }
}
