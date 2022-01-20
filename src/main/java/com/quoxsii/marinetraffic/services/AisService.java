package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.exceptions.AisNotFoundException;
import com.quoxsii.marinetraffic.models.Ais;
import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class AisService {
    @Autowired
    private AisRepository aisRepository;
    @Autowired
    private AisApiClient aisApiClient;

    @Async
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
    public CompletableFuture<List<AisEntity>> save(String url) {
        List<AisDto> aisDtoList = aisApiClient.getAisDtoList(url);
        List<AisEntity> aisEntityList = aisDtoList.stream().map(AisEntity::toEntity).collect(toList());
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);

        return CompletableFuture.completedFuture((List<AisEntity>) aisRepository.saveAll(aisEntityList));
    }
}
