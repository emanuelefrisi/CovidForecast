package it.univpm.CovidForecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.stats.StatsPrevisionali;

@RestController
public class ControllerPrevisionale {

	@Autowired
	private StatsPrevisionali sP;;
	
	@PostMapping
	public void statsPrevisionali() {
		
	}
	
}
