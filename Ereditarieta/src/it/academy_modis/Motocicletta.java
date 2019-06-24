package it.academy_modis;

public class Motocicletta extends Veicolo {
	
	public Motocicletta(String marca, String modello, int cilindrata) {
		super(marca, modello, cilindrata, 2);
	}

	@Override
	protected void stampaMarcaModello() {
		System.out.println("Stampa motocicletta: " + this.getMarca() + " " + this.getModello());
		
	}
}
