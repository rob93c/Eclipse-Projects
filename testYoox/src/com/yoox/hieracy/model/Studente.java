package com.yoox.hieracy.model;

import java.util.Date;

public class Studente extends Partecipante {
	
	private String matricola;

	public Studente() {
	}

	public Studente(Long id, String nome, String cognome, String email, Date dataNascita, double compensoGiornaliero, String matricola) {
		super(id, nome, cognome, email, dataNascita, compensoGiornaliero);
		this.matricola = matricola;
	}

	protected String getMatricola() {
		return matricola;
	}

	protected void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public double calcolaCompensoGiornaliero() {
		return getCompensoGiornaliero();
	}

	@Override
	public String toString() {
		return super.toString() + " ed in più sono uno studente [matricola=" + matricola + "]";
	}

	
	
	
}
