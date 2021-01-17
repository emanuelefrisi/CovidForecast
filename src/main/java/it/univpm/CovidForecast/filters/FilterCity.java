package it.univpm.CovidForecast.filters;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

/**
 * Classe che esegue il filtraggio in base alla città 
 */
@Service
public class FilterCity {

	@Autowired
	/**
	 * Oggetto MeteoCittaService utile per ottenere oggetti MeteoCitta dal DB
	 */
	private MeteoCittaService mCS;
	/**
	 * Lista che raccoglie gli oggetti di tipo MeteoCitta che poi verranno filtrati
	 */
	private List<MeteoCitta> listaPerFiltri;
	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per città
	 */
	private Vector<MeteoCitta> listaFiltrata;

	/**
	 * Metodo che esegue il filtraggio per città data in input
	 * 
	 * @param citta String
	 * @see it.univpm.CovidForecast.service.MeteoCittaService.getMeteoCittaFromDB
	 * @return Vector<MeteoCitta>
	 * 
	 */
	public Vector<MeteoCitta> getFromCityFilter(String city) {

		listaPerFiltri = mCS.getMeteoCittaFromDB();
		listaFiltrata = new Vector<MeteoCitta>();

		for (int i = 0; i < listaPerFiltri.size(); i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if (city.equals(mC.getCitta())) {
				listaFiltrata.add(mC);
			}
		}
		return listaFiltrata;
	}

}
