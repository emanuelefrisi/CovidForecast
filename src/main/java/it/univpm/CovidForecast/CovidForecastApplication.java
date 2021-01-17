package it.univpm.CovidForecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * Classe da cui tutto parte. Il tag @EnableScheduling si occupa di far partire la classe scheduler
 * 
 * @author emanuelefrisi&domenicolaporta00
 *
 * @see it.univpm.CovidForecast.scheduler.Scheduler
 *
 */

@SpringBootApplication
@EnableScheduling
public class CovidForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidForecastApplication.class, args);
	}

}