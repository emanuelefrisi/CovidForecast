package it.univpm.CovidForecast.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.CovidForecast.api.OpenWeatherCurrentData;

@Component
public class Scheduler {

	OpenWeatherCurrentData task = new OpenWeatherCurrentData();
	
	@Scheduled(fixedRate=60000)
	public void scheduler() {
		task.getCurrentData();
	}
	
}
