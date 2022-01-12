package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.AISEntity;
import com.quoxsii.marinetraffic.exceptions.AISAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.AISNotFoundException;
import com.quoxsii.marinetraffic.models.AIS;
import com.quoxsii.marinetraffic.repositories.AISRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AISService {
    @Autowired
    private AISRepository aisRepository;

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
        List<AIS> ais = userEntities.stream().map(AIS::toModel).collect(Collectors.toList());
        return ais;
    }

    public Long delete(Long id) {
        aisRepository.deleteById(id);
        return id;
    }
}
