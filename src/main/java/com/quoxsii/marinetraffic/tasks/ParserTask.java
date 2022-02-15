package com.quoxsii.marinetraffic.tasks;

import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.services.VesselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ParserTask implements Runnable {
    private final int INTERVAL = 20000;

    private Thread worker;
    private Post post;
    private final AtomicBoolean running = new AtomicBoolean(false);

    private final VesselService vesselService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserTask.class);

    public ParserTask(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    public void start(Post post) {
        this.post = post;
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                vesselService.update(post);
                LOGGER.info("Post '" + post.getName() + "' has been parsed");
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
