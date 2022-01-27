package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.mappers.VesselMapper;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис суден.
 */
@Service
public class VesselService {
    /**
     * Поле репозиторий суден.
     */
    private final VesselRepository vesselRepository;
    /**
     * Поле репозиторий записей по судну.
     */
    private final VesselRecordRepository vesselRecordRepository;

    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param vesselRepository репозиторий суден.
     * @param vesselRecordRepository репозиторий записей по судну.
     */
    public VesselService(VesselRepository vesselRepository, VesselRecordRepository vesselRecordRepository) {
        this.vesselRepository = vesselRepository;
        this.vesselRecordRepository = vesselRecordRepository;
    }

    /**
     * Функция получения списка всех моделей суден.
     * @return возвращает список суден.
     * @throws VesselNotFoundException возникает когда в репозитории не зарегистрировано ни одного судна.
     */
    public List<Vessel> getAll() throws VesselNotFoundException {
        List<VesselEntity> vesselEntityList = (List<VesselEntity>) vesselRepository.findAll();
        if (vesselEntityList.isEmpty()) {
            throw new VesselNotFoundException("Судна не найдены");
        }
        List<Vessel> vesselList = new ArrayList<>();
        for (VesselEntity vesselEntity : vesselEntityList) {
            List<VesselRecordEntity> vesselRecordEntityList = vesselRecordRepository.findByVesselEntity(vesselEntity);
            vesselList.add(VesselMapper.INSTANCE.toModel(vesselEntity, vesselRecordEntityList.get(vesselRecordEntityList.size() - 1)));
        }
        return vesselList;
    }

    /**
     * Функция получения модели по морскому идентификатору мобильной службы.
     * @param mmsi морской идентификатор мобильной службы.
     * @return возвращает модель судна.
     * @throws VesselNotFoundException возникает когда в репозитории не зарегистрировано ни одного судна с указанным морским идентификатором мобильной службы.
     */
    public Vessel getByMmsi(String mmsi) throws VesselNotFoundException {
        VesselEntity vesselEntity = vesselRepository.findByMmsi(mmsi);
        if(vesselEntity == null) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        List<VesselRecordEntity> vesselRecordEntityList = vesselRecordRepository.findByVesselEntity(vesselEntity);
        return VesselMapper.INSTANCE.toModel(vesselEntity, vesselRecordEntityList.get(vesselRecordEntityList.size() - 1));
    }

    /**
     * Процедура обновления спика суден в репозитории.
     * @param postEntity сущность поста.
     * @param vesselDtoList список объектов передачи данных судна.
     */
    @Async
    public void update(PostEntity postEntity, List<VesselDto> vesselDtoList) {
        for (VesselDto vesselDto : vesselDtoList) {
            if (!vesselRepository.existsByMmsi(vesselDto.getMmsi())) {
                vesselRepository.save(VesselMapper.INSTANCE.toEntity(vesselDto, postEntity));
            }
        }
    }
}
