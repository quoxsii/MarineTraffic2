package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AISEntity;
import com.quoxsii.marinetraffic.exceptions.AISAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.AISNotFoundException;
import com.quoxsii.marinetraffic.models.AIS;
import com.quoxsii.marinetraffic.models.AISDto;
import com.quoxsii.marinetraffic.repositories.AISRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class AISService {
    @Autowired
    private AISRepository aisRepository;
    @Autowired
    private AISAPIClient aisApiClient;

    public List<AIS> findAll() {
        return aisApiClient.getAISList().stream().map(this::toAIS).collect(toList());
    }

    private AIS toAIS(@NonNull AISDto input) {
        AIS ais = new AIS();
        ais.setChannelId(input.getChannelId());
        ais.setChannel(input.getChannel());
        return ais;
    }

    /*public AISEntity add(AISEntity ais) throws AISAlreadyExistsException {
        if(aisRepository.findByChannelId(ais.getChannelId()) != null) {
            throw new AISAlreadyExistsException("АИС с таким номером уже существует");
        }
        return aisRepository.save(ais);
    }*/

    public AIS getOne(Long id) throws AISNotFoundException {
        Optional<AISEntity> ais = aisRepository.findById(id);
        if(!ais.isPresent()) {
            throw new AISNotFoundException("АИС не найден");
        }
        return AIS.toModel(ais.get());
    }

    public List<AIS> getAll() {
        List<AISEntity> userEntities = (List<AISEntity>) aisRepository.findAll();
        List<AIS> ais = userEntities.stream().map(AIS::toModel).collect(toList());
        return ais;
    }

    public Long delete(Long id) {
        aisRepository.deleteById(id);
        return id;
    }
}
