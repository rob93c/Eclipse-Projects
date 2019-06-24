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
								"\n0) Esci dal programma");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				listaImpiegati = db.getImpiegatiBySalDesc();
				db.printLista(listaImpiegati);
				break;
			case 2:
				listaImpiegati = db.getAllImpiegatiDiplomati();
				db.printLista(listaImpiegati);
				break;
			case 3:
				listaImpiegati = db.getAllImpiegatiLaureati();
				db.printLista(listaImpiegati);
				break;
			case 4:
				System.out.print("Inserisci il nome del dipartimento "
						+ "di cui vuoi sapere il responsabile: ");
				String dipartimento = scanner.nextLine();
				db.getResponsabile(dipartimento);
				break;
			case 0:
				cicla = false;
				break;
			}
		}
		scanner.close();
	}
}
