package it.academy_modis;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	 	
		boolean cicla = true;
		Scanner scanner = new Scanner(System.in);
		DatabaseManager db = new DatabaseManager();
		ArrayList<UtenteAutista> listaAutisti = new ArrayList<UtenteAutista>();
		ArrayList<Viaggio> listaViaggi = new ArrayList<Viaggio>();
		ArrayList<UtentePasseggero> listaPasseggeri = new ArrayList<UtentePasseggero>();
		CreaResoconto cr = new CreaResoconto();
		cr.creaDirectory("prenotazioni");
		
		while(cicla) {
			System.out.println("\nScegli un'opzione:" +
								"\n1) Registra un nuovo utente" +
								"\n2) Mostra gli autisti che offrono un determinato viaggio e prenota" +
								"\n3) Stampa i dati relativi al viaggio" +
								"\n4) Mostra gli utenti con un voto medio superiore a un tot" +
								"\n0) Esci dal programma");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Come vuoi registrarti?\n1) Come passeggero\n2) Come autista");
				int selezione = scanner.nextInt();
				if(selezione == 2) {
					scanner.nextLine();
					System.out.print("Inserisci il nome: ");
					String nome = scanner.nextLine();
					System.out.print("Inserisci il cognome: ");
					String cognome = scanner.nextLine();
					System.out.print("Inserisci il numero della patente: ");
					String patente = scanner.nextLine();
					System.out.print("Inserisci la data di scadenza della patente (DD/MM/YYYY): ");
					String scadenza = scanner.nextLine();
					System.out.print("Inserisci la targa della tua auto: ");
					String targa = scanner.nextLine();
					System.out.print("Inserisci il numero di telefono: ");
					String telefono = scanner.nextLine();
					System.out.print("Inserisci l'indirizzo mail: ");
					String mail = scanner.nextLine();
					db.registrazioneUtente(nome, cognome, patente, scadenza, targa, telefono, mail);
				} else {
					scanner.nextLine();
					System.out.print("Inserisci il nome: ");
					String nome = scanner.nextLine();
					System.out.print("Inserisci il cognome: ");
					String cognome = scanner.nextLine();
					System.out.print("Inserisci il numero del tuo documento: ");
					String documento = scanner.nextLine();
					System.out.print("Inserisci il numero di telefono: ");
					String telefono = scanner.nextLine();
					System.out.print("Inserisci l'indirizzo mail: ");
					String mail = scanner.nextLine();
					db.registrazioneUtente(nome, cognome, documento, telefono, mail);
				}
				break;
			case 2:
				System.out.print("Inserisci la città di partenza: ");
				String partenza = scanner.nextLine();
				System.out.print("Inserisci la città di arrivo: ");
				String arrivo = scanner.nextLine();
				System.out.print("Inserisci la data in cui vuoi viaggiare: ");
				String data = scanner.nextLine();
				listaViaggi = db.getViaggi(partenza, arrivo, data);
				listaAutisti = db.getAutistaFromViaggio(listaViaggi);
				for(int i = 0; i < listaAutisti.size(); i++) {
					listaAutisti.get(i).printAutista();
					listaViaggi.get(i).printViaggio();
				}
				if(listaViaggi.size() > 0) {
					System.out.println("Vuoi effettuare una prenotazione? (Premi 1 se vuoi prenotare)");
					if(scanner.nextInt() == 1) {
						scanner.nextLine();
						System.out.print("Inserisci la tua mail: ");
						String mail = scanner.nextLine();
						System.out.print("Inserisci l'ID del viaggio che hai scelto: ");
						int id_viaggio = scanner.nextInt();
						System.out.println(db.prenota(mail, id_viaggio));
						scanner.nextLine();
						System.out.println("Inserisci il tuo codice prenotazione: ");
						String uuid = scanner.nextLine();
						String file = "prenotazioni" + File.separator + uuid + ".txt ";
						cr.creaFile(file);
						for(Viaggio v: listaViaggi) {
							if(v.getId_viaggio() == id_viaggio) {
								String testo = v.printViaggio();
								cr.fileWriter(file, testo);
							}
						}
					}
					
				}
				break;
			case 3:
				System.out.println("Inserisci il tuo codice prenotazione: ");
				String uuid = scanner.nextLine();
				Viaggio viaggio = db.getViaggio(uuid);
				viaggio.printViaggio();
				break;
			case 4:
				System.out.print("Inserisci la mail: ");
				String mail = scanner.nextLine();
				System.out.print("Inserisci l'ID del viaggio che hai scelto: ");
				int id_viaggio = scanner.nextInt();
				System.out.print("Scegli il voto minimo da visualizzare: ");
				double voto_minimo = scanner.nextInt();
				db.getPasseggeri(mail, id_viaggio, voto_minimo);
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
