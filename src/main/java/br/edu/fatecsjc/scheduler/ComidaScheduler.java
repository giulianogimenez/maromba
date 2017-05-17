package br.edu.fatecsjc.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import br.edu.fatecsjc.jobs.*;
import br.edu.fatecsjc.listeners.AguaJobListener;
import br.edu.fatecsjc.listeners.ComidaJobListener;

public class ComidaScheduler {
	public void iniciarComidaScheduler(String nomeAluno, int horaInicial, int horaFinal, int intervalo) throws SchedulerException {
		JobKey jobKey = new JobKey(nomeAluno, "comida");
		JobDataMap map = new JobDataMap();
		map.put("nomeAluno", nomeAluno);
		map.put("jobName", "comida");
		JobDetail job = JobBuilder.newJob(ComidaJob.class).setJobData(map)
				.withIdentity(jobKey).build();
		Trigger triggerCron = TriggerBuilder
				.newTrigger()
				.withIdentity(nomeAluno, "comida")
				.withSchedule(
					CronScheduleBuilder.cronSchedule(String.format("%d %d/%d %d-%d * * ?", 
							LocalDateTime.now().getSecond(), LocalDateTime.now().getMinute(), intervalo, horaInicial, horaFinal)))
				.build();

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getListenerManager().addJobListener(new ComidaJobListener(), KeyMatcher.keyEquals(jobKey));
		scheduler.start();
		scheduler.scheduleJob(job, triggerCron);
	}
}
