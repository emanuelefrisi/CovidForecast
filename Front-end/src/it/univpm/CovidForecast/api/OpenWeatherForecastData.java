package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.CovidForecast.parsing.ParsingForecastData;

public class OpenWeatherForecastData {

	private ParsingForecastData pFD = new ParsingForecastData();
	private Vector<Vector<String>> weather = new Vector<Vector<String>>();

	public Vector<Vector<String>> getData(String citta, String apiKey) {

		try {
			String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + citta + "&appid=" + apiKey
					+ "&units=metric&lang=it";
			URL apiUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String s;
			while ((s = input.readLine()) != null) {
				weather = pFD.parsing(s);
			}
		} catch (MalformedURLException m) {
			System.out.println("Eccezione MalformedURLException");
		} catch (IOException i) {
			System.out.println("Eccezione IOException");
		}

		return weather;

	}

}