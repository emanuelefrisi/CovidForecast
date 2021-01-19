package it.univpm.CovidForecast.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.scanner.CovidScanner;

/**
 * 
 * Controller il cui metodo GET restituisce un hashmap contentente
 * le città come chiave e i dati relativi al covid come valore
 * 
 * @author emanuelefrisi
 *
 * @see it.univpm.CovidForecast.scanner.CittaScanner
 * @see it.univpm.CovidForecast.scanner.CovidScanner
 *
 */
@RestController
public class DataController {

	/**
	 * HashMap in cui vengono istanziate le coppie chiave-valore(città-dati covid)
	 */
	private HashMap<String, String> map;
	/**
	 * Vettore che riceve le città da CittaScanner
	 */
	private Vector<String> citta;
	/**
	 * Vettore ceh riceve i dati sul covid da CovidScanner
	 */
	private Vector<String> datiCovid;
	
	private CittaScanner cS = new CittaScanner();
	private CovidScanner covS = new CovidScanner();
	
	/**
	 * 
	 * Rotta che ritorna l'HashMap che viene trasformato in json
	 * 
	 * @return map
	 * 
	 */
	@GetMapping("/dati")
	public HashMap<String, String> dati(){
		
		map = new LinkedHashMap<String, String>();
		citta = cS.getCitta();
		datiCovid = covS.getDatiCovid();
		
		for(int i = 0; i<citta.size(); i++)
			map.put(citta.elementAt(i), datiCovid.elementAt(i));
		
		return map;
		
	}
	
}
