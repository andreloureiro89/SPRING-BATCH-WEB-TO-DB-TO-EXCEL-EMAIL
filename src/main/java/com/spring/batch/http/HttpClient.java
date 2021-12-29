package com.spring.batch.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.batch.model.User;

@Component
public class HttpClient {
		
	@Autowired
	public User user;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public HttpClientConfig http;
		
	public List<User> getData() {
		
		List<User> usersList = new ArrayList<User>();
		String url = http.UrlPath;
		User[] response = restTemplate.getForObject(url, User[].class);


		for (int i = 0; i < response.length; i++) {
			usersList.add(response[i]);
		}
		
		return usersList;
	}

}
