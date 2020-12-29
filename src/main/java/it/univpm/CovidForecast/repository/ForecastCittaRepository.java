package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.ForecastCitta;

public interface ForecastCittaRepository extends JpaRepository<ForecastCitta, Long>{

}
