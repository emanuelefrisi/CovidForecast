package it.univpm.CovidForecast.stats;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.ForecastCittaService;
import it.univpm.CovidForecast.service.MeteoCittaService;

@Service
public class StatsPrevisionali {

	@Autowired
	private MeteoCittaService mCS;
	@Autowired
	private ForecastCittaService fCS;
	
	private List<MeteoCitta> mCList;
	private List<ForecastCitta> fCList;
	private Vector<MeteoCitta> mCVect;
	private Vector<ForecastCitta> fCVect;
	
	private static int ora = 9;
	private static final int giorno = 86400; 
	
	public void creaStat() {
		
		mCList = mCS.getMeteoCittaFromDB();
		fCList = fCS.getForecastCittaFromDB();
		mCVect = new Vector<MeteoCitta>();
		fCVect = new Vector<ForecastCitta>();
		
		for(int i = 0; i<mCList.size(); i++) {
			MeteoCitta mC = mCList.get(i);
			if(mC.getOra() == ora)
				mCVect.add(mC);
			ora+=24;
		}
		
		for(int i = 0; i<fCList.size(); i++) {
			
			ForecastCitta fC = fCList.get(i);
			String s = fC.getDataTxt().substring(i, i);
//			if())
			
		}
		
	}
	
}
