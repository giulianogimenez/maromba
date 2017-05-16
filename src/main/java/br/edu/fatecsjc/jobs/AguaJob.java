package br.edu.fatecsjc.jobs;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AguaJob implements org.quartz.Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//System.out.println(LocalDateTime.now().toString() + " - " + context.getJobDetail().getJobDataMap().get("nomeAluno") +  " - Beba água!");
		JOptionPane.showMessageDialog(null, LocalDateTime.now().toString() + " - " + context.getJobDetail().getJobDataMap().get("nomeAluno") +  " - Beba água!");
	}
	
	
}
