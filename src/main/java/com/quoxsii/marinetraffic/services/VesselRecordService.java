package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.models.VesselRecord;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

@Service
public class VesselRecordService {
    @Autowired
    private VesselRecordRepository recordRepository;
    @Autowired
    private AisRepository aisRepository;
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private AisApiClient aisApiClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(AisService.class);

    //public List<VesselRecord> getAll() {
    //    return aisApiClient.getAisDtoList("ip").stream().map(VesselRecord::toVesselPosition).collect(toList());
    //}

    /*@Async
    public CompletableFuture<VesselRecordEntity> save(String url) {
        List<AisDto> aisDtoList = aisApiClient.getAisDtoList(url);
        LOGGER.info("Getting DTO list of size {} records", aisDtoList.size());
        List<VesselRecordEntity> vesselRecordEntity = VesselRecordEntity.toEntity(aisDtoList.get(0));
        LOGGER.info("Saving first DTO {}", aisEntityList.toString());

        return CompletableFuture.completedFuture(aisRepository.save(aisEntityList));
    }*/
}
