package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.tasks.ParserTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class ParserService {
    private final PostService postService;
    private final ParserTask parserTask;

    public ParserService(PostService postService, ParserTask parserTask) {
        this.postService = postService;
        this.parserTask = parserTask;
    }

    @Bean
    public CommandLineRunner schedulingRunner(ThreadPoolTaskScheduler scheduler) {
        return args -> {
            for (Post post : postService.getAll())
            {
                parserTask.setPost(post);
                scheduler.scheduleAtFixedRate(parserTask, 5000);
            }
        };
    }
}
