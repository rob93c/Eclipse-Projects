package it.testSpring.controller;

import java.util.List;

import it.testSpring.model.UtenteVo;

public class Controller {
	
	public void stampaLista(List<UtenteVo> listaUtenti) {

		listaUtenti.forEach((UtenteVo u) -> 
			System.out.println(u.getNome() + "\t" + u.getCognome() + "\t" + u.getMail() + "\n"));
	}
}
