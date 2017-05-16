package br.edu.fatecsjc.jobs;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ComidaJob implements org.quartz.Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//System.out.println(LocalDateTime.now(ZoneId.systemDefault())  + " - " + context.getJobDetail().getJobDataMap().get("nomeAluno") + " - Vá comer!");
		JOptionPane.showMessageDialog(null,LocalDateTime.now().toString() + " - " + context.getJobDetail().getJobDataMap().get("nomeAluno") +  " - Vá comer!");
	}

}
