package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AISEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselPositionEntity;
import com.quoxsii.marinetraffic.models.VesselPosition;
import com.quoxsii.marinetraffic.models.VesselPositionUpdater;
import com.quoxsii.marinetraffic.repositories.AISRepository;
import com.quoxsii.marinetraffic.repositories.VesselPositionRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselPositionService {
    @Autowired
    private VesselPositionRepository positionRepository;
    @Autowired
    private AISRepository aisRepository;
    @Autowired
    private VesselRepository vesselRepository;

    public VesselPosition add(VesselPositionEntity position, Long aisId, Long vesselId) {
        AISEntity ais = aisRepository.findById(aisId).get();
        position.setAis(ais);
        VesselEntity vessel = vesselRepository.findById(vesselId).get();
        position.setVessel(vessel);
        return VesselPosition.toModel(positionRepository.save(position));
    }

    public VesselPosition update(Long id, VesselPositionUpdater updater) {
        VesselPositionEntity position = positionRepository.findById(id).get();
        position.setAis(aisRepository.findById(updater.getAisId()).get());
        position.setLat(updater.getLat());
        position.setLon(updater.getLon());
        position.setCog(updater.getCog());
        position.setSog(updater.getSog());
        position.setTrueHeading(updater.getTrueHeading());
        position.setRot(updater.getRot());
        position.setNavStateCode(updater.getNavStateCode());
        position.setNavState(updater.getNavState());
        position.setDestination(updater.getDestination());
        position.setMsgTime(updater.getMsgTime());
        return VesselPosition.toModel(positionRepository.save(position));
    }
}
