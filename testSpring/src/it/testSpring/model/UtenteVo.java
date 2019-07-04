package it.testSpring.model;

public class UtenteVo {
	
	private int idUtente;
	private String nickname;
	private String nome;
	private String cognome;
	private String mail;
	private String password;
	
	public UtenteVo(String nickname, String nome, String cognome, String mail) {
		super();
		this.nickname = nickname;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
	}
	
	public UtenteVo(int idUtente, String nickname, String nome, String cognome, String mail, String password) {
		super();
		this.idUtente = idUtente;
		this.nickname = nickname;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.password = password;
	}
	
	public int getidUtente() {
		return idUtente;
	}
	public void setidUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
