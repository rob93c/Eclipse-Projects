package it.academy_modis;

public class EsempioThread1 extends Thread {
	
	@Override
	public void run() {
		System.out.println("Sono un thread");
		
		for(int i = 1; i < 6; i++) {
			System.out.println("Nome thread " + Thread.currentThread().getName() + "; numero " + i);
		}
	}
	
	
}
