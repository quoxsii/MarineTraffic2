package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.models.VesselRecord;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<VesselRecord> getAll() {
        return aisApiClient.getAisDtoList().stream().map(VesselRecord::toVesselPosition).collect(toList());
    }
}
