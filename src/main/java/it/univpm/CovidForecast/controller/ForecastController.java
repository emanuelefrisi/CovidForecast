package it.univpm.CovidForecast.controller;

import java.util.HashMap;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.stats.StatsPrevisionali;

@RestController
public class ForecastController {

	private StatsPrevisionali sP = new StatsPrevisionali();
	@Autowired
	private FilterCity filtroC = new FilterCity();
	private Vector<MeteoCitta> vettCitta;
	private Vector<ForecastCitta> vettForecastCitta;
	
	@PostMapping("forecastStats")
	public HashMap<String, String> forecastStats(@RequestBody HashMap<String, String> map) {
		vettCitta = new Vector<MeteoCitta>();
		vettForecastCitta = new Vector<ForecastCitta>();
		vettCitta = filtroC.getFromCityFilter(map.get("citta"));
		vettForecastCitta = filtroC.getFromCityFilterForecast(map.get("citta"));
		return sP.creaStat(vettCitta, vettForecastCitta, map.get("citta"), Integer.valueOf(map.get("errore")));
	}
	
}
