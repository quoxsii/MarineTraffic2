package com.quoxsii.marinetraffic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarinetrafficApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MarinetrafficApplication.class, args);

		Thread thread = new Thread(new AisParserThread(), "parser");
		thread.start();
	}
}
