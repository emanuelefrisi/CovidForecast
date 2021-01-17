package it.univpm.CovidForecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.service.UtenteService;

/**
 * Classe contenente il controller dell'applicazione che gestisce le rotte di
 * dati degli utenti
 * 
 * @author
 *
 */
@RestController
public class UtenteController {

	/**
	 * Oggetto UtenteService utile per salvare o comparare oggetti Utente
	 */
	@Autowired
	private UtenteService uS;

	/**
	 * Metodo che salva l'username e la password dati in input sul DB
	 * 
	 * @see it.univpm.CovidForecast.service.UtenteService.salva
	 * @param username
	 * @param password
	 * @return boolean
	 */
	@GetMapping("/salva")
	public boolean salva(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		return uS.salva(username, password);
	}

	/**
	 * Metodo che compara l'username e la password dati in input con quelli presenti
	 * sul DB
	 * 
	 * @see it.univpm.CovidForecast.service.UtenteService.compara
	 * @param username
	 * @param password
	 * @return
	 */
	@GetMapping("/compara")
	public String compara(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		return uS.compara(username, password);
	}

}
