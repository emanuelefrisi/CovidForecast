package it.univpm.CovidForecast.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

@Service
public class FilterPressure {
	
	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri = mCS.getMeteoCittaFromDB();
	private List<MeteoCitta> ListaFiltrata;
	
	public List<MeteoCitta> getFromPressureFilter(long pressureInit, long pressureFin) {
		for(int i=0;i<listaPerFiltri.size();i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if(mC.getPressione()>pressureInit&&mC.getPressione()<pressureFin) {
				ListaFiltrata.add(mC);
			}	
		}
		return ListaFiltrata;
	}

}
