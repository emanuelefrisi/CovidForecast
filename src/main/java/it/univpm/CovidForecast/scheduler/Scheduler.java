package it.univpm.CovidForecast.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.CovidForecast.api.OpenWeatherCurrentData;
import it.univpm.CovidForecast.api.OpenWeatherForecastData;

@Component
public class Scheduler {

	@Autowired
	OpenWeatherCurrentData oWCD = new OpenWeatherCurrentData();
	@Autowired
	OpenWeatherForecastData oWFD = new OpenWeatherForecastData();
	
	@Scheduled(fixedRate=3600000)
	public void scheduler() {
		oWCD.getCurrentData();
		oWFD.getForecastData();
	}
	
}
