package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterTemperature {
	private Double tempInit;
	private Double tempFinish;
	private MeteoCittaService mcsT;
	private List<MeteoCitta> listaPerFiltri = mcsT.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataT;
	public List<MeteoCitta> getFromTemperatureFilter(/*List<MeteoCitta> listaPerFiltri , */Double tempInit, Double tempFinish) {
		this.tempInit=tempInit;
		this.tempFinish=tempFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getTemp()>this.tempInit&&listaPerFiltri.get(i).getTemp()<this.tempFinish) {
				listaFiltrataT.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataT;
	}

}
