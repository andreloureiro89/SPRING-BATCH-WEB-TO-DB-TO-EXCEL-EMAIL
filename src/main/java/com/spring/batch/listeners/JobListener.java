package com.spring.batch.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.batch.http.HttpClient;
import com.spring.batch.model.User;
import com.spring.batch.service.EmailServiceImpl;
import com.spring.batch.service.JobService;

@Component
public class JobListener implements JobExecutionListener {
	
	@Autowired
	public HttpClient http;
	
	@Autowired
	public User user;
	
	@Autowired
	public JobService jobService;
	
	@Autowired
	public EmailServiceImpl emailService;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		System.out.println();
		System.out.println("============================================================");
		System.out.println("============================================================");
		System.out.println("============================================================");
		System.out.println();
		System.out.println("--- BEFORE JOB GET EXECUTED");
		System.out.println();
        System.out.println("--- 1º GET ALL USERS FROM API");
		
		try {
			jobService.setList(http.getData());
			System.out.println();
			System.out.println("REQUEST SUCCESS");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("REQUEST FAIL");
			System.out.println();
		}
		
		System.out.println();
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println();
		System.out.println("AFTER JOB GET EXECUTED SEND EMAIL TO NOTIFY");
		System.out.println("============================================================");
		System.out.println();
		emailService.sendSimpleMessage("YOUR.EMAIL@gmail.com", "SPRING-BATCH", "Congratulations, you managed to finish a spring-batch.");
	}

}
