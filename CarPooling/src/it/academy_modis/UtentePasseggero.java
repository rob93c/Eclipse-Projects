package it.academy_modis;

public class UtentePasseggero {
	
	private String nome;
	private String cognome;
	private String documento;
	private String telefono;
	private String mail;
	
	public UtentePasseggero(String nome, String cognome, String documento, String telefono, String mail) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.documento = documento;
		this.telefono = telefono;
		this.mail = mail;
	}

	public UtentePasseggero(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	protected String getNome() {
		return nome;
	}

	protected String getCognome() {
		return cognome;
	}

	protected String getDocumento() {
		return documento;
	}

	protected String getTelefono() {
		return telefono;
	}

	protected String getMail() {
		return mail;
	}

	public void printPasseggero() {
		System.out.println("Passeggero " + this.nome + " " + this.cognome);
		
	}
	
	
}
