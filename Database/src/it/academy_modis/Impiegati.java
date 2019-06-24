package it.academy_modis;

public class Impiegati {
	
	private String nome;
	private String cognome;
	private int id_sup;
	
	public Impiegati(String nome, String cognome, int id_sup) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.id_sup = id_sup;
	}

	protected String getNome() {
		return nome;
	}

	protected String getCognome() {
		return cognome;
	}

	protected int getId_sup() {
		return id_sup;
	}
	
	
	
}
