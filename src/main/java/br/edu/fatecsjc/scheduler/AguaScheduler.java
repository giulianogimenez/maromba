package br.edu.fatecsjc.scheduler;

import java.time.LocalDateTime;

import org.quartz.CronExpression;
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
import org.quartz.impl.calendar.CronCalendar;
import org.quartz.impl.matchers.KeyMatcher;

import br.edu.fatecsjc.jobs.AguaJob;
import br.edu.fatecsjc.listeners.AguaJobListener;

public class AguaScheduler {
	
	public void iniciarAguaScheduler(String nomeAluno, int horaInicial, int horaFinal, int intervalo) throws SchedulerException {
		JobDataMap map = new JobDataMap();
		map.put("nomeAluno", nomeAluno);
		map.put("jobName", "agua");
		JobKey jobKey = new JobKey(nomeAluno, "agua");
		JobDetail job = JobBuilder.newJob(AguaJob.class).setJobData(map)
				.withIdentity(jobKey).build();
		
        		
		Trigger triggerCron = TriggerBuilder
				.newTrigger()
				.withIdentity(nomeAluno, "agua")
				.withSchedule(
					CronScheduleBuilder.cronSchedule(String.format("%d %d/%d %d-%d * * ?", LocalDateTime.now().getSecond(), LocalDateTime.now().getMinute(), intervalo, horaInicial, horaFinal)))
				.build();

		// schedule it
		
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getListenerManager().addJobListener(new AguaJobListener(), KeyMatcher.keyEquals(jobKey));
		scheduler.start();
		scheduler.scheduleJob(job, triggerCron);
	}
}
