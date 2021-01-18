package it.univpm.CovidForecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.repository.ForecastCittaRepository;
import it.univpm.CovidForecast.repository.MeteoCittaRepository;

/**
 * Classe contenente il controller dell'applicazione che gestisce le rotte degli
 * oggetti MeteoCitta
 * 
 * @author emanuelefrisi
 *
 */
@RestController
public class CittaController {

	@Autowired
	/**
	 * Oggetto MeteoCittaRepository utile per ottenere Liste di MeteoCitta dal DB
	 */
	private MeteoCittaRepository mCR;
	@Autowired
	/**
	 * Oggetto ForecastCittaRepository utile per ottenere Liste di ForecastCitta dal DB
	 */
	private ForecastCittaRepository fCR;

	/**
	 * Metodo che ritorna una Lista di MeteoCitta, presa dal DB
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository.findAll()
	 * @return List<MeteoCitta>
	 */
	@GetMapping("/getMeteoCitta")
	public List<MeteoCitta> getMeteoCitta() {
		return mCR.findAll();
	}

	/**
	 * Metodo che ritorna una Lista di ForecastCitta, presa dal DB
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository.findAll()
	 * @return List<MeteoCitta>
	 */
	@GetMapping("/getForecastCitta")
	public List<ForecastCitta> getForecastCitta() {
		return fCR.findAll();
	}

}
