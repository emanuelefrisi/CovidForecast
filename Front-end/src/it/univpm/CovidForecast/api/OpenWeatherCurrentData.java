package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JOptionPane;

import it.univpm.CovidForecast.exceptions.CFException;
import it.univpm.CovidForecast.parsing.ParsingCurrentData;

public class OpenWeatherCurrentData {

	private ParsingCurrentData pCD = new ParsingCurrentData();
	private Vector<String> weather = new Vector<String>();
	
	public Vector<String> getData(String citta, String apiKey) throws CFException {
		
		try {
				String url = "http://api.openweathermap.org/data/2.5/weather?q=" + citta
						+ "&appid=" + apiKey + "&units=metric&lang=it";
				URL apiUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
				BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String s;
				while((s = input.readLine()) != null) {
				weather = pCD.parsing(s);
				}
		}catch (MalformedURLException m) {
			System.out.println("Eccezione MalformedURLException");
		} catch (IOException i) {
			throw new CFException("La città inserita non è valida", "CovidForecast", JOptionPane.ERROR_MESSAGE);
		}
		
		return weather;
		
	}
	
}