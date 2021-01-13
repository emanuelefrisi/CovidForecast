package it.univpm.CovidForecast.filters;

import java.util.Vector;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class FilterData {

	private Vector<MeteoCitta> vectFiltrato;

	public Vector<MeteoCitta> getFromDataFilter(Vector<MeteoCitta> listaPerFiltri, long dataInit, long dataFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < listaPerFiltri.size(); i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if (mC.getData() >= dataInit && mC.getData() <= dataFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
