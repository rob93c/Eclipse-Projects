package it.academy_modis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean cicla = true;
		Scanner scanner = new Scanner(System.in);
		
		DatabaseManager db = new DatabaseManager();
		
		ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
		
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
				System.out.println("\nL'utente " + nickname + " è stato registrato con successo.\n");
				break;
			case 2:
				listaUtenti = db.getAllUtenti();
				db.printLista(listaUtenti);
				break;
			case 3:
				System.out.print("Inserisci il nickname: ");
				nickname = scanner.nextLine();
				System.out.print("Inserisci la password: ");
				password = scanner.nextLine();
//				System.out.println(db.login(nickname, password));
				
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
