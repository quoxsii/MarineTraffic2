package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.dtos.PostApiClientDto;
import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import com.quoxsii.marinetraffic.services.PostApiClientService;
import com.quoxsii.marinetraffic.services.PostService;
import com.quoxsii.marinetraffic.services.VesselRecordService;
import com.quoxsii.marinetraffic.services.VesselService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class MarineTrafficApplication {
	private final PostService postService;
	private final VesselService vesselService;
	private  final VesselRecordService vesselRecordService;
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
	}

	@Scheduled(fixedRate = 20000)
	private void updateData() {
		if (postService.getAll().isEmpty()) {
			System.out.println("Posts not found, data loading has stopped");
			return;
		}

		for (PostEntity postEntity : postRepository.findAll()) {
			List<PostApiClientDto> postApiClientDto = postApiClientService.parse(postEntity);
			vesselService.update(postEntity, postApiClientDto);
			vesselRecordService.add(postEntity, postApiClientDto);
		}
	}
}
