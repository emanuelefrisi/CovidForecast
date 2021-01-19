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

/**
 * 
 * Controller la cui rotta restituisci un HashMap contenente le informazioni
 * riguardanti le statistiche previsionali richieste
 * 
 * @author emanuelefrisi
 *
 * @see it.univpm.CovidForecast.filters.FilterCity
 * @see it.univpm.CovidForecast.stats.StatsPrevisionali
 *
 */
@RestController
public class ForecastController {

	private StatsPrevisionali sP = new StatsPrevisionali();
	@Autowired
	private FilterCity filtroC = new FilterCity();
	/**
	 * Vettore in cui vengono aggiunti oggetti MeteoCitta filtrati per città
	 */
	private Vector<MeteoCitta> vettCitta;
	/**
	 * Vettore in cui vengono aggiunti oggetti ForecastCitta filtrati per città
	 */
	private Vector<ForecastCitta> vettForecastCitta;
	/**
	 * Oggetto CittaScanner utile per controllare se la città data in input è
	 * presente tra quelle disponibili
	 */
	//private CittaScanner cS = new CittaScanner();

	/**
	 * 
	 * Metodo che restituisce un HashMap inizializzato dal metodo creaStat della classe StatsPrevisionali.
	 * Prende in ingresso un HashMap che deve necessariamente contenere una città ed una soglia di errore
	 * 
	 * @param map
	 * @return HashMap creato dal metodo creaStat della classe StatsPrevisionali 
	 * @see it.univpm.CovidForecast.stats.StatsPrevisionali.creaStat
	 * 
	 */
	@PostMapping("forecastStats")
	public HashMap<String, String> forecastStats(@RequestBody HashMap<String, String> map) {
		vettCitta = new Vector<MeteoCitta>();
		vettForecastCitta = new Vector<ForecastCitta>();
		
		//if(!cS.controlloCitta())
		vettCitta = filtroC.getFromCityFilter(map.get("citta"));
		vettForecastCitta = filtroC.getFromCityFilterForecast(map.get("citta"));
		return sP.creaStat(vettCitta, vettForecastCitta, map.get("citta"), Math.abs(Integer.valueOf(map.get("errore"))));
	}

}
