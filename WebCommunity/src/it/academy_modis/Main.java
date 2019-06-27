package it.academy_modis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean cicla = true;
		Scanner scanner = new Scanner(System.in);
		
		DatabaseManager db = new DatabaseManager();
		
		ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
		ArrayList<Evento> listaEventi = new ArrayList<Evento>();
		ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();
		
		while(cicla) {
			System.out.println("\nScegli un'opzione:" + 
								"\n1) Registra un nuovo utente" +
								"\n2) Stampa gli utenti registrati" +
								"\n3) Inserisci un evento" +
								"\n4) Inserisci un commento" +
								"\n5) Visualizza gli eventi in ordine cronologico" +
								"\n6) Visualizza voti e commenti relativi ad un evento" +
								"\n0) Esci dal programma");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Inserisci il nickname: ");
				String nickname = scanner.nextLine();
				System.out.print("Inserisci il nome: ");
				String name = scanner.nextLine();
				System.out.print("Inserisci il cognome: ");
				String surname = scanner.nextLine();
				System.out.print("Inserisci la mail: ");
				String mail = scanner.nextLine();
				System.out.print("Inserisci la password: ");
				String password = scanner.nextLine();
				db.insertUtente(nickname, name, surname, mail, password);
				System.out.println("\nL'utente " + nickname + " è	 stato registrato con successo.\n");
				break;
			case 2:
				listaUtenti = db.getAllUtenti();
				db.printListaUtenti(listaUtenti);
				break;
			case 3:
				System.out.print("Inserisci il nickname: ");
				nickname = scanner.nextLine();
				System.out.print("Inserisci la password: ");
				password = scanner.nextLine();
				if(db.login(nickname, password)) {
					System.out.println("\n | LOGIN EFFETTUATO |\n");
					System.out.println("Scegli la categoria dell'evento da aggiungere:");
					listaCategorie = db.getCategorie();
					db.printListaCategorie(listaCategorie);
					int id_categoria = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Inserisci il nome dell'evento: ");
					String nomeEvento = scanner.nextLine();
					System.out.print("Inserisci il luogo dell'evento: ");
					String luogo = scanner.nextLine();
					System.out.print("Inserisci la provincia dell'evento: ");
					String provincia = scanner.nextLine();
					System.out.print("Inserisci la data dell'evento (nel formato DD/MM/YYYY): ");
					String data = scanner.nextLine();
					db.insertEvento(id_categoria, nomeEvento, luogo, provincia, data);
					System.out.println("L'evento " + nomeEvento + " è stato inserito con successo.");
				}
				break;
			case 4:
				System.out.print("Inserisci il nickname: ");
				nickname = scanner.nextLine();
				System.out.print("Inserisci la password: ");
				password = scanner.nextLine();
				if(db.login(nickname, password)) {
					System.out.println("\n | LOGIN EFFETTUATO |\n");
					System.out.println("Inserisci il corpo della recensione: ");
					String testo = scanner.nextLine();
					System.out.print("Inserisci la valutazione (da 1 a 5): ");
					int voto = scanner.nextInt();
					System.out.print("Inserisci l'ID dell'evento da recensire: ");
					int id_evento = scanner.nextInt();
					int id_utente = db.getIDUtente(nickname, password);
					db.insertCommento(testo, voto, id_utente, id_evento);
					System.out.println("Recensione inserita con successo.");
				}
				break;
			case 5:
				System.out.println("Eventi ordinati per data:");
				listaEventi = db.getEventiOrdinati();
				db.printListaEventi(listaEventi);
				break;
			case 6:
				listaEventi = db.getEventiOrdinati();
				System.out.println("Inserisci l'ID dell'evento di cui vuoi vedere le recensioni: ");
				for(int i = 0; i < listaEventi.size(); i++) {
					System.out.println((i+1) + ") " + listaEventi.get(i));
				}
				int id_evento = scanner.nextInt();
				scanner.nextLine();
				db.getRecensione(id_evento);
				break;
			case 0:
				db.closeConnection();
				cicla = false;
				break;
			}
		}
		scanner.close();
	}
}
