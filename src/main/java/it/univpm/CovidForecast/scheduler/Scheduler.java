package it.univpm.CovidForecast.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.CovidForecast.api.OpenWeatherCurrentData;

@Component
public class Scheduler {

	@Autowired
	OpenWeatherCurrentData task = new OpenWeatherCurrentData();
	
	@Scheduled(fixedRate=60000)
	public void scheduler() {
		task.getCurrentData();
	}
	
}
