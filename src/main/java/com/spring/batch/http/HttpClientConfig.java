package com.spring.batch.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
	
	public String UrlPath = "https://jsonplaceholder.typicode.com/users";
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
