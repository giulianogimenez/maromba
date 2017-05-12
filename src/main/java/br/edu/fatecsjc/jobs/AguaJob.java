package br.edu.fatecsjc.jobs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AguaJob implements org.quartz.Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(LocalDateTime.now().toString() + " - " + context.getJobDetail().getJobDataMap().get("nomeAluno") +  " - Beba água!");
	}
	
	
}
