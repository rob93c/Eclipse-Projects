package it.academy_modis;

public class Amico {
	
	private String nome;
	private String cognome;
	private int eta;
	
	public Amico(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getCognome() {
		return cognome;
	}

	protected void setCognome(String cognome) {
		this.cognome = cognome;
	}

	protected int getEta() {
		return eta;
	}

	protected void setEta(int eta) {
		this.eta = eta;
	}
	
}
