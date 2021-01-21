package it.univpm.CovidForecast.scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Classe che fa da scanner per le citta utili per effettuare le chiamate ad OpenWeather
 * 
 * @author emanuelefrisi
 *
 */
public class CittaScanner {

	/**
	 * Vettore dove vengono istanziate le citta
	 */
	private Vector<String> citta;
	
	private InputStream input;
	
	private Scanner inputCitta;
	
	/**
	 * 
	 * Metodo che legge dal file "Città Covid.csv" le città per effettuare le chiamate ad OpenWeather
	 * Ritorna il vettore citta
	 * 
	 * @return citta
	 * 
	 */
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
	
	/**
	 * 
	 * Metodo che controlla se ogni città contenuta nel vettore di ingresso è presente nel vettore citta
	 * 
	 * @param cittaVect
	 * @return un valore boolean in relazione al controllo fatto
	 */
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
