package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.entities.AISEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MarinetrafficApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarinetrafficApplication.class, args);
	}

}
