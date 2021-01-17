package it.univpm.CovidForecast.filters;

import java.util.Vector;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue il filtraggio in base alla data 
 */
@Service
public class FilterData {

	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per data
	 */
	private Vector<MeteoCitta> vectFiltrato;

	/**
	 * Metodo che esegue il filtraggio per data su un Vector ricevuto in input
	 * 
	 * @param listaPerFiltri Vector<MeteoCitta>
	 * 
	 * @param dataInit long
	 * 
	 * @param dataFin long
	 * 
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromDataFilter(Vector<MeteoCitta> listaPerFiltri, long dataInit, long dataFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < listaPerFiltri.size(); i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if (mC.getData() >= dataInit && mC.getData() <= dataFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
