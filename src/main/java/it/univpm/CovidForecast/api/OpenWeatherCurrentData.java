package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.CovidForecast.Scanner.CittaScanner;

/**
 * 
 * Classe che esegue la chiamata all'API di OpenWeather riguardante i dati
 * attuali di una città
 * 
 * @author emanuelefrisi
 *
 */
public class OpenWeatherCurrentData {

	private CittaScanner cS = new CittaScanner();
	private Vector<String> citta;

	public Vector<String> getCurrentData() {

		citta = cS.getCitta();
		BufferedReader input = null;
		Vector<String> cittaCurrentData = new Vector<String>();

		try{

			for(String c : citta) {
				String url = "http://api.openweathermap.org/data/2.5/weather?q=" + c
						+ "&appid=6f02b4af6340b065f7602022c775c531";
				URL apiUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
				input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String s;
				while((s = input.readLine()) != null) {
				cittaCurrentData.add(s);
				}
			}

		}catch (MalformedURLException m) {
			// eccezione da scrivere
		}catch (IOException i) {
			// eccezione da scrivere
		}

		return cittaCurrentData;

	}
}
