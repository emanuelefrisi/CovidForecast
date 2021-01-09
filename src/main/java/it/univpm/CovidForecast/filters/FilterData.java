package it.univpm.CovidForecast.filters;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

@Service
public class FilterData {

	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri;
	private Vector<MeteoCitta> listaFiltrata;

	public Vector<MeteoCitta> getFromDataFilter(long dataInit, long dataFin) {

		listaPerFiltri = mCS.getMeteoCittaFromDB();
		listaFiltrata = new Vector<MeteoCitta>();

		for (int i = 0; i < listaPerFiltri.size(); i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if (mC.getData() >= dataInit && mC.getData() <= dataFin) {
				listaFiltrata.add(mC);
			}
		}
		return listaFiltrata;
	}

}
