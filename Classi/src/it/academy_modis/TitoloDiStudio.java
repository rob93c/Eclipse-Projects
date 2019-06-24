package it.academy_modis;

public class TitoloDiStudio {
	
	private String nome;
	private String scuola;
	
	public TitoloDiStudio(String nome, String scuola) {
		super();
		this.nome = nome;
		this.scuola = scuola;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getScuola() {
		return scuola;
	}
	public void setScuola(String scuola) {
		this.scuola = scuola;
	}
	
	
}
