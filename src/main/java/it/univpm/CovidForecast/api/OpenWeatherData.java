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
import it.univpm.CovidForecast.parsing.ParsingForecastData;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.service.ApiKeyService;

/**
 * 
 * Classe che esegue la chiamata all'API di OpenWeather riguardante i dati
 * attuali e previsionali per ogni città che viene letta dallo scanner
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class OpenWeatherData {

	private CittaScanner cS = new CittaScanner();
	@Autowired
	private ApiKeyService aKS = new ApiKeyService();
	@Autowired
	private ParsingCurrentData parsingCD = new ParsingCurrentData();
	@Autowired
	private ParsingForecastData parsingFD = new ParsingForecastData();
	private Vector<String> citta;
	private String apiKey;
	
	public void getData(String tipo) {
		Vector<String> cittaData = new Vector<String>();
		citta = cS.getCitta();
		apiKey = aKS.getApiKeyFromDB();
		try {
			for(String c : citta) {
				String url = "http://api.openweathermap.org/data/2.5/" + tipo + "?q=" + c
						+ "&appid=" + apiKey + "&units=metric&lang=it";
				URL apiUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
				BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String s;
				while((s = input.readLine()) != null) {
				cittaData.add(s);
				}
			}
			if(tipo.equals("weather"))
				parsingCD.parsing(cittaData);
			else
				parsingFD.parsing(cittaData);
		}catch (MalformedURLException m) {
			System.out.println("Eccezione MalformedURLException");
		} catch (IOException i) {
			System.out.println("Eccezione IOException");
		}
	}
	
}
