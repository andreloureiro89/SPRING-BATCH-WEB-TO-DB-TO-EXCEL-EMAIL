package com.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BatchApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
