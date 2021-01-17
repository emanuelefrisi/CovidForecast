package it.univpm.CovidForecast.stats;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe che esegue le stats sull'umidità
 * 
 * @author 
 *
 */
@Service
public class StatsUmidita extends Stats {

	/**
	 * Metodo che trova il tipo di statistica desiderata sull'umidità
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
				if (mC.getUmidita() > mCMax.getUmidita()) {
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
				if (mC.getUmidita() < mCMin.getUmidita()) {
					mCMin = mC;
				}
			}
			mCVect.add(mCMin);
			return mCVect;

		case "varianza":
			Vector<Long> vett = new Vector<Long>();

			long somma = 0, sommaScartiQuadrati = 0, varianza, media;
			int n;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett.add(vectPerStats.elementAt(i).getUmidita());
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
			varianza = Long.valueOf(DF.format(varianza));
			mCVarianza.setUmidita(varianza);
			mCVarianza.setCitta(vectPerStats.elementAt(0).getCitta());
			mCVarianza.setNazione(vectPerStats.elementAt(0).getNazione());
			mCVarianza.setData(System.currentTimeMillis()/1000);
			VMCVarianza.add(mCVarianza);
			return VMCVarianza;

		case "media":
			Vector<Long> vett1 = new Vector<Long>();

			long somma1 = 0, media1;
			int num;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett1.add(vectPerStats.elementAt(i).getUmidita());
			}
			num = vett1.size();
			for (int i = 0; i < num; i++) {
				somma1 += vett1.elementAt(i);
			}
			media1 = somma1 / num;
			Vector<MeteoCitta> VMCMedia = new Vector<MeteoCitta>();
			MeteoCitta mCMedia = new MeteoCitta();
			DecimalFormat dF = new DecimalFormat("####.##", new DecimalFormatSymbols(Locale.ENGLISH));
			media1 = Long.valueOf(dF.format(media1));
			mCMedia.setUmidita(media1);
			mCMedia.setCitta(vectPerStats.elementAt(0).getCitta());
			mCMedia.setNazione(vectPerStats.elementAt(0).getNazione());
			mCMedia.setData(System.currentTimeMillis()/1000);
			VMCMedia.add(mCMedia);
			return VMCMedia;

		default: {
			/*Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>();
			MeteoCitta mCError = new MeteoCitta(0, "Errore di input del tipo di stat",
					"Errore di input del tipo di stat", 0, 0, null, null, null, null, 0);
			VMCError.add(mCError);
			return VMCError;*/
		}
		}
		return null;
	}

}
