package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.dtos.VesselDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import com.quoxsii.marinetraffic.services.PostApiClientService;
import com.quoxsii.marinetraffic.services.PostService;
import com.quoxsii.marinetraffic.services.VesselRecordService;
import com.quoxsii.marinetraffic.services.VesselService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableScheduling
public class MarineTrafficApplication {
	private final PostService postService;
	private final VesselService vesselService;
	private final VesselRecordService vesselRecordService;
	private final PostRepository postRepository;
	private final PostApiClientService postApiClientService;

	public MarineTrafficApplication(PostService postService, VesselService vesselService, VesselRecordService vesselRecordService, PostRepository postRepository, PostApiClientService postApiClientService) {
		this.postService = postService;
		this.vesselService = vesselService;
		this.vesselRecordService = vesselRecordService;
		this.postRepository = postRepository;
		this.postApiClientService = postApiClientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MarineTrafficApplication.class, args);

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName());
		};
		scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
	}

//	@Scheduled(fixedRate = 120000)
//	private void updateData() {
//		System.out.println("Saved");
//		if (postService.getAll().isEmpty()) {
//			System.out.println("Posts not found, data loading has stopped");
//			return;
//		}
//
//		for (PostEntity postEntity : postRepository.findAll()) {
//			List<VesselDto> vesselDto = postApiClientService.parseToList(postEntity);
//			vesselService.update(postEntity, vesselDto);
//			vesselRecordService.add(vesselDto);
//		}
//	}
}


