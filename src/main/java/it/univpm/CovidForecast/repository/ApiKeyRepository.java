package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.ApiKey;

/**
 * 
 * Interfaccia che estende JpaRepository, che contiene i metodi utili per lavorare con il database.
 * I dati salvati sul database attingono dagli attributi degli oggetti ApiKey
 * 
 * @author emanuelefrisi
 *
 */
public interface ApiKeyRepository extends JpaRepository<ApiKey, String>{

}
