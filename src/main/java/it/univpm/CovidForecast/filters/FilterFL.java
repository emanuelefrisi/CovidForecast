package it.univpm.CovidForecast.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

//@Service
public class FilterFL {
	
	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri = mCS.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrata;
	
	public List<MeteoCitta> getFromPTemperatureFilter(Double TPInit, Double TPFin) {
		for(int i=0;i<listaPerFiltri.size();i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if(mC.getTempPercepita()>TPInit&&mC.getTempPercepita()<TPFin) {
				listaFiltrata.add(mC);
			}	
		}
		return listaFiltrata;
	}

}
