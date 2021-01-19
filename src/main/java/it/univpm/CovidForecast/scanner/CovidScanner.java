package it.univpm.CovidForecast.scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class CovidScanner {

	private Vector<String> dati;
	
	private InputStream input;
	
	private Scanner inputCovid;
	
	public Vector<String> getDatiCovid(){
		
		dati = new Vector<String>();
		
		input = getClass().getResourceAsStream("Dati Covid.csv");
		inputCovid = new Scanner(new BufferedReader(new InputStreamReader(input)));
		
		inputCovid.nextLine();
		inputCovid.nextLine();
		while(inputCovid.hasNext()) {
			dati.add(inputCovid.nextLine());
		}
		return dati;
		
	}
	
}
