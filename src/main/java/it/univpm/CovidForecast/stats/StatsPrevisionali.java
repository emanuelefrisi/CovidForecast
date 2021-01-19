package it.univpm.CovidForecast.stats;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.tools.ConvertitoreData;

public class StatsPrevisionali {

	private Vector<MeteoCitta> mCVect;
	private Vector<ForecastCitta> fCVect;
	private HashMap<String, String> map;
	
	private ConvertitoreData cD = new ConvertitoreData();
	
	private int giorno;
	private int giornoForecast;
	private int ora;
	private static final int oraDefault = 9;
	private String data;
	
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
