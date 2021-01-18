package it.univpm.CovidForecast.filters;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.ForecastCittaService;
import it.univpm.CovidForecast.service.MeteoCittaService;

/**
 * Classe che esegue il filtraggio in base alla città 
 * 
 * @author domenicolaporta00
 * 
 */
@Service
public class FilterCity {

	/**
	 * Oggetto MeteoCittaService utile per ottenere oggetti MeteoCitta dal DB
	 */
	@Autowired
	private MeteoCittaService mCS;
	/**
	 * Oggetto ForecastCittaService utile per ottenere oggetti ForecastCitta dal DB
	 */
	@Autowired
	private ForecastCittaService fCS;
	/**
	 * Lista che raccoglie gli oggetti di tipo MeteoCitta che poi verranno filtrati
	 */
	private List<MeteoCitta> listaPerFiltri;
	/**
	 * Lista che raccoglie gli oggetti di tipo ForecastCitta che poi verranno filtrati
	 */
	private List<ForecastCitta> listaPerFiltriForecast;
	/**
	 * Vector contenente gli oggetti di tipo MeteoCitta filtarti per città
	 */
	private Vector<MeteoCitta> listaFiltrata;
	/**
	 * Vector contenente gli oggetti di tipo ForecastCitta filtarti per città
	 */
	private Vector<ForecastCitta> listaFiltrataForecast;

	/**
	 * Metodo che esegue il filtraggio per città data in input della lista MeteoCitta
	 * 
	 * @param city String
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
	
	/**
	 * 
	 * Metodo che esegue il filtraggio per città data in input della lista di ForecastCitta
	 * 
	 * @param city
	 * @see it.univpm.CovidForecast.service.ForecastCittaService.getForecastCittaFromDB
	 * @return listaFiltrataForecast
	 */
	public Vector<ForecastCitta> getFromCityFilterForecast(String city) {

		listaPerFiltriForecast = fCS.getForecastCittaFromDB();
		listaFiltrataForecast = new Vector<ForecastCitta>();

		for (int i = 0; i < listaPerFiltriForecast.size(); i++) {
			ForecastCitta fC = listaPerFiltriForecast.get(i);
			if (city.equals(fC.getCitta())) {
				listaFiltrataForecast.add(fC);
			}
		}
		return listaFiltrataForecast;
	}

}
