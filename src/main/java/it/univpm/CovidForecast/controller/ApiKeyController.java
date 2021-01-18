package it.univpm.CovidForecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.service.ApiKeyService;

/**
 * Classe contenente il controller dell'applicazione che gestisce le rotte delle
 * ApiKeys
 * 
 * @author emanuelefrisi
 *
 */
@RestController
public class ApiKeyController {

	/**
	 * Oggetto ApiKeyService utile per ottenere oggetti ApiKey dal DB
	 */
	@Autowired
	private ApiKeyService aKS;

	/**
	 * Metodo che ritorna una Stringa con i primi due elementi della Lista di ApiKeys
	 * 
	 * @see it.univpm.CovidForecast.service.ApiKeyService.getApiKeyFromDB
	 * @return String
	 */
	@GetMapping("/getApiKeys")
	public String getApiKeys() {

		return aKS.getApiKeyFromDB(0) + " " + aKS.getApiKeyFromDB(1);

	}

}
