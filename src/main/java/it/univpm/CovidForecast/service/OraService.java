package it.univpm.CovidForecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.Ora;
import it.univpm.CovidForecast.repository.OraRepository;

/**
 * 
 * Classe service che utilizza i metodi di OraRepository per salvare gli oggetti
 * dal database o recuperarli
 * 
 * @author emanuelefrisi
 *
 * @see it.univpm.CovidForecast.repository.OraRepository
 *
 */
@Service
public class OraService {

	@Autowired
	private OraRepository oR;
	
	/**
	 * Metodo che salva un oggetto Ora sul database 
	 * @param o
	 */
	public void salvaRecord(Ora o) {
		oR.save(o);
	}
	
	/**
	 * Metodo che recuperare l'oggetto ora alla prima posizione della relativa tabella del database
	 * @return o
	 */
	public Ora getOra() {
		Ora o = oR.findAll().get(0);
		return o;
	}
	
}
