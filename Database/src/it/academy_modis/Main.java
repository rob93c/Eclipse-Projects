package it.academy_modis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean cicla = true;
		Scanner scanner = new Scanner(System.in);
		
		DatabaseManager db = new DatabaseManager();
		
		ArrayList<Impiegati> listaImpiegati = new ArrayList<Impiegati>();
		
		while(cicla) {
			System.out.println("\nScegli un'opzione:" + 
								"\n1) Tutti gli impiegati in ordine di salario decrescente" +
								"\n2) Tutti gli impiegati con il diploma" +
								"\n3) Tutti gli impiegati con la laurea" +
								"\n4) Il responsabile del dipartimento" +
								"\n5) Inserire un dipartimento" +
								"\n6) Aggiungere un impiegato ad un dipartimento" +
								"\n7) Togliere un impiegato da un dipartimento" +
								"\n8) Modificare il salario ad un impiegato" +
								"\n0) Esci dal programma");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Impiegati in ordine decrescente di salario:");
				listaImpiegati = db.getImpiegatiBySalDesc();
				db.printLista(listaImpiegati);
				break;
			case 2:
				System.out.println("Impiegati con il diploma");
				listaImpiegati = db.getAllImpiegatiDiplomati();
				db.printLista(listaImpiegati);
				break;
			case 3:
				System.out.println("Impiegati con la laurea:");
				listaImpiegati = db.getAllImpiegatiLaureati();
				db.printLista(listaImpiegati);
				break;
			case 4:
				System.out.print("Inserisci il nome del dipartimento "
						+ "di cui vuoi sapere il responsabile: ");
				String dipartimento = scanner.nextLine().toUpperCase();
				db.getResponsabile(dipartimento);
				break;
			case 5:
				System.out.println("Inserisci il nome del dipartimento da creare:");
				dipartimento = scanner.nextLine().toUpperCase();
				db.insertDipartimento(dipartimento);
				System.out.println("\nIl " + dipartimento.toLowerCase() + 
						" è stato aggiunto ai dipartimenti.\n");
				break;
			case 6:
				System.out.println("Inserisci il cognome dell'impiegato da cercare: ");
				String cognome = scanner.nextLine();
				String ide = db.isImpiegato(cognome);
				if(!ide.isEmpty()) {
					System.out.println("Inserisci la descrizione del dipartimento: ");
					String descrizione = scanner.nextLine().toUpperCase();
					String dip = db.isDipartimento(descrizione);
					if(!dip.isEmpty()) {
						db.addImpiegatoToDipartimento(dip, ide);
					}
				}
				System.out.println("L'impiegato è stato assegnato al dipartimento.");
				break;
			case 7:
				System.out.println("Inserisci il cognome dell'impiegato da cercare: ");
				cognome = scanner.nextLine();
				ide = db.isImpiegato(cognome);
				if(!ide.isEmpty()) {
					System.out.println("Inserisci la descrizione del dipartimento: ");
					String descrizione = scanner.nextLine().toUpperCase();
					String dip = db.isDipartimento(descrizione);
					if(!dip.isEmpty()) {
						db.deleteImpiegatoFromDipartimento(dip, ide);
					}
				}
				System.out.println("L'impiegato è stato rimosso dal dipartimento.");
				break;
			case 8:
				System.out.print("Inserisci il cognome dell'impiegato da cercare: ");
				cognome = scanner.nextLine();
				ide = db.isImpiegato(cognome);
				System.out.print("Inserisci il nuovo salario: ");
				int sal = scanner.nextInt();
				db.updateSalario(sal, ide);
				System.out.println("\nIl salario è stato modificato con successo.\n");
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
