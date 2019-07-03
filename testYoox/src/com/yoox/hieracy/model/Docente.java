package com.yoox.hieracy.model;

import java.util.Date;

public class Docente extends Partecipante {
	
	private String piva;

	public Docente(Long id, String nome, String cognome, String email, Date dataNascita, double compensoGiornaliero, String piva) {
		super(id, nome, cognome, email, dataNascita, compensoGiornaliero);
		this.piva = piva;
	}
	
	public Docente() {
	}
	
	protected String getPiva() {
		return piva;
	}

	protected void setPiva(String piva) {
		this.piva = piva;
	}
	
	@Override
	public double calcolaCompensoGiornaliero() {
		return this.getCompensoGiornaliero() * 1.22;
	}

	@Override
	public String toString() {
		return super.toString() + " ed in più sono un docente [piva=" + piva + "]";
	}
	
	
}
