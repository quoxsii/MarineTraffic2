package com.quoxsii.marinetraffic.tasks;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.services.PostApiClientService;
import com.quoxsii.marinetraffic.services.VesselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParserTask implements Runnable {
    private final VesselService vesselService;
    private final PostApiClientService postApiClientService;

    private final AtomicBoolean running = new AtomicBoolean(false);
    private final Logger logger = LoggerFactory.getLogger(ParserTask.class);

    private Post post;

    public ParserTask(VesselService vesselService, PostApiClientService postApiClientService) {
        this.vesselService = vesselService;
        this.postApiClientService = postApiClientService;
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            for (VesselDto vesselDto : postApiClientService.parseToList(post)) {
                vesselService.updateByDto(vesselDto, post);
            }
            logger.info("Post " + post.getName() + " has been parsed");
            shutdown();
        }
    }

    public void shutdown() {
        running.set(false);
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
