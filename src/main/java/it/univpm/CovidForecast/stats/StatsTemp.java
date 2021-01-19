package it.univpm.CovidForecast.stats;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue le stats sulla temperatura
 * 
 * @author domenicolaporta00
 *
 */
@Service
public class StatsTemp extends Stats {

	/**
	 * Metodo che trova il tipo di statistica desiderata sulla temperatura
	 * 
	 * @param tipoStat     String
	 * @param vectPerStats Vector<MeteoCitta>
	 * @return mCVect
	 * 
	 */
	@Override
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (tipoStat) {

		case "max":
			mCVect = new Vector<MeteoCitta>();

			mCMax = vectPerStats.get(0);
			for (int i = 1; i < vectPerStats.size(); i++) {
				MeteoCitta mC = vectPerStats.get(i);
				if (mC.getTemp() > mCMax.getTemp()) {
					mCMax = mC;
				}
			}
			mCVect.add(mCMax);
			return mCVect;

		case "min":
			mCVect = new Vector<MeteoCitta>();

			mCMin = vectPerStats.get(0);
			for (int i = 1; i < vectPerStats.size(); i++) {
				MeteoCitta mC = vectPerStats.get(i);
				if (mC.getTemp() < mCMin.getTemp()) {
					mCMin = mC;
				}
			}
			mCVect.add(mCMin);
			return mCVect;

		case "varianza":
			Vector<Double> vett = new Vector<Double>();

			Double somma = (double) 0, sommaScartiQuadrati = (double) 0, varianza, media;
			int n;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett.add(vectPerStats.elementAt(i).getTemp());
			}
			n = vett.size();
			for (int i = 0; i < n; i++) {
				somma += vett.elementAt(i);
			}
			media = somma / n;
			for (int i = 0; i < n; i++) {
				sommaScartiQuadrati += Math.pow(vett.elementAt(i) - media, 2);
			}
			varianza = sommaScartiQuadrati / n;
			Vector<MeteoCitta> VMCVarianza = new Vector<MeteoCitta>();
			MeteoCitta mCVarianza = new MeteoCitta();
			DecimalFormat DF = new DecimalFormat("##.##", new DecimalFormatSymbols(Locale.ENGLISH));
			varianza = Double.valueOf(DF.format(varianza));
			mCVarianza.setTemp(varianza);
			mCVarianza.setCitta(vectPerStats.elementAt(0).getCitta());
			mCVarianza.setNazione(vectPerStats.elementAt(0).getNazione());
			mCVarianza.setData(System.currentTimeMillis()/1000);
			VMCVarianza.add(mCVarianza);
			return VMCVarianza;

		case "media":
			Vector<Double> vett1 = new Vector<Double>();

			Double somma1 = (double) 0, media1;
			int num;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett1.add(vectPerStats.elementAt(i).getTemp());
			}
			num = vett1.size();
			for (int i = 0; i < num; i++) {
				somma1 += vett1.elementAt(i);
			}
			media1 = somma1 / num;
			Vector<MeteoCitta> VMCMedia = new Vector<MeteoCitta>();
			MeteoCitta mCMedia = new MeteoCitta();
			DecimalFormat dF = new DecimalFormat("####.##", new DecimalFormatSymbols(Locale.ENGLISH));
			media1 = Double.valueOf(dF.format(media1));
			mCMedia.setTemp(media1);
			mCMedia.setCitta(vectPerStats.elementAt(0).getCitta());
			mCMedia.setNazione(vectPerStats.elementAt(0).getNazione());
			mCMedia.setData(System.currentTimeMillis()/1000);
			VMCMedia.add(mCMedia);
			return VMCMedia;

		}
		return null;

	}

}
