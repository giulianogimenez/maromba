package br.edu.fatecsjc.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.edu.fatecsjc.jobs.AguaJob;
import br.edu.fatecsjc.jobs.ComidaJob;

public class ComidaScheduler {
	public void iniciarComidaScheduler(String nomeAluno, int intervalo) throws SchedulerException {
		JobDataMap map = new JobDataMap();
		map.put("nomeAluno", nomeAluno);
		JobDetail job = JobBuilder.newJob(ComidaJob.class).setJobData(map)
				.withIdentity(nomeAluno + "-comida", "comida").build();
		
        //Quartz 1.6.3
		// SimpleTrigger trigger = new SimpleTrigger();
		// trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		// trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		// trigger.setRepeatInterval(30000);

		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity(nomeAluno, "-comida")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(intervalo).repeatForever())
			.build();

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}