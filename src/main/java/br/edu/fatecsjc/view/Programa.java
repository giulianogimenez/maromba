package br.edu.fatecsjc.view;

import org.quartz.SchedulerException;

import br.edu.fatecsjc.scheduler.AguaScheduler;
import br.edu.fatecsjc.scheduler.ComidaScheduler;

public class Programa {
	public static void main(String[] args) throws SchedulerException {
		AguaScheduler aguaSchedulerBonfa = new AguaScheduler();
		aguaSchedulerBonfa.iniciarAguaScheduler("Bonfá", 3);
		
		ComidaScheduler comidaSchedulerBonfa = new ComidaScheduler();
		comidaSchedulerBonfa.iniciarComidaScheduler("Bonfá", 10);
		
		AguaScheduler aguaSchedulerGiu = new AguaScheduler();
		aguaSchedulerGiu.iniciarAguaScheduler("Giu", 5);
		
		ComidaScheduler comidaSchedulerGiu = new ComidaScheduler();
		comidaSchedulerGiu.iniciarComidaScheduler("Giu", 15);
	}
}
