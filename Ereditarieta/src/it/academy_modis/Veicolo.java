package it.academy_modis;

public abstract class Veicolo extends MezzoDiTrasporto {
	
	private int cilindrata;
	private int numeroRuore;
	
	public Veicolo() {
		
	}
	
	public Veicolo(String marca, String modello, int cilindrata, int numeroRuote) {
		super(marca, modello);
		this.cilindrata = cilindrata;
		this.numeroRuore = numeroRuote;
	}
	
	protected abstract void stampaMarcaModello();
//		System.out.println("Stampa veicolo generico: " + this.marca + " " + this.modello);

	protected int getCilindrata() {
		return cilindrata;
	}

	protected int getNumeroRuore() {
		return numeroRuore;
	}
	
	
	
	
}
