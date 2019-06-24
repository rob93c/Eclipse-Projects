package it.academy_modis;

public class Mago implements Umano {
	
	private int forza;
	
	public Mago() {
		this.forza = 15;
	}
	
	public void stampaForza() {
		System.out.println("Forza mago: " +  this.forza);
	}

	public void combatti() {
		this.forza -= 6;	
	}
}
