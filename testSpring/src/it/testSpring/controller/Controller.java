package it.testSpring.controller;

import java.util.ArrayList;
import java.util.List;

import it.testSpring.model.UtenteDao;
import it.testSpring.model.UtenteVo;

public class Controller {
	
	private UtenteDao udao;
	
	public void setUdao(UtenteDao udao) {
		this.udao = udao;
	}

	public void stampaUtente(UtenteVo u) {
		System.out.println(u.getNome() + "\t" + u.getCognome() + "\t" + u.getMail() + "\n");
	}
	
	public void stampaLista() {
		List<UtenteVo> listaUtenti = new ArrayList<UtenteVo>();
		listaUtenti = udao.getAllUsers();
		listaUtenti.forEach((UtenteVo u) -> stampaUtente(u));
	}
}
