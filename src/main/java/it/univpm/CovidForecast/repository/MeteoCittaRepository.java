package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * 
 * Interfaccia che estende JpaRepository, che contiene i metodi utili per lavorare con il database.
 * I dati salvati sul database attingono dagli attributi degli oggetti MeteoCitta
 * 
 * @author emanuelefrisi
 *
 */
public interface MeteoCittaRepository extends JpaRepository<MeteoCitta, Integer>{
	
}
