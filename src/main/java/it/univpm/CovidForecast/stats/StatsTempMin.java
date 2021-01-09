package it.univpm.CovidForecast.stats;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class StatsTempMin extends Stats {

	@Override
	public MeteoCitta getMax() {
		listaPerStats = mCS.getMeteoCittaFromDB();
		mCMax = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTempMin() > mCMax.getTempMin()) {
				mCMax = mC;
			}
		}
		return mCMax;
	}

	@Override
	public MeteoCitta getMin() {
		listaPerStats = mCS.getMeteoCittaFromDB();
		mCMin = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTempMin() < mCMin.getTempMin()) {
				mCMin = mC;
			}
		}
		return mCMin;
	}

}
