package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_key")
public class ApiKey {

	@Id
	private String api_key;
	
	public ApiKey() {
		
	}
	
	public ApiKey(String aK) {
		this.api_key=aK;
	}
	
	public String getApiKey() {
		return api_key;
	}
	
	public void setApiKey(String aK) {
		this.api_key = aK;
	}
	
}
