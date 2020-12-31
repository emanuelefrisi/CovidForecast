package it.univpm.CovidForecast.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.CovidForecast.api.OpenWeatherData;

@Component
public class Scheduler {

	@Autowired
	private OpenWeatherData oWD = new OpenWeatherData();
	
	@Scheduled(fixedRate=3600000)
	public void scheduler() {
		oWD.getData("weather");
		oWD.getData("forecast");
	}
	
}
