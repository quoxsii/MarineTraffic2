package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.configs.ParserTaskFactory;
import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.tasks.ParserTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ParserRunner implements CommandLineRunner {
    private final PostService postService;
    private final ParserTaskFactory parserTaskFactory;
    private final VesselService vesselService;
    private final PostApiClientService postApiClientService;

    private final Logger logger = LoggerFactory.getLogger(ParserTask.class);

    public ParserRunner(PostService postService, ParserTaskFactory parserTaskConfig, VesselService vesselService, PostApiClientService postApiClientService) {
        this.postService = postService;
        this.parserTaskFactory = parserTaskConfig;
        this.vesselService = vesselService;
        this.postApiClientService = postApiClientService;
    }

    @Override
    public void run(String... args) {
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(() ->
        {
            try {
                scheduler.setCorePoolSize(postService.getAll().size());
                scheduler.setMaximumPoolSize(postService.getAll().size());
                for (Post post : postService.getAll()) {
                    ParserTask parserTask = parserTaskFactory.createParserTask(vesselService, postApiClientService);
                    parserTask.setPost(post);
                    scheduler.execute(parserTask);
                }
            } catch (PostNotFoundException e) {
                e.printStackTrace();
            }
        }, 1, 10, TimeUnit.SECONDS);
        logger.info("Scheduler has done");
    }
}
