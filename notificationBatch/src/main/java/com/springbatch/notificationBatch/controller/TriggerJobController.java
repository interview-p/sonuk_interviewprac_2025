package com.springbatch.notificationBatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invokejob")
public class TriggerJobController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	public void runJob() {
		
		try {
			
			JobParameters jobParameters = new JobParametersBuilder()
                    .addString("fileName", "data.csv")
                    .addLong("timestamp", System.currentTimeMillis())
                    .toJobParameters();
			
			JobExecution jobExecution = jobLauncher.run((org.springframework.batch.core.Job) job, jobParameters);
			System.out.println("job status = "+jobExecution.getStartTime());
			
		}
		catch (Exception e) {
			
		}
	}
	
}
