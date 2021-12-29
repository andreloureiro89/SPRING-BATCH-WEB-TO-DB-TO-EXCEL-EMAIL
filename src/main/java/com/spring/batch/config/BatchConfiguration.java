package com.spring.batch.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batch.listeners.JobListener;
import com.spring.batch.listeners.StepListener;
import com.spring.batch.model.User;
import com.spring.batch.service.H2DataBase;
import com.spring.batch.service.JobService;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobs;	
	
	@Autowired
	public StepBuilderFactory steps;
	
	@Autowired
	public JobListener jobListener;
	
	@Autowired
	public StepListener stepListener;
	
	@Autowired
	public H2DataBase h2DataBase;
	
	
	@Autowired
	public JobService jobService;

	
    public Tasklet theRealJob(){
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println();
                System.out.println("###############################################################");
            	System.out.println("######################## EXECUTE THE JOB ######################");
                System.out.println();
        		System.out.println("GET DATA FROM DATA BASE AND PROCESS DATA");
        		jobService.setList(h2DataBase.getData());
                System.out.println();
            	System.out.println("################### PROCESS HAS BEEN COMPLETED #################");
                System.out.println("################################################################");
 
                return RepeatStatus.FINISHED;
            }
        });
    }
	
	@Bean
	public Step step1() {
		return steps.get("SPRING-BATCH STEP")
				.listener(stepListener)
				.tasklet(theRealJob())
				.build();
	}
	
	@Bean 
	public Job jobExample() {
		return jobs.get("SPRING-BATCH JOB")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.start(step1())
				.build();
	}
	
	

}
