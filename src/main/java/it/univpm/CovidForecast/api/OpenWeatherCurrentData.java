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

import it.univpm.CovidForecast.parsing.ParsingCurrentData;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.service.ApiKeyService;

/**
 * 
 * Classe che esegue la chiamata all'API di OpenWeather riguardante i dati
 * attuali di una città
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class OpenWeatherCurrentData {

	private CittaScanner cS = new CittaScanner();
	@Autowired
	private ParsingCurrentData parsingCD = new ParsingCurrentData();
	@Autowired
	private ApiKeyService aK = new ApiKeyService();
	private Vector<String> citta;
	private String apiKey;

	public void getCurrentData() {

		citta = cS.getCitta();
		apiKey = aK.getApiKeyFromDB();
		BufferedReader input = null;
		Vector<String> cittaCurrentData = new Vector<String>();
		try{

			for(String c : citta) {
				String url = "http://api.openweathermap.org/data/2.5/weather?q=" + c
						+ "&appid=" + apiKey + "&units=metric&lang=it";
				URL apiUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
				input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String s;
				while((s = input.readLine()) != null) {
				cittaCurrentData.add(s);
				}
			}
			parsingCD.parsing(cittaCurrentData);

		}catch (MalformedURLException m) {
			// eccezione da scrivere
		}catch (IOException i) {
			// eccezione da scrivere
		}
	}
}
