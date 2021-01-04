package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.*;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterPressure {
	private long pressureInit;
	private long pressureFinish;
	private MeteoCittaService mcsP;
	private List<MeteoCitta> listaPerFiltri = mcsP.getMeteoCittaFromDB();
	private List<MeteoCitta> ListaFiltrataP;
	public List<MeteoCitta> getFromPressureFilter(/*List<MeteoCitta> listaPerFiltri, */long pressureInit, long pressureFinish) {
		this.pressureInit=pressureInit;
		this.pressureFinish=pressureFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getPressione()>this.pressureInit&&listaPerFiltri.get(i).getPressione()<this.pressureFinish) {
				ListaFiltrataP.add(listaPerFiltri.get(i));
			}	
		}
		return ListaFiltrataP;
	}

}
