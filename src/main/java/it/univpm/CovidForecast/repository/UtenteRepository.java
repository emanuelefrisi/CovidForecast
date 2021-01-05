package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
