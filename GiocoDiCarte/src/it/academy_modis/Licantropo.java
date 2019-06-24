package it.academy_modis;

public class Licantropo implements Umano, Mostro {
	
	private int forzaMostro;
	private int forzaUmano;
	private boolean lunaPiena;
	
	public Licantropo(boolean lunaPiena) {
		this.lunaPiena = true;
		if(lunaPiena) {
			this.forzaMostro = 15;
			this.forzaUmano = 0;
		} else {
			this.forzaMostro = 0;
			this.forzaUmano = 10;
		}
	}
	
	public void combatti() {
		this.forzaUmano -= 2;	
	}
	
	public void azzanna() {
		this.forzaMostro -= 3;
	}
	
	public void stampaForza() {
		if(this.lunaPiena) {
			System.out.println("Forza licantropo come mostro: " + this.forzaMostro); 
		} else {
			System.out.println("Forza licantropo come umano: " + this.forzaUmano);
		}
	}
}
