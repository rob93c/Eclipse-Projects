package it.academy_modis;

public class Smartphone {
	
	private String marca;
	private String modello;
	
	public Smartphone(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected String getModello() {
		return modello;
	}

	protected void setModello(String modello) {
		this.modello = modello;
	}

	public Smartphone() {
		super();
	}
	
	
}
