package it.univpm.CovidForecast.tools;

import java.util.Vector;

import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * 
 * Classe che permette di creare un vettore di oggetti CittaJSON
 * 
 * @author emanuelefrisi
 *
 */
public class CreaCittaJSON {

	/**
	 * Oggetto utilizzato per convertire la data, in questo caso da unix a stringa
	 */
	private ConvertitoreData cD = new ConvertitoreData();
	/**
	 * Vettore di CittaJSON
	 */
	private Vector<CittaJSON> cJVect;
	
	/**
	 * 
	 * Metodo che consente di creare oggetti CittaJSON a partire da oggetti MeteoCitta ed aggiungerli
	 * ad un vettore che sarà restituito
	 * 
	 * @param mCVect
	 * @return cJVect
	 * 
	 * @see ConvertitoreData
	 * 
	 */
	public Vector<CittaJSON> getCittaJSON(Vector<MeteoCitta> mCVect){
		
		cJVect = new Vector<CittaJSON>();
		
		for(int i = 0; i<mCVect.size(); i++) {
			MeteoCitta mC = mCVect.elementAt(i);
			String data = cD.convertiDaUnix(mC.getData());
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
	
}
