package it.academy_modis;

/**
 * Classe per rappresentare 
 * l'autore di un libro
 * 
 * @author Roberto Cella
 * @version 1.0
 * 
 * 
 */
public class Autore {
	private String nome;
	private String cognome;
	private String nazionalita;
	
	public Autore(String nome, String cognome, String nazionalita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public String printAutore() {
		return this.nome + " " + this.cognome + ", di nazionalità " + this.nazionalita;
	}
	

}

