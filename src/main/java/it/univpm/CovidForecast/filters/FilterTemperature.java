package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue il filtraggio in base alla temperatura 
 * 
 * @author domenicolaporta00
 * 
 */
@Service
public class FilterTemperature {

	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per temperatura
	 */
	private Vector<MeteoCitta> vectFiltrato;

	/**
	 * Metodo che esegue il filtraggio per temperatura su un Vector ricevuto in
	 * input
	 * 
	 * @param vectDaFiltr Vector<MeteoCitta>
	 * 
	 * @param tempInit Double
	 * 
	 * @param tempFin Double
	 * 
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromTemperatureFilter(Vector<MeteoCitta> vectDaFiltr, Double tempInit,
			Double tempFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getTemp() >= tempInit && mC.getTemp() <= tempFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
