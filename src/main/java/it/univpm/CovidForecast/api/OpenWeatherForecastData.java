package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.parsing.ParsingForecastData;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.service.ApiKeyService;

/**
 * 
 * Classe che esegue la chiamata all'API di OpenWeather riguardante i dati
 * previsionali di una città
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class OpenWeatherForecastData {

	private CittaScanner cS = new CittaScanner();
	@Autowired
	ParsingForecastData parsingFD = new ParsingForecastData();
	@Autowired
	private ApiKeyService aK = new ApiKeyService();
	private Vector<String> citta;
	private String apiKey;
	
	public void getForecastData() {
		
		citta = cS.getCitta();
		apiKey = aK.getApiKeyFromDB();
		BufferedReader input;
		Vector<String> cittaForecastData = new Vector<String>();
		try {
			for(String c : citta) {
				String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + c
						+ "&appid=" + apiKey + "&units=metric&lang=it";
				URL apiUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
				input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String s;
				while((s = input.readLine()) != null) {
				cittaForecastData.add(s);
				}
			}
			parsingFD.parsing(cittaForecastData);
		}catch (MalformedURLException m) {
			// eccezione da scrivere
		} catch (IOException i) {
			// eccezione da scrivere
		}
	}
}
