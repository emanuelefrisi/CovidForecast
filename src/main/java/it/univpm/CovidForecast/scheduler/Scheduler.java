package it.univpm.CovidForecast.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.CovidForecast.api.OpenWeatherData;

/**
 * Classe che e' servita per salvare i dati attuali e previsionali di ogni città sul database
 * 
 * @author emanuelefrisi
 *
 * @see it.univpm.CovidForecast.api.OpenWeatherData
 *
 */

@Component
public class Scheduler {

	@Autowired
	private OpenWeatherData oWD = new OpenWeatherData();
	
	/**
	 * 
	 * Metodo che consente di salvare i dati sul database ogni ora
	 * 
	 */
	@Scheduled(fixedRate=3600000)
	public void scheduler() {
//		oWD.getData("weather");
//		oWD.getData("forecast");
	}
	
}
