package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.mappers.VesselMapper;
import com.quoxsii.marinetraffic.mappers.VesselRouteMapper;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import com.quoxsii.marinetraffic.repositories.VesselRouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис суден.
 */
@Service
public class VesselService {
    /**
     * Поле репозиторий постов.
     */
    private final PostRepository postRepository;
    /**
     * Поле репозиторий суден.
     */
    private final VesselRepository vesselRepository;
    /**
     * Поле репозиторий муршрутов судна.
     */
    private final VesselRouteRepository vesselRouteRepository;
    /**
     * Поле маппер суден.
     */
    private final VesselMapper vesselMapper;
    /**
     * Поле маппер маршрутов суден.
     */
    private final VesselRouteMapper vesselRouteMapper;


    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param postRepository репозиторий постов.
     * @param vesselRepository репозиторий суден.
     * @param vesselRouteRepository репозиторий муршрутов судна.
     * @param vesselMapper маппер суден.
     * @param vesselRouteMapper маппер маршрутов суден.
     */
    public VesselService(PostRepository postRepository, PostApiClientService postApiClientService, VesselRepository vesselRepository, VesselRouteRepository vesselRouteRepository, VesselMapper vesselMapper, VesselRouteMapper vesselRouteMapper) {
        this.postRepository = postRepository;
        this.vesselRepository = vesselRepository;
        this.vesselRouteRepository = vesselRouteRepository;
        this.vesselMapper = vesselMapper;
        this.vesselRouteMapper = vesselRouteMapper;
    }

    /**
     * Метод получения списка всех моделей суден.
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
            vesselList.add(vesselMapper.toModel(vesselEntity, vesselRouteRepository.findTopByVesselEntityOrderByIdDesc(vesselEntity)));
        }
        return vesselList;
    }

    /**
     * Метод получения модели по морскому идентификатору мобильной службы.
     * @param mmsi морской идентификатор мобильной службы.
     * @return возвращает модель судна.
     * @throws VesselNotFoundException возникает когда в репозитории не зарегистрировано ни одного судна с указанным морским идентификатором мобильной службы.
     */
    public Vessel getByMmsi(String mmsi) throws VesselNotFoundException {
        VesselEntity vesselEntity = vesselRepository.findByMmsi(mmsi);
        if(vesselEntity == null) {
            throw new VesselNotFoundException("Судно не найдено");
        }
        return vesselMapper.toModel(vesselEntity, vesselRouteRepository.findTopByVesselEntityOrderByIdDesc(vesselEntity));
    }

    /**
     * Метод обновления спика суден и маршрутов в репозитории.
     * @param vesselDto объект передачи данных судна.
     * @param post модель поста.
     */
    public void updateByDto(VesselDto vesselDto, Post post) {
        VesselEntity vesselEntity = vesselRepository.findByMmsi(vesselDto.getMmsi());
        if (vesselEntity == null) {
            vesselEntity = vesselRepository.save(vesselMapper.toEntity(vesselDto, postRepository.findById(post.getId()).get()));
        }
        vesselRouteRepository.save(vesselRouteMapper.toEntity(vesselDto, vesselEntity));
    }
}
