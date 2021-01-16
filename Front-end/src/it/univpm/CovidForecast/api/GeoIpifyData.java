package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GeoIpifyData {
	
	private IpifyData iD = new IpifyData();
	
	private String ip;
	private Vector<String> geolocalizzazione = new Vector<String>();

	public Vector<String> getLocation(String apiKey) {

		String nazione;
		String citta;
		
		ip = iD.getIP();

		try {
			String url = "https://geo.ipify.org/api/v1?apiKey=" + apiKey + "&ipAddress=" + ip;
			URL apiUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) apiUrl.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String s = input.readLine();
			JSONParser jP = new JSONParser();
			JSONObject jO = (JSONObject) jP.parse(s);
			JSONObject jOLocation = (JSONObject) jO.get("location");
			nazione = (String) jOLocation.get("country");
			citta = (String) jOLocation.get("city");
			geolocalizzazione.add(nazione);
			geolocalizzazione.add(citta);

		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Eccezione ParseException");
			e.printStackTrace();
		}
		
		return geolocalizzazione;
		
	}

}