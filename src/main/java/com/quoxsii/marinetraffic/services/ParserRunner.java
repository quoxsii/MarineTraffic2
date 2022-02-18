package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.configs.ParserTaskFactory;
import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.tasks.ParserTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ParserRunner implements CommandLineRunner {
    private final PostService postService;
    private final ParserTaskFactory parserTaskFactory;
    private final VesselService vesselService;
    private final PostApiClientService postApiClientService;

    public ParserRunner(PostService postService, ParserTaskFactory parserTaskConfig, VesselService vesselService, PostApiClientService postApiClientService) {
        this.postService = postService;
        this.parserTaskFactory = parserTaskConfig;
        this.vesselService = vesselService;
        this.postApiClientService = postApiClientService;
    }

    @Override
    public void run(String... args) throws PostNotFoundException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(postService.getAll().size());
        for (Post post : postService.getAll()) {
            ParserTask parserTask = parserTaskFactory.createParserTask(vesselService, postApiClientService);
            parserTask.setPost(post);
            scheduler.scheduleAtFixedRate(parserTask, 1, 10, TimeUnit.SECONDS);
        }
    }
}
