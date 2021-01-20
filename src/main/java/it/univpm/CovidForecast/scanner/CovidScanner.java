package it.univpm.CovidForecast.scanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Classe che fa da scanner per i contagi totali del covid
 * 
 * @author emanuelefrisi
 *
 */
public class CovidScanner {

	/**
	 * Vettore dove vengono instanziati i dati del covid
	 */
	private Vector<String> dati;
	
	private InputStream input;
	
	private Scanner inputCovid;
	
	/**
	 * 
	 * Metodo che legge dal file "Dati Covid.csv" i dati relativi ai contagiati totali del covid
	 * Ritorna il vettore dati
	 * 
	 * @return dati
	 * 
	 */
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
