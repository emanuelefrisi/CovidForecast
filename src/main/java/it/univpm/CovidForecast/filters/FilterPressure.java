package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class FilterPressure {

	private Vector<MeteoCitta> vectFiltrata;

	public Vector<MeteoCitta> getFromPressureFilter(Vector<MeteoCitta> vectDaFiltr, long pressureInit, long pressureFin) {

		vectFiltrata = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getPressione() >= pressureInit && mC.getPressione() <= pressureFin) {
				vectFiltrata.add(mC);
			}
		}
		return vectFiltrata;
	}

}
