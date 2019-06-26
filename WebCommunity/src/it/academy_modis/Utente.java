package it.academy_modis;

public class Utente {
	
	private String nickname;
	private String name;
	private String surname;
	private String mail;
	private String password;
	
	public Utente(String nickname, String name, String surname, String mail, String password) {
		super();
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
	}
	
	public Utente(String nickname, String name, String surname) {
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
	}

	protected String getNickname() {
		return nickname;
	}

	protected String getName() {
		return name;
	}

	protected String getSurname() {
		return surname;
	}

	protected String getMail() {
		return mail;
	}

	protected String getPassword() {
		return password;
	}
	
	
}
