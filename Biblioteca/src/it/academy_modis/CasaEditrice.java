package it.academy_modis;

/**
 * Classe per rappresentare
 * una casa editrice
 * 
 * @author Roberto Cella
 *
 */
public class CasaEditrice {
	private String nome;
	private String luogo;
	
	public CasaEditrice(String nome, String luogo) {
		super();
		this.nome = nome;
		this.luogo = luogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public String printCasa() {
		return this.nome + " a " + this.luogo;
	}
}
