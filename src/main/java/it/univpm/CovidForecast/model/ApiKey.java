package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Classe utile per prelevare le api key dal database
 * 
 * @author emanuelefrisi
 *
 */
@Entity
@Table(name = "api_key")
public class ApiKey {

	/**
	 * Variabile che immagazina la api key desiderata
	 */
	@Id
	private String api_key;
	
	/**
	 * Costruttore vuoto
	 */
	public ApiKey() {
		
	}
	
	/**
	 * Costruttore per creare un oggetto con dentro solo l'api key
	 * 
	 * @param aK
	 */
	public ApiKey(String aK) {
		this.api_key=aK;
	}
	
	/**
	 * Metodo getter dell'attributo api_key
	 * 
	 * @return api_key
	 */
	public String getApiKey() {
		return api_key;
	}
	
	/**
	 * Metodo setter dell'attributo api_key
	 * 
	 * @param aK
	 */
	public void setApiKey(String aK) {
		this.api_key = aK;
	}
	
}
