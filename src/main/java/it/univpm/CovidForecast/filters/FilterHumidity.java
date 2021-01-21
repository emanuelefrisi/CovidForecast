package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue il filtraggio in base all'umidita
 * 
 * @author domenicolaporta00
 */
@Service
public class FilterHumidity {

	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per umidità
	 */
	private Vector<MeteoCitta> vectFiltrato;

	/**
	 * Metodo che esegue il filtraggio per umidità su un Vector ricevuto in input
	 * 
	 * @param vectDaFiltr Vector<MeteoCitta>
	 * 
	 * @param umiditaInit long
	 * 
	 * @param umiditaFin long
	 * 
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromHumidityFilter(Vector<MeteoCitta> vectDaFiltr, long umiditaInit, long umiditaFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getUmidita() >= umiditaInit && mC.getUmidita() <= umiditaFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
