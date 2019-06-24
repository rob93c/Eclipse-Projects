package it.academy_modis;

/**
 * Classe che istanzia un
 * oggetto di tipo libro
 * 
 * @author Roberto Cella
 *
 *
 */
public class Libro extends Object {
	private String titolo;
	private Autore autore;
	private int numeroPagine;
	
	public Libro(String titolo, Autore autore, int numeroPagine) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.numeroPagine = numeroPagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public Autore getAutore() {
		return autore;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	
	
}
