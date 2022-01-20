package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.entities.AisEntity;
import com.quoxsii.marinetraffic.models.AisDto;
import com.quoxsii.marinetraffic.repositories.AisRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import com.quoxsii.marinetraffic.services.AisApiClient;
import com.quoxsii.marinetraffic.services.AisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableScheduling
public class MarinetrafficApplication {
	@Autowired
	AisService aisService;
	@Autowired
	AisApiClient aisApiClient;
	@Autowired
	AisRepository aisRepository;
	@Autowired
	VesselRepository vesselRepository;
	@Autowired
	VesselRecordRepository vesselRecordRepository;

	public static void main(String[] args) {
		SpringApplication.run(MarinetrafficApplication.class, args);
	}

	@Scheduled(fixedRate = 20000)
	private void uploadData() {
		aisRepository.deleteAll();
		vesselRepository.deleteAll();
		vesselRecordRepository.deleteAll();
		aisService.save("post");
	}
}
