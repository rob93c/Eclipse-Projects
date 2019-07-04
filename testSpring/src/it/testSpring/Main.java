package it.testSpring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.testSpring.controller.Controller;
import it.testSpring.model.UtenteDao;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = null;
		try {
			
			context = new ClassPathXmlApplicationContext("/spring/application-context.xml");
			
			UtenteDao utente = (UtenteDao)context.getBean("dao");
			Controller controller = new Controller();
			controller.stampaLista(utente.getAllUsers());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(context != null) {
				context.registerShutdownHook();
			System.exit(0);
			}
		}
		
	}

}
