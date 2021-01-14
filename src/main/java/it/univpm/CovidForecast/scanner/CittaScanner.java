package it.univpm.CovidForecast.scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class CittaScanner {

	private Vector<String> citta;
	
	private InputStream input;
	
	private Scanner inputCitta;
	
	public Vector<String> getCitta(){
		
		citta = new Vector<String>();
		
		input = getClass().getResourceAsStream("Città Covid.csv");
		inputCitta = new Scanner(new BufferedReader(new InputStreamReader(input)));
		
		inputCitta.nextLine();
		inputCitta.nextLine();
		while(inputCitta.hasNext()) {
			citta.add(inputCitta.nextLine());
		}
		return citta;
		
	}
	
	public boolean controlloCitta(Vector<String> cittaVect) {
		
		this.getCitta();
		
		for(int i = 0; i<cittaVect.size(); i++) {
			String c = cittaVect.elementAt(i);
			if(!this.citta.contains(c))
				return false;	
				
		}
		
		return true;
		
	}
	
}
