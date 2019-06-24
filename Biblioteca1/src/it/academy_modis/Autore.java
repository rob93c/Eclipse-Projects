package it.academy_modis;

/**
 * Classe che istanzia un
 * oggetto di tipo Autore
 * 
 * @author Roberto Cella
 *
 *
 */
public class Autore {
	private String nome;
	private String cognome;
	
	public Autore(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
}
