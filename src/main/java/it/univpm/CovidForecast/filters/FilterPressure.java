package it.univpm.CovidForecast.filters;

import java.util.List;
import java.util.Vector;

//import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

@Service
public class FilterPressure {

	@Autowired
	private MeteoCittaService mCS;
	private List<MeteoCitta> listaPerFiltri;
	private Vector<MeteoCitta> listaFiltrata;
	// private int cont;

	public Vector<MeteoCitta> getFromPressureFilter(long pressureInit, long pressureFin) {

		listaPerFiltri = mCS.getMeteoCittaFromDB();
		listaFiltrata = new Vector<MeteoCitta>();
		// cont = 0;

		for (int i = 0; i < listaPerFiltri.size(); i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if (mC.getPressione() >= pressureInit && mC.getPressione() <= pressureFin) {
				// cont++;
				listaFiltrata.add(mC);
			}
		}
//		JOptionPane.showMessageDialog(null, "Oggetti ritornati: " + cont, "CovidForecast", JOptionPane.INFORMATION_MESSAGE);
		// System.out.println(cont);
		return listaFiltrata;
	}

}
