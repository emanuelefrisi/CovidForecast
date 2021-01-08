package it.univpm.CovidForecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.service.ApiKeyService;

@RestController
public class ApiKeyController {

	@Autowired
	private ApiKeyService aKS;
	
	@GetMapping("/getApiKeys")
	public String getApiKeys(){
		
		return aKS.getApiKeyFromDB(0) + " " + aKS.getApiKeyFromDB(1);
		
	}
	
}
