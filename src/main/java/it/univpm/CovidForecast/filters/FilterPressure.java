package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue il filtraggio in base alla pressione 
 * 
 * @author domenicolaporta00
 */
@Service
public class FilterPressure {

	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per pressione
	 */
	private Vector<MeteoCitta> vectFiltrata;

	/**
	 * Metodo che esegue il filtraggio per pressione su un Vector ricevuto in input
	 * 
	 * @param vectDaFiltr Vector<MeteoCitta>
	 * 
	 * @param pressureInit long
	 * 
	 * @param pressureFin long
	 * 
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromPressureFilter(Vector<MeteoCitta> vectDaFiltr, long pressureInit,
			long pressureFin) {

		vectFiltrata = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getPressione() >= pressureInit && mC.getPressione() <= pressureFin) {
				vectFiltrata.add(mC);
			}
		}
		return vectFiltrata;
	}

}
