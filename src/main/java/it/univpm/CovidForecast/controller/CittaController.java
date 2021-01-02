package it.univpm.CovidForecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.repository.ForecastCittaRepository;
import it.univpm.CovidForecast.repository.MeteoCittaRepository;

@RestController
public class CittaController {

	@Autowired
	private MeteoCittaRepository mCR;
	@Autowired
	private ForecastCittaRepository fCR;
	
	@GetMapping("/getMeteoCitta")
	public List<MeteoCitta> getMeteoCitta(){
		return mCR.findAll(); 
	}
	
	@GetMapping("/getForecastCitta")
	public List<ForecastCitta> getForecastCitta(){
		return fCR.findAll();
	}
	
}
