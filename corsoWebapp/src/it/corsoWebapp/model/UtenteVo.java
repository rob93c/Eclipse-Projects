package it.corsoWebapp.model;

public class UtenteVo {
	
	private Long id_utente;
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
	
	public UtenteVo(Long id_utente, String nickname, String nome, String cognome, String mail, String password) {
		super();
		this.id_utente = id_utente;
		this.nickname = nickname;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.password = password;
	}
	
	public Long getId_utente() {
		return id_utente;
	}
	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
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
