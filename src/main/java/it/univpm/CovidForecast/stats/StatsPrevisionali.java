package it.univpm.CovidForecast.stats;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.tools.ConvertitoreData;

public class StatsPrevisionali {

	/**
	 * Vettore di MeteoCitta
	 */
	private Vector<MeteoCitta> mCVect;
	/**
	 * Vettore di ForecastCitta
	 */
	private Vector<ForecastCitta> fCVect;
	/**
	 * HaspMap in cui sia la chiave che il valore sono stringhe
	 */
	private HashMap<String, String> map;
	/**
	 * Oggetto che permette la conversione della data
	 */
	private ConvertitoreData cD = new ConvertitoreData();
	/**
	 * Variabile per salvare il giorno degli oggetti MeteoCitta
	 */
	private int giorno;
	/**
	 * Variabile per salvare il giorno degli oggetti ForecastCitta
	 */
	private int giornoForecast;
	/**
	 * Variabile utile per il controllo dell'ora in relazione ad oraDefault
	 */
	private int ora;
	/*
	 * Ora di default
	 */
	private static final int oraDefault = 9;
	/**
	 * Variabile per salvare la data degli oggetti MeteoCitta e ForecastCitta convertiti da unix a stringa
	 */
	private String data;
	
	/**
	 * 
	 * Metodo per creare la statistica sui dati previsionali che poi viene ritornata tramite un LinkedHashMap
	 * 
	 * @param vectCitta
	 * @param vectForecastCitta
	 * @param citta
	 * @param errore
	 * @return map
	 */
	public HashMap<String, String> creaStat(Vector<MeteoCitta> vectCitta, Vector<ForecastCitta> vectForecastCitta, String citta, int errore) {
		
		mCVect = new Vector<MeteoCitta>();
		fCVect = new Vector<ForecastCitta>();
		int cont=0;
		
		for(int i = 0; i<vectCitta.size(); i++) {
			MeteoCitta mC = vectCitta.get(i);
			data = cD.convertiDaUnix(mC.getData());
			ora = Integer.valueOf(data.substring(11, 13));
			if(ora == oraDefault)
				mCVect.add(mC);
		}
		
		for(int i = 0; i<vectForecastCitta.size(); i++) {
			
			ForecastCitta fC = vectForecastCitta.get(i);
			data = fC.getDataTxt();
			ora = Integer.valueOf(data.substring(11, 13));
			if(ora == oraDefault)
				fCVect.add(fC);
			
		}
		
		for(int i = 0; i<mCVect.size(); i++) {
			
			MeteoCitta mC = mCVect.elementAt(i);
			giorno = Integer.valueOf(cD.convertiDaUnix(mC.getData()).substring(0, 2));
			for(int j = 0; j<fCVect.size(); j++) {
				
				ForecastCitta fC = fCVect.elementAt(j);
				giornoForecast = Integer.valueOf(fC.getDataTxt().substring(8, 10));
				if(giorno == giornoForecast) {
					if(Math.abs(mC.getUmidita()-fC.getUmidita())<=errore) {
					cont++;
					}
				}
			}
			
		}
		map = new LinkedHashMap<String, String>();
		map.put("Città", citta);
		map.put("Numero previsioni azzecate", "" + cont);
		map.put("Errore", "" + errore + "%");
		return map;
		
	}
}
