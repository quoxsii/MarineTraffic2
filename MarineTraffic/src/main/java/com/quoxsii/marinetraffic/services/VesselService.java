package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AISEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.exceptions.VesselAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.models.AIS;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;

    public VesselEntity add(VesselEntity vessel) throws VesselAlreadyExistsException {
        if(vesselRepository.findByMmsi(vessel.getMmsi()) != null) {
            throw new VesselAlreadyExistsException("Судно с таким MMSI уже существует");
        }
        return vesselRepository.save(vessel);
    }

    public VesselEntity getOne(Long id) throws VesselNotFoundException {
        Optional<VesselEntity> vessel = vesselRepository.findById(id);
        if(!vessel.isPresent()) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        return vessel.get();
    }

    public List<Vessel> getAll() {
        List<VesselEntity> vesselEntities = (List<VesselEntity>) vesselRepository.findAll();
        List<Vessel> vessels = vesselEntities.stream().map(Vessel::toModel).collect(Collectors.toList());
        return vessels;
    }

    public Long delete(Long id) {
        vesselRepository.deleteById(id);
        return id;
    }
}
