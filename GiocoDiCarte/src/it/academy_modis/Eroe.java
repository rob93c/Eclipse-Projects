package it.academy_modis;

public class Eroe implements Umano {
	
	private int forza;
	
	public Eroe() {
		this.forza = 10;
	}
	
	public void combatti() {
		this.forza -= 2;
	}
	
	public void stampaForza() {
		System.out.println("Forza eroe: " + this.forza);
	}
}
