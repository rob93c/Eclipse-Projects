package it.academy_modis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// Classe che estende Thread
		EsempioThread1 etd = new EsempioThread1();
//		EsempioThread1 etd1 = new EsempioThread1();
		
		// Classe che implementa Runnable
		EsempioInterfacciaRunnable eir = new EsempioInterfacciaRunnable();
		Thread thread = new Thread(eir);
		
//		System.out.println(etd instanceof Runnable); // true perché Thread implements Runnable
//		System.out.println(etd instanceof Thread);
//		System.out.println(etd instanceof EsempioThread1);
		
		thread.start();
//		etd.start();
		
//		etd.run(); // run non va mai lanciato, 
//		etd.run(); // si usa start al suo posto
		
		// permette di eseguire più thread alla volta in modo automatico
		ExecutorService es = Executors.newFixedThreadPool(4);
			for(int i = 1; i < 4; i++) {
				Thread th = new Thread(eir);
				es.submit(th);			
			}
		es.shutdown();
	}
	
	// Con il metodo .join() sui thread diciamo a
	// al thread di aspettare di finire le sue operazioni
}

