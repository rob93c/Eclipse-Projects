package it.academy_modis;

public class UtenteAutista {
	
	private int id_autista;
	private String nome;
	private String cognome;
	private String patente;
	private String scadenzaPatente;
	private String datiAuto;
	private String telefono;
	private String mail;
	
	public UtenteAutista(int id_autista, String nome, String cognome, String patente, String scadenzaPatente, String datiAuto,
			String telefono, String mail) {
		super();
		this.id_autista = id_autista;
		this.nome = nome;
		this.cognome = cognome;
		this.patente = patente;
		this.scadenzaPatente = scadenzaPatente;
		this.datiAuto = datiAuto;
		this.telefono = telefono;
		this.mail = mail;
	}

	protected String getNome() {
		return nome;
	}

	protected String getCognome() {
		return cognome;
	}

	protected String getPatente() {
		return patente;
	}

	protected String getScadenzaPatente() {
		return scadenzaPatente;
	}

	protected String getDatiAuto() {
		return datiAuto;
	}

	protected String getTelefono() {
		return telefono;
	}

	protected String getMail() {
		return mail;
	}

	public void printAutista() {
		System.out.println("L'autista è " + this.nome + " " + this.cognome +
				" con la macchina targata " + this.datiAuto);
	}

	protected int getId_autista() {
		return id_autista;
	}
	
	
}
