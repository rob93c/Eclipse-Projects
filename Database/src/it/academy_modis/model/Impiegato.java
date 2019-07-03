package it.academy_modis.model;

public class Impiegato {
	
	private String nome;
	private String cognome;
	private int id_sup;
	
	public Impiegato(String nome, String cognome, int id_sup) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.id_sup = id_sup;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getId_sup() {
		return id_sup;
	}
	
	
	
}
