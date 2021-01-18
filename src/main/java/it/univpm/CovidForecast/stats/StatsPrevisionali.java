package it.univpm.CovidForecast.stats;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.ForecastCittaService;
import it.univpm.CovidForecast.service.MeteoCittaService;
import it.univpm.CovidForecast.tools.ConvertitoreData;

public class StatsPrevisionali {

	private Vector<MeteoCitta> mCVect;
	private Vector<ForecastCitta> fCVect;
	
	private ConvertitoreData cD = new ConvertitoreData();
	
	private int giorno;
	private int giornoForecast;
	private int ora;
	private static final int oraDefault = 9;
//	private static final int giornoSec = 86400; 
	private String data;
	
	public void creaStat(Vector<MeteoCitta> vectCitta, Vector<ForecastCitta> vectForecastCitta) {
		
		mCVect = new Vector<MeteoCitta>();
		fCVect = new Vector<ForecastCitta>();
		
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
//			System.out.println("Meteo: " + giorno);
			for(int j = 0; j<fCVect.size(); j++) {
				
				ForecastCitta fC = fCVect.elementAt(j);
				giornoForecast = Integer.valueOf(fC.getDataTxt().substring(8, 10));
//				System.out.println("Forecast: " + giornoForecast);
				if(giorno == giornoForecast)
					System.out.println("Controllo " + cD.convertiDaUnix(mC.getData()) + " " + fC.getDataTxt());
			}
			
		}
		
//		for(int i = 0; i<fCVect.size(); i++)
//			System.out.println(fCVect.elementAt(i).getDataTxt());
//		
//		for(int i = 0; i<mCVect.size(); i++)
//			System.out.println(cD.convertiDaUnix(mCVect.elementAt(i).getData()));
		
	}
}
