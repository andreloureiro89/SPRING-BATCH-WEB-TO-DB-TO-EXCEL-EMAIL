package com.spring.batch.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.batch.service.H2DataBase;
import com.spring.batch.service.JobService;

@Component
public class StepListener implements StepExecutionListener {
	
	@Autowired
	public JobService jobService;
	
	@Autowired
	public H2DataBase h2DataBase;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println();
		System.out.println("--- BEFORE STEP GET EXECUTED");
		System.out.println("--- 2º SAVE DATA ON H2 DATABASE");
		System.out.println();
		
		h2DataBase.insertUser(jobService.getList());
	}

	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println();
		System.out.println("AFTER STEP GET EXECUTED CREATE CSV FILE WITH DATA AND SAVE LOCALLY");
		System.out.println();
		jobService.createExecelFile();
		return null;
	}

}
