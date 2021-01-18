package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue il filtraggio in base alla temperatura percepita 
 * 
 * @author domenicolaporta00
 */
@Service
public class FilterFL {

	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per temperatura
	 * percepita
	 */
	private Vector<MeteoCitta> vectFiltrato;

	/**
	 * Metodo che esegue il filtraggio per temperatura percepita su un Vector
	 * ricevuto in input
	 * 
	 * @param vectDaFiltr Vector<MeteoCitta>
	 * 
	 * @param TPInit Double
	 * 
	 * @param TPFin Double
	 * 
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromPTemperatureFilter(Vector<MeteoCitta> vectDaFiltr, Double TPInit, Double TPFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getTempPercepita() >= TPInit && mC.getTempPercepita() <= TPFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
