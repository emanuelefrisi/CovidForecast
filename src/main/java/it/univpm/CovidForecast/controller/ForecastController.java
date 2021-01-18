package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("forecastStats")
	public void forecastStats(@RequestParam(value="citta") String citta) {
		vettCitta = new Vector<MeteoCitta>();
		vettForecastCitta = new Vector<ForecastCitta>();
		vettCitta = filtroC.getFromCityFilter(citta);
		vettForecastCitta = filtroC.getFromCityFilterForecast(citta);
		sP.creaStat(vettCitta, vettForecastCitta);
	}
	
}
