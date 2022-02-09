package com.quoxsii.marinetraffic.tasks;

import com.quoxsii.marinetraffic.configs.SchedulerConfig;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.services.VesselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ParserTask implements Runnable {
    private Post post;

    private final VesselService vesselService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);

    public ParserTask(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @Override
    public void run() {
        vesselService.update(post);
        LOGGER.info("Post '" + post.getName() + "' has been parsed");
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
