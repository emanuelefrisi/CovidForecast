package it.univpm.CovidForecast.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

@Service
public class FilterHumidity {
	
	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri = mCS.getMeteoCittaFromDB();
	private List<MeteoCitta> ListaFiltrata;
	
	public List<MeteoCitta> getFromHumidityFilter(long umiditaInit, long umiditaFin) {
		for(int i=0;i<listaPerFiltri.size();i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if(mC.getUmidita()>umiditaInit&&mC.getUmidita()<umiditaFin) {
				ListaFiltrata.add(mC);
			}	
		}
		return ListaFiltrata;
	}

}
