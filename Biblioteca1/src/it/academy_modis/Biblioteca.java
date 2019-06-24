package it.academy_modis;

import java.util.ArrayList;

/**
 * Classe che istanzia un oggetto
 * di tipo biblioteca
 * 
 * 
 * @author Roberto Cella
 * 
 * 
 * 
 */
public class Biblioteca {
	private ArrayList<Autore> listaAutori;
	private ArrayList<Libro> listaLibri;
	private int lun = 0;
	private int index;
	
	public Biblioteca() {
		listaAutori = new ArrayList<Autore>();
		listaLibri = new ArrayList<Libro>();
	}

//	public ArrayList<Autore> getListaAutori() {
//		return listaAutori;
//	}
//
//	public void setListaAutori(ArrayList<Autore> listaAutori) {
//		this.listaAutori = listaAutori;
//	}
	
	public void stampaAutori() {
		for(Autore a: listaAutori) {
			System.out.println(a.getNome() + " " + a.getCognome() + "\n");
		}
	}
	
	public void stampaLibri() {
		for(Libro l: listaLibri) {
			System.out.println("Il libro \"" + l.getTitolo() + "\" di " +
								l.getAutore().getNome() + " " + l.getAutore().getCognome() + 
								", ha " + l.getNumeroPagine() + " pagine.");
		}
	}
	
	/**
	 * 
	 * @param nome il nome dell'autore
	 * @param cognome il cognome dell'autore
	 */
	public void aggiungiAutore(String nome, String cognome) {
		Autore autore = new Autore(nome, cognome);
		if(cercaAutore(nome, cognome)) {
			this.listaAutori.add(autore);
			System.out.println("\nAutore inserito correttamente.\n");
		}
	}
	
	public void aggiungiLibro(String titolo, String nome, String cognome, int numeroPagine) {
		Autore autoreLibro = new Autore(nome, cognome);
		aggiungiAutore(nome, cognome);
		Libro nuovoLibro = new Libro(titolo, autoreLibro, numeroPagine);
		this.listaLibri.add(nuovoLibro);
		System.out.println("\nLibro aggiunto correttamente alla lista.\n");
	}
	
	public void totAutori() {
		System.out.println(listaAutori.size());
	}
	
	/**
	 * 
	 * @param nome nome dell'autore da cercare
	 * @param cognome cognome dell'autore da cercare
	 * @return se l'autore esiste nella biblioteca
	 */
	public boolean cercaAutore(String nome, String cognome) {
		boolean nonTrovato = true;
		Autore cerca = new Autore(nome, cognome);
		for(Autore a: listaAutori) {
			if(a.getNome().equalsIgnoreCase(cerca.getNome()) &&
			   a.getCognome().equalsIgnoreCase(cerca.getCognome())) {
				nonTrovato = false;
			} 
		}
		return nonTrovato;
	}
	
	public void cercaLibroDaTitolo(String titolo) {
		boolean nonTrovato = true;
		for(Libro l: listaLibri) {
			if(l.getTitolo().equalsIgnoreCase(titolo)) {
				nonTrovato = false;
				break;
			}
		}
		if(nonTrovato) {
			System.out.println("\nLibro non trovato.");
		} else {
			System.out.println("\nLibro trovato nella lista dei libri.");
		}
	}

	public void cercaLibroDaAutore(String nomeAut, String cognomeAut) {
		boolean nonTrovato = true;
		for(Libro l: listaLibri) {
			if(l.getAutore().getNome().equalsIgnoreCase(nomeAut) &&
			   l.getAutore().getCognome().equalsIgnoreCase(cognomeAut)) {
				nonTrovato = false;
				break;
			}
		}
		if(nonTrovato) {
			System.out.println("\nLibro non trovato.");
		} else {
			System.out.println("\nLibro trovato nella lista dei libri.");
		}
	}
	
	public void getLongest() {
		for(int i = 0; i < listaLibri.size(); i++) {
			if(listaLibri.get(i).getNumeroPagine() > lun) {
				lun = listaLibri.get(i).getNumeroPagine();
				index = i;
			} else {
				continue;
			}
		}
		System.out.println("Il libro più lungo è \"" + 
							listaLibri.get(index).getTitolo() + "\".");
	}
//	public Libro getLongest() {
//		for(int i = 0; i < listaLibri.size(); i++) {
//			if(listaLibri.get(i).getNumeroPagine() > lun) {
//				lun = listaLibri.get(i).getNumeroPagine();
//				index = i;
//			}
//		}
//		return listaLibri.get(index);
//	}
}
