package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private AisApiClient aisApiClient;

    public List<Vessel> getAll() {
        return aisApiClient.getAisDtoList("ip").stream().map(Vessel::toVessel).collect(toList());
    }

    public VesselEntity getById(Long id) throws VesselNotFoundException {
        Optional<VesselEntity> vessel = vesselRepository.findById(id);
        if(!vessel.isPresent()) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        return vessel.get();
    }
}
