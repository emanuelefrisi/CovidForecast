package it.univpm.CovidForecast.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.repository.ForecastCittaRepository;

/**
 * 
 * Classe service che utilizza i metodi di ForecastCittaRepository per salvare gli oggetti
 * dal database o recuperarli
 * 
 * @author emanuelefrisi
 * 
 * @see it.univpm.CovidForecast.repository.ForecastCittaRepository
 *
 */
@Service
public class ForecastCittaService {

	@Autowired
	private ForecastCittaRepository fCR;
	
	/**
	 * Metodo che salva un vettore di ForecastCitta sul database 
	 * @param fC
	 */
	public void salvaRecord(Vector<ForecastCitta> fC) {
		fCR.saveAll(fC);
	}
	/**
	 * Metodo che ritorna una lista di ForecastCitta recuperati dal database
	 * @return lista di ForecastCitta
	 */
	public List<ForecastCitta> getForecastCittaFromDB() {
		return fCR.findAll();
	}
	
}
