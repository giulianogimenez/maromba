package br.edu.fatecsjc.view;

import org.quartz.SchedulerException;

import br.edu.fatecsjc.scheduler.AguaScheduler;
import br.edu.fatecsjc.scheduler.ComidaScheduler;

public class Programa {
	public static void main(String[] args) throws SchedulerException {
		
		//JOption
		//String nome = JOptionPane.showInputDialog("Informe o nome");
		
		AguaScheduler aguaSchedulerBonfa = new AguaScheduler();
		aguaSchedulerBonfa.iniciarAguaScheduler("Bonfá", 6, 23, 1);
		
		ComidaScheduler comidaSchedulerBonfa = new ComidaScheduler();
		comidaSchedulerBonfa.iniciarComidaScheduler("Bonfá", 6, 21, 1);
	}
}


