package it.academy_modis;

public class Foto {
	
	private String titolo;
	private Amico amico;
	
	public Foto(String titolo) {
		super();
		this.titolo = titolo;
	}

	public Foto(String titolo, Amico amico) {
		super();
		this.titolo = titolo;
		this.amico = amico;
	}

	protected String getTitolo() {
		return titolo;
	}

	protected void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	protected Amico getAmico() {
		return amico;
	}

	protected void setAmico(Amico amico) {
		this.amico = amico;
	}
	
	
}
