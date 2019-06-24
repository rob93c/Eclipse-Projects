package it.academy_modis;

/**
 * Classe che rappresenta una persona
 * 
 * @author Roberto Cella
 * @version 1.0
 * 
 * 
 */
public class Persona {
	
	// variabili di istanza
	private String nome, cognome;
	private int eta;
	private String cf;
	private TitoloDiStudio titolo;
	
	// costruttori
	public Persona(String nome, String cognome, int eta, String cf, TitoloDiStudio titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.cf = cf;
		this.titolo = titolo;
	}

	public Persona(String nome, String cognome, int eta, String cf) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.cf = cf;
	}
	
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
 	
	// getter and setter
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String printNomeECognome() {
		return this.nome + " " + this.cognome;
		// String s = this.getNome() + " " + this.getCognome();
		// return s;
	}

	public TitoloDiStudio getTitolo() {
		return titolo;
	}

	public void setTitolo(TitoloDiStudio titolo) {
		this.titolo = titolo;
	}
	
}
