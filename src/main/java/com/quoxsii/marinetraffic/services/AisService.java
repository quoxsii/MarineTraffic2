package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.exceptions.AisNotFoundException;
import com.quoxsii.marinetraffic.models.Ais;
import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import static java.util.stream.Collectors.toList;

@Service
public class AisService {
    @Autowired
    private AisRepository aisRepository;
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private VesselRecordRepository vesselRecordRepository;
    @Autowired
    private AisApiClient aisApiClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(AisService.class);

    @Async
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public CompletableFuture<List<Ais>> getAll() {
        List<AisEntity> entityList = (List<AisEntity>) aisRepository.findAll();
        return CompletableFuture.completedFuture(entityList.stream().map(Ais::toModel).collect(toList()));
    }

    @Async
    public Ais getById(Long id) throws AisNotFoundException {
        Optional<AisEntity> ais = aisRepository.findById(id);
        if(ais.isEmpty()) {
            throw new AisNotFoundException("АИС не найден");
        }
        return Ais.toModel(ais.get());
    }

    @Async
    public void save(String url) {
        List<AisDto> aisDtoList = aisApiClient.getAisDtoList(url);
        LOGGER.info("Getting DTO list of size " + aisDtoList.size());
        AisEntity aisEntity = AisEntity.toEntity(aisDtoList.get(0));
        LOGGER.info("Saving Ais {}", aisEntity.toString());
        aisRepository.save(aisEntity);

        List<VesselEntity> vesselEntityList = new ArrayList<VesselEntity>();
        for (AisDto aisDto : aisDtoList) {
            vesselEntityList.add(VesselEntity.toEntity(aisEntity, aisDto));
        }

        LOGGER.info("Saving Vessels of size " + vesselEntityList.size());
        vesselRepository.saveAll(vesselEntityList);

        List<VesselRecordEntity> vesselRecordEntityList = new ArrayList<VesselRecordEntity>();
        for (int i = 0; i < aisDtoList.size(); i++) {
            vesselRecordEntityList.add(VesselRecordEntity.toEntity(vesselEntityList.get(i), aisDtoList.get(i)));
        }
        LOGGER.info("Saving Vessels Records of size " + vesselRecordEntityList.size());
        vesselRecordRepository.saveAll(vesselRecordEntityList);

//        return CompletableFuture.completedFuture(aisEntity);
    }
}
