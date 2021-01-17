package it.univpm.CovidForecast.api;

import java.util.Vector;

import it.univpm.CovidForecast.exceptions.CFException;

public class ChiamataMeteo {

	private ApiKeyData aKD = new ApiKeyData();
	private OpenWeatherCurrentData oWCD = new OpenWeatherCurrentData();
	private OpenWeatherForecastData oWFD = new OpenWeatherForecastData();
	
	private String apiKey = new String();
	
	private Vector<Vector<String>> infoIcone = new Vector<Vector<String>>();
	
	public Vector<Vector<String>> chiamata(String citta) throws CFException{
		
//		apiKey = aKD.getApiKeys().elementAt(0);
		
		apiKey = "6f02b4af6340b065f7602022c775c531";

			infoIcone.add(oWCD.getData(citta, apiKey));
			infoIcone.addAll(oWFD.getData(citta, apiKey));
		
		return infoIcone;
		
	}
	
}
