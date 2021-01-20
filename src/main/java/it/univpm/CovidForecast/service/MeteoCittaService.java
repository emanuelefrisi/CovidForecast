package it.univpm.CovidForecast.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.repository.MeteoCittaRepository;

import java.util.List;

/**
 * 
 * Classe service che utilizza i metodi di MeteoCittaRepository per salvare gli oggetti
 * dal database o recuperarli
 * 
 * @author emanuelefrisi
 * 
 * @see it.univpm.CovidForecast.repository.MeteoCittaRepository
 *
 */
@Service
public class MeteoCittaService {

	@Autowired
	private MeteoCittaRepository mCR;
	
	/**
	 * Metodo che salva un oggetto MeteoCitta sul database 
	 * @param mC
	 */
	public void salvaRecord(MeteoCitta mC) {
		mCR.save(mC);
	}
	
	/**
	 * Metodo che ritorna una lista di MeteoCitta recuperati dal database
	 * @return lista di MeteoCitta
	 */
	public List<MeteoCitta> getMeteoCittaFromDB() {
		return mCR.findAll();
	}
	
}
