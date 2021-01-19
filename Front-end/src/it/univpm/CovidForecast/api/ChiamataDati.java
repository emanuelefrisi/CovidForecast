package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.CovidForecast.parsing.ParsingDati;

public class ChiamataDati {

	private ParsingDati pD = new ParsingDati();
	private String chiamata;
	
	public Vector<String> chiamata(){
		
		try {
			String url = "http://localhost:8080/dati";
			URL apiUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) apiUrl.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(http.getInputStream()));
			chiamata = input.readLine();
			
		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		}
		
		return pD.parsing(chiamata);
		
	}
	
}
