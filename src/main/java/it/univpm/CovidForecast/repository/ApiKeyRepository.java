package it.univpm.CovidForecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univpm.CovidForecast.model.ApiKey;

public interface ApiKeyRepository extends JpaRepository<ApiKey, String>{

}
