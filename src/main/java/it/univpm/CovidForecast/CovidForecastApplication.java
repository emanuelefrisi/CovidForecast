package it.univpm.CovidForecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidForecastApplication.class, args);
	}

}
