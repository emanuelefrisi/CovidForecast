package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.Utente;

/**
 * 
 * Interfaccia che estende JpaRepository, che contiene i metodi utili per lavorare con il database.
 * I dati salvati sul database attingono dagli attributi degli oggetti Utente
 * 
 * @author emanuelefrisi
 *
 */
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
