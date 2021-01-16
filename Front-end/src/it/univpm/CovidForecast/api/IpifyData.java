package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IpifyData {

	private String ip;
	
	public String getIP() {
		
		try {
			String url = "https://api.ipify.org";
			URL apiUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) apiUrl.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(http.getInputStream()));
			ip = input.readLine();
		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		}
		
		return ip;
		
	}
	
}