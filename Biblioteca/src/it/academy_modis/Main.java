package it.academy_modis;

public class Main {

	public static void main(String[] args) {
		
		CasaEditrice casa1 = new CasaEditrice("Feltrinelli", "Roma");
		CasaEditrice casa2 = new CasaEditrice("Beccogiallo", "Padova");
		
		Autore aut1 = new Autore("Stephen", "King", "americana");
		Autore aut2 = new Autore("Umberto", "Eco", "italiana");
		
		Libro lib1 = new Libro("Under the dome", aut1, casa1);
		Libro lib2 = new Libro("Il nome della rosa", aut2, casa2);
		
		Libro[] arrayLibri = new Libro[2];
		arrayLibri[0] = lib1;
		arrayLibri[1] = lib2;
		
		for(int i = 0; i < arrayLibri.length; i++) {
			Libro lib = arrayLibri[i];
			String tit = lib.getTitolo();
			Autore aut = lib.getAutore();
			CasaEditrice casa = lib.getCasaEditrice();
			
			System.out.println("Il libro \"" + tit + "\" è stato scritto da " + aut.printAutore() +
					" e pubblicato da " + casa.printCasa() + ".\n");
		}
		
	}

}
