package it.univpm.CovidForecast.Scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class CittaScanner {

	Vector<String> citta;
	
	InputStream input;
	
	Scanner inputCitta;
	
	public Vector<String> getCitta(){
		
		citta = new Vector<String>();
		
		input = getClass().getResourceAsStream("Città Covid.csv");
//		InputStreamReader input = new InputStreamReader(file);
		inputCitta = new Scanner(new BufferedReader(new InputStreamReader(input)));
		
		inputCitta.nextLine();
		inputCitta.nextLine();
		while(inputCitta.hasNext()) {
			citta.add(inputCitta.nextLine());
		}
		
		return citta;
		
	}
	
}
