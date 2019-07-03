package com.yoox.hieracy.model;

import java.util.Date;

public abstract class Partecipante {
	
	private static Long counter = 0L;
	
	static {
		
	}
	
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	private double compensoGiornaliero;
	
	public Partecipante(Long id, String nome, String cognome, String email, Date dataNascita,
			double compensoGiornaliero) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.compensoGiornaliero = compensoGiornaliero;
	}

	public Partecipante() {
		
	}
	
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getCognome() {
		return cognome;
	}
	protected void setCognome(String cognome) {
		this.cognome = cognome;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected Date getDataNascita() {
		return dataNascita;
	}
	protected void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	protected double getCompensoGiornaliero() {
		return compensoGiornaliero;
	}

	protected void setCompensoGiornaliero(double compensoGiornaliero) {
		this.compensoGiornaliero = compensoGiornaliero;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Partecipante)) {
			return false;
		}
		Partecipante p = (Partecipante) obj;
		
		return p.getId().equals(this.id);
	}
	
	public abstract double calcolaCompensoGiornaliero();

	@Override
	public String toString() {
		return "Partecipante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", dataNascita=" + dataNascita + ", compensoGiornaliero=" + compensoGiornaliero + "]";
	}
	
	
}
