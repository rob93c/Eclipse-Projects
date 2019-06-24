package it.academy_modis;


import java.util.Scanner;

/**
 * Classe principale per
 * gestire una biblioteca
 * 
 * @author Roberto Cella
 *
 */
public class BibliotecaApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opzione;
		Biblioteca biblioteca = new Biblioteca();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n-----------------------------"
							 + "\nSeleziona un'opzione:\n"
							 + "1) Aggiungi autore\n"
							 + "2) Stampa lista autori\n"
							 + "3) Stampa numero totale autori\n"
							 + "4) Cerca un autore\n"
							 + "5) Aggiungi un libro\n"
							 + "6) Cerca un libro per titolo\n"
							 + "7) Cerca un libro per autore\n"
							 + "8) Cerca un libro più mattone\n"
							 + "9) Stampa lista di libri\n"
							 + "0) Esci dal programma\n"
							 + "-----------------------------\n");
			opzione = scanner.nextInt();
			scanner.nextLine();
			
			String nome;
			String cognome;
			switch(opzione) {
			case 1:
				System.out.print("Inserisci il nome dell'autore: ");
				String nomeAutore = scanner.nextLine();
				System.out.print("Inserisci il cognome dell'autore: ");
				String cognomeAutore = scanner.nextLine();
				biblioteca.aggiungiAutore(nomeAutore, cognomeAutore);
				break;
			case 2:
				biblioteca.stampaAutori();
				break;
			case 3:
				biblioteca.totAutori();
				break;
			case 4:
				System.out.print("Inserisci il nome dell'autore da cercare: ");
				nome = scanner.nextLine();
				System.out.print("Inserisci il cognome dell'autore da cercare: ");
				cognome = scanner.nextLine();
				if(!biblioteca.cercaAutore(nome, cognome)) {
					System.out.println("\nAutore non trovato.");
				} else {
					System.out.println("\nAutore trovato nella lista degli autori.");
				}
				break;
			case 5:
				System.out.print("Inserisci il nome del libro da aggiungere: ");
				String nomeLibro = scanner.nextLine();
				System.out.print("Inserisci il nome dell'autore del libro: ");
				String nomeAutoreLibro = scanner.nextLine();
				System.out.print("Inserisci il cognome dell'autore del libro: ");
				String cognomeAutoreLibro = scanner.nextLine();
				System.out.print("Inserisci il numero di pagine del libro: ");
				int numeroPagineLibro = scanner.nextInt();
				biblioteca.aggiungiLibro(nomeLibro, nomeAutoreLibro, 
										cognomeAutoreLibro, numeroPagineLibro);
				break;
			case 6:
				System.out.print("Inserisci il titolo del libro da cercare: ");
				String titolo = scanner.nextLine();
				biblioteca.cercaLibroDaTitolo(titolo);
				break;
			case 7:
				System.out.print("Inserisci il nome dell'autore il cui libro devi cercare: ");
				String nomeAut = scanner.nextLine();
				System.out.print("Inserisci il cognome dell'autore il cui libro devi cercare: ");
				String cognomeAut = scanner.nextLine();
				biblioteca.cercaLibroDaAutore(nomeAut, cognomeAut);
				break;
			case 8:
				biblioteca.getLongest();
				break;
			case 9:
				biblioteca.stampaLibri();
				break;
			case 0:
				exit = true;
				break;
			}	
		}
		
		scanner.close();
		
		System.out.println("Programma terminato.");
	
	}

}
