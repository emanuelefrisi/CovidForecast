package it.univpm.CovidForecast.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.scanner.CovidScanner;

@RestController
public class DataController {

	private HashMap<String, String> map;
	private Vector<String> citta;
	private Vector<String> datiCovid;
	private CittaScanner cS = new CittaScanner();
	private CovidScanner covS = new CovidScanner();
	
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
