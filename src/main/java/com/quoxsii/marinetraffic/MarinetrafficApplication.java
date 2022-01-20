package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.services.AisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Timer;

@SpringBootApplication
@EnableScheduling
public class MarinetrafficApplication {
	@Autowired
	AisService aisService;

	public static void main(String[] args) {
		SpringApplication.run(MarinetrafficApplication.class, args);

		//Timer timer = new Timer();
		//timer.schedule(new AisParserTimerTask(), 5000, 5000);
	}

	@Scheduled(fixedRate = 5000)
	private void uploadData() {
		aisService.save("");
	}
}
