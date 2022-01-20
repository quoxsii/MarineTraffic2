package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;

    public List<Vessel> getAll() {
        List<VesselEntity> vesselEntityList = (List<VesselEntity>) vesselRepository.findAll();
        return vesselEntityList.stream().map(Vessel::toModel).collect(toList());
    }

    public Vessel getByMmsi(String mmsi) throws VesselNotFoundException {
        VesselEntity vesselEntity = vesselRepository.findByMmsi(mmsi);
        if(vesselEntity == null) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        return Vessel.toModel(vesselEntity);
    }
}
