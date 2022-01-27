package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.configs.AsyncConfig;
import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@EnableScheduling
public class ParserService {
    private final VesselService vesselService;
    private final VesselRouteService vesselRouteService;
    private final PostRepository postRepository;
    private final PostApiClientService postApiClientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfig.class);

    public ParserService(VesselService vesselService, VesselRouteService vesselRouteService, PostRepository postRepository, PostApiClientService postApiClientService) {
        this.vesselService = vesselService;
        this.vesselRouteService = vesselRouteService;
        this.postRepository = postRepository;
        this.postApiClientService = postApiClientService;
    }

    @Async
    public void uploadData(PostEntity postEntity) {
        List<VesselDto> vesselDtoList = postApiClientService.parseToList(postEntity);
        vesselService.update(postEntity, vesselDtoList);
        vesselRouteService.add(vesselDtoList);
        LOGGER.info(postEntity.getName() + " port parsed");
    }

    @Scheduled(fixedRate = 120000)
    protected void parserScheduler() {
        //ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
        ExecutorService service = Executors.newFixedThreadPool(4);

        class Task implements Runnable {
            PostEntity postEntity;
            Task(PostEntity p) { postEntity = p; }
            public void run() {
                uploadData(postEntity);
            }
        }

        for (PostEntity postEntity : postRepository.findAll()) {
            //executor.scheduleAtFixedRate(new Task(postEntity), 1, 20, TimeUnit.SECONDS);
            service.execute(new Task(postEntity));
        }
    }
}
