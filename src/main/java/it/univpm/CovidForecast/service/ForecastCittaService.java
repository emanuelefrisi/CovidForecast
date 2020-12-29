package it.univpm.CovidForecast.service;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.repository.ForecastCittaRepository;

/**
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class ForecastCittaService {

	@Autowired
	private ForecastCittaRepository fCR;
	
	public void salvaRecord(Vector<ForecastCitta> fC) {
		fCR.saveAll(fC);
	}
	
}
