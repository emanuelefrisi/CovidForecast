package it.univpm.CovidForecast.tools;

import java.util.Vector;

import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;

public class CreaCittaJSON {

	private ConvertitoreData cD = new ConvertitoreData();
	private Vector<CittaJSON> cJVect;
	
	public Vector<CittaJSON> getCittaJSON(Vector<MeteoCitta> mCVect){
		
		cJVect = new Vector<CittaJSON>();
		
		for(int i = 0; i<mCVect.size(); i++) {
			MeteoCitta mC = mCVect.elementAt(i);
			String data = cD.covertiDaUnix(mC.getData());
			String citta = mC.getCitta();
			String nazione = mC.getNazione();
			long pressione = mC.getPressione();
			Double temp = mC.getTemp();
			Double tempMax = mC.getTempMax();
			Double tempMin = mC.getTempMin();
			Double tempPercepita = mC.getTempPercepita();
			long umidita = mC.getUmidita();
			CittaJSON cJ = new CittaJSON(data, citta, nazione, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
			cJVect.add(cJ);
		}
		
		return cJVect;
		
	}
	
//	public CittaJSON getCittaJSON(MeteoCitta mC) {
//		
//		String data = cD.covertiDaUnix(mC.getData());
//		String citta = mC.getCitta();
//		String nazione = mC.getNazione();
//		long pressione = mC.getPressione();
//		Double temp = mC.getTemp();
//		Double tempMax = mC.getTempMax();
//		Double tempMin = mC.getTempMin();
//		Double tempPercepita = mC.getTempPercepita();
//		long umidita = mC.getUmidita();
//		CittaJSON cJ = new CittaJSON(data, citta, nazione, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
//		
//		return cJ;
//		
//	}
	
}
