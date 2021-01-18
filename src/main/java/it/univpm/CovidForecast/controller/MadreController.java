package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.scanner.VariabileScanner;
import it.univpm.CovidForecast.tools.ConvertitoreData;
import it.univpm.CovidForecast.tools.CreaCittaJSON;

/**
 * Classe madre contenente oggetti utili per ottenere filtri e stats da cui
 * ereditano StatsController e FiltriController
 * 
 * @author domenicolaporta00
 *
 */
public class MadreController {

	@Autowired
	/**
	 * Oggetto FilterCity utile per eseguire il filtraggio per città
	 */
	protected FilterCity fC = new FilterCity();
	/**
	 * Oggetto FilterData utile per eseguire il filtraggio per data
	 */
	protected FilterData fD = new FilterData();
	/**
	 * Oggetto ConvertitoreData utile per convertire la data da un formato Unix a
	 * formato String o viceversa
	 */
	protected ConvertitoreData cD = new ConvertitoreData();
	/**
	 * Oggetto CreaCittaJSON utile per passare da un oggetto MeteoCitta (data
	 * formato Unix) a un oggetto CittaJSON (data formato String)
	 */
	protected CreaCittaJSON cCJ = new CreaCittaJSON();
	/**
	 * Vector di CittaJSON contenente gli oggetti filtrati secondo l'input
	 * dell'utente
	 */
	protected Vector<CittaJSON> cJVect;
	/**
	 * Vector di MeteoCitta contenente gli oggetti filtrati per città
	 */
	protected Vector<MeteoCitta> vettCitta;
	/**
	 * Vector di MeteoCitta contenente gli oggetti filtrati per data
	 */
	protected Vector<MeteoCitta> vettData;
	/**
	 * Oggetto CittaScanner utile per controllare se la città data in input è
	 * presente in quelle disponibili
	 */
	protected CittaScanner cS = new CittaScanner();
	/**
	 * Oggetto VariabileScanner utile per controllare se la variabile data in input
	 * è presente in quelle disponibili
	 */
	protected VariabileScanner vS = new VariabileScanner();

}
