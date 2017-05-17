package br.edu.fatecsjc.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class ComidaJobListener implements JobListener {

	public static final String LISTENER_NAME = "comidaListener";
	
	public String getName() {
		return LISTENER_NAME;
	}

	public void jobExecutionVetoed(JobExecutionContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void jobToBeExecuted(JobExecutionContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException arg1) {
		// TODO Auto-generated method stub
		System.out.println(context.getJobDetail().getJobDataMap().get("nomeAluno") + " comeu!");
	}

}
