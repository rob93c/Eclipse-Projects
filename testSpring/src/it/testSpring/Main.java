package it.testSpring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.testSpring.controller.Controller;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext context = null;
		try {

			context = new ClassPathXmlApplicationContext("/spring/application-context.xml");

			Controller controller = (Controller) context.getBean("controller");

			controller.stampaLista();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				context.registerShutdownHook();
				System.exit(0);
			}
		}

	}

}
