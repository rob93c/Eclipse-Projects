package it.academy_modis;

public class Pizza {
	private String nome;
	private double prezzo;
	
	public Pizza(String nome, double prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
