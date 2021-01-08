package it.univpm.CovidForecast.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

//@Service
public class FilterData {
	
	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri = mCS.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrata;
	
	public List<MeteoCitta> getFromDataFilter(long dataInit, long dataFin) {
		for(int i=0;i<listaPerFiltri.size();i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if(mC.getData()>dataInit&&mC.getData()<dataFin) {
				listaFiltrata.add(mC);
			}	
		}
		return listaFiltrata;
	}
	
}
