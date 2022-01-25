package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.PostApiClientDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselRecordService {
    private final VesselRecordRepository vesselRecordRepository;

    public VesselRecordService(VesselRecordRepository recordRepository) {
        this.vesselRecordRepository = recordRepository;
    }

    @Async
    public void add(PostEntity postEntity, List<PostApiClientDto> postApiClientDtoList) {
        for (int i = 0; i < postApiClientDtoList.size(); i++) {
           vesselRecordRepository.save(VesselRecordEntity.toEntity(postEntity.getVesselEntities().get(i), postApiClientDtoList.get(i)));
       }
    }
}
