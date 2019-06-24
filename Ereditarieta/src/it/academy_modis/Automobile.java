package it.academy_modis;

public class Automobile extends Veicolo {
	
	private int numeroPosti;
	
	public Automobile(String marca, String modello, int cilindrata, int numeroRuote, int numeroPosti) {
		super(marca, modello, cilindrata, numeroRuote);
		this.numeroPosti = numeroPosti;
	}
	
	@Override
	public void stampaMarcaModello() {
		System.out.println("Stampa automobile: " + this.getMarca() + " " + this.getModello());
	}
	
	
	
	
}
