package it.testSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.testSpring.model.UtenteDao;
import it.testSpring.model.UtenteVo;

@Service(value="controller")
@Scope(value="prototype")
public class Controller {
	
	@Autowired(required=true)
	private UtenteDao udao;
	
	public void stampaUtente(UtenteVo u) {
		System.out.println(u.getNome() + "\t" + u.getCognome() + "\t" + u.getMail() + "\n");
	}
	
	public void stampaLista() {
		List<UtenteVo> listaUtenti = new ArrayList<UtenteVo>();
		listaUtenti = udao.getAllUsers();
		listaUtenti.forEach((UtenteVo u) -> stampaUtente(u));
	}
}
