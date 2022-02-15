package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.tasks.ParserTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ParserService implements CommandLineRunner {
    final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

    private final PostService postService;
    private final ParserTask parserTask;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserService.class);

    public ParserService(PostService postService, ParserTask parserTask) {
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("parserThread-");
        scheduler.initialize();
        this.postService = postService;
        this.parserTask = parserTask;
    }

    @Override
    public void run(String... args) {
        try {
            for (Post post : postService.getAll()) {
                scheduler.scheduleAtFixedRate(parserTask, 20000);
            }
        } catch (PostNotFoundException ex) {
            LOGGER.info(ex.toString());
        }
    }
}
