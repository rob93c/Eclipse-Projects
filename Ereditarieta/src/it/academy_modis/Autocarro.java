package it.academy_modis;

public class Autocarro extends Veicolo {
	
	private int capacitaMassima;
	
	public Autocarro(String marca, String modello, int cilindrata, int numeroRuote, int capacitaMassima) {
		super(marca, modello, cilindrata, numeroRuote);
		this.capacitaMassima = capacitaMassima;
	}

	@Override
	protected void stampaMarcaModello() {
		System.out.println("Stampa autocarro: " + this.getMarca() + " " + this.getModello());
		
	}
	
	
	
	
	
}
