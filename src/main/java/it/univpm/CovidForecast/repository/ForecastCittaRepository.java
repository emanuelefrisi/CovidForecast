package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.ForecastCitta;

/**
 * 
 * Interfaccia che estende JpaRepository, che contiene i metodi utili per lavorare con il database.
 * I dati salvati sul database attingono dagli attributi degli oggetti ForecastCitta
 * 
 * @author emanuelefrisi
 *
 */
public interface ForecastCittaRepository extends JpaRepository<ForecastCitta, Long>{

}
