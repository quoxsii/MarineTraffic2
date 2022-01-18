package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.exceptions.AisNotFoundException;
import com.quoxsii.marinetraffic.models.Ais;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class AisService {
    @Autowired
    private AisRepository aisRepository;
    @Autowired
    private AisApiClient aisApiClient;

    public List<Ais> getAll() {
        return aisApiClient.getAisDtoList().stream().map(Ais::toModel).collect(toList());
    }

    public Ais getById(Long id) throws AisNotFoundException {
        Optional<AisEntity> ais = aisRepository.findById(id);
        if(ais.isEmpty()) {
            throw new AisNotFoundException("АИС не найден");
        }
        return Ais.toModel(ais.get());
    }
}
