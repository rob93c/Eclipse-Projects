package it.academy_modis;
/**
 * Classe per rappresentare
 * le informazioni di un libro
 * 
 * @author Roberto Cella
 *
 */
public class Libro {
	private String titolo;
	private Autore autore;
	private CasaEditrice casaEditrice;
	
	public Libro(String titolo, Autore autore, CasaEditrice casaEditrice) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.casaEditrice = casaEditrice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public CasaEditrice getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(CasaEditrice casaEditrice) {
		this.casaEditrice = casaEditrice;
	}
	
}
