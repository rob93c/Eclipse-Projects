package it.academy_modis;

public class Vampiro implements Mostro {
	private int forza;
	
	public Vampiro() {
		this.forza = 15;
	}
	
	public void azzanna() {
		this.forza -= 3;
	}
	
	public void stampaForza() {
		System.out.println("Forza vampiro: " + this.forza);
	}
}
