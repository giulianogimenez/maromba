package br.edu.fatecsjc.view;

import javax.swing.JOptionPane;

import org.quartz.SchedulerException;

import br.edu.fatecsjc.scheduler.AguaScheduler;
import br.edu.fatecsjc.scheduler.ComidaScheduler;

public class Programa {
	public static void main(String[] args) throws SchedulerException {
		
		JOptionPane.showMessageDialog(null, "Água Scheduler");
		String nome = JOptionPane.showInputDialog("Informe o nome");
		int horaInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe a hora inicial"));
		int horaFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe a hora final"));
		int intervaloMinuto = Integer.parseInt(JOptionPane.showInputDialog("Informe o intervalo em minutos"));
		
		AguaScheduler aguaSchedulerBonfa = new AguaScheduler();
		aguaSchedulerBonfa.iniciarAguaScheduler(nome, horaInicial, horaFinal, intervaloMinuto);
		
		JOptionPane.showMessageDialog(null, "Comida Scheduler");
		horaInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe a hora inicial"));
		horaFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe a hora final"));
		intervaloMinuto = Integer.parseInt(JOptionPane.showInputDialog("Informe o intervalo em minutos"));
		
		//teste2
		ComidaScheduler comidaSchedulerBonfa = new ComidaScheduler();
		comidaSchedulerBonfa.iniciarComidaScheduler(nome, 6, 21, 1);
	}
}


