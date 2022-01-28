package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRouteEntity;
import com.quoxsii.marinetraffic.exceptions.VesselNotFoundException;
import com.quoxsii.marinetraffic.mappers.VesselMapper;
import com.quoxsii.marinetraffic.models.Vessel;
import com.quoxsii.marinetraffic.repositories.VesselRouteRepository;
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
     * Поле репозиторий муршрутов судна.
     */
    private final VesselRouteRepository vesselRouteRepository;

    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param vesselRepository репозиторий суден.
     * @param vesselRouteRepository репозиторий муршрутов судна.
     */
    public VesselService(VesselRepository vesselRepository, VesselRouteRepository vesselRouteRepository) {
        this.vesselRepository = vesselRepository;
        this.vesselRouteRepository = vesselRouteRepository;
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
        //зачем при получении всез судов получать сразу все изменения из динамических параметров?
        // Достаточно получить лишь последний актуальный показатель его динамических данных
        // Да и в идеале при получении судна из базы у тебя должны автоматически в объект попадать
        // связанная с ним информация о его динамических параметрах без отдельного на это запроса
        // Подумай над этим
        // +++
        // Если у тебя в базе будет 100к судов и по ним 10к записей треков для каждого, то ты
        // выполнишь 100к * 10к + 1 запрос. А теперь подумай, будет ли база тормозить если к ней делать столько запросов?)
        for (VesselEntity vesselEntity : vesselEntityList) {
            List<VesselRouteEntity> vesselRouteEntityList = vesselRouteRepository.findByVesselEntity(vesselEntity);
            vesselList.add(VesselMapper.INSTANCE.toModel(vesselEntity, vesselRouteEntityList.get(vesselRouteEntityList.size() - 1)));
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
        // аналогично методу выше, хибернейт должен автоматически брать связанную сущность VesselRouteEntity из базы
        // при запросе инфы о судне - это в данном случае
        // Если же ты сделаешь метод типа "Дай мне статическую информацию о судне", то VesselRouteEntity туда попадать не должен
        List<VesselRouteEntity> vesselRouteEntityList = vesselRouteRepository.findByVesselEntity(vesselEntity);
        return VesselMapper.INSTANCE.toModel(vesselEntity, vesselRouteEntityList.get(vesselRouteEntityList.size() - 1));
    }

    /**
     * Процедура обновления спика суден в репозитории.
     * @param postEntity сущность поста.
     * @param vesselDtoList список объектов передачи данных судна.
     */
    @Async
    public void update(PostEntity postEntity, List<VesselDto> vesselDtoList) {
        for (VesselDto vesselDto : vesselDtoList) {
            //зачем эта проверка?
            //если судна нет, то просто запиши его как новое
            if (!vesselRepository.existsByMmsi(vesselDto.getMmsi())) {
                //тут разве из VesselDto заполняется инфа VesselRouteEntity ?
                //если да, то маппер какой-то божественный получается)
                vesselRepository.save(VesselMapper.INSTANCE.toEntity(vesselDto, postEntity));
            }
        }
    }
}
