package com.yoox.hieracy.model;

import java.util.Date;

public class Application {

	public static void main(String[] args) {
		
		int counter = CounterUtils.increment(0);
		
		int id = counter++;
		System.out.println("Counter: " + counter);
		System.out.println("ID: " + id);
		
		Partecipante p = new Docente();
		
		Partecipante part = new Studente(1L, "Mario", "Rossi", "mrossi@me.com", new Date(), 5, "AF2142");
		Partecipante doc = new Docente(1L, "Mario", "Rossi", "mrossi@me.com", new Date(), 500000, "214121");
		
		Partecipante[] partecipanti = new Partecipante[3];
		
		// Gli elementi sono dello stesso tipo della classe padre
		partecipanti[0] = p;
		partecipanti[1] = part;
		partecipanti[2] = doc;
		
		@SuppressWarnings("unused")
		double tot = 0;
		for(Partecipante par: partecipanti) {
			tot += par.calcolaCompensoGiornaliero() * 20;
		}
		for(Partecipante par: partecipanti) {
			stampaPartecipante(par);
		}
		
		Date now = new Date();
		System.out.println("Data corrente: " + CounterUtils.fromDateToString(now));
	}
	
	
	
	public static void stampaPartecipante(Partecipante p) {
		System.out.println(p);
	}
}
