package it.univpm.CovidForecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.service.UtenteService;

@RestController
public class UtenteController {

	@Autowired
	private UtenteService uS;
	
	@GetMapping("/salva")
	public boolean salva(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		return uS.salva(username, password);
	}
	
	@GetMapping("/compara")
	public String compara(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		return uS.compara(username, password);
	}
	
}
