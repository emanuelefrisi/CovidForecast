package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

public class ApiKeyData {

	private Vector<String> apiKeys = new Vector<String>();
	
	public Vector<String> getApiKeys() {

		try {
			URL url = new URL("http://localhost:8080/getApiKeys");
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(c.getInputStream())));
			while(input.hasNext()) {
			apiKeys.add(input.next());
			}
		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		}

		return apiKeys;
		
	}
	
}