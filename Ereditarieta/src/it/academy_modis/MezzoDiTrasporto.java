package it.academy_modis;

public class MezzoDiTrasporto {
	
	private String marca;
	private String modello;
	
	public MezzoDiTrasporto() {
		
	}
	
	public MezzoDiTrasporto(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}
	
	protected String getMarca() {
		return marca;
	}

	protected String getModello() {
		return modello;
	}
	
}
