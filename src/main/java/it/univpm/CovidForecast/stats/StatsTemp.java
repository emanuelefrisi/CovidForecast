package it.univpm.CovidForecast.stats;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class StatsTemp extends Stats {

	@Override
	public MeteoCitta getMax() {
		mCMax = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTemp() > mCMax.getTemp()) {
				mCMax = mC;
			}
		}
		return mCMax;
	}

	@Override
	public MeteoCitta getMin() {
		mCMin = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTemp() < mCMin.getTemp()) {
				mCMin = mC;
			}
		}
		return mCMin;
	}

}
