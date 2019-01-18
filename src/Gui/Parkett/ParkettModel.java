package Gui.Parkett;


import Business.KundeModel;
import HibernateCont.Kunde;
import HibernateCont.SonderwuenscheFliesen;
import HibernateCont.SonderwuenscheHeizung;
import HibernateCont.SonderwuenscheParkett;

import java.util.List;
import java.util.Set;

public class ParkettModel {
	private double _preis = 0;
	private boolean _auswahl = true;
	private boolean hasHeizungOhneDg = false;
	private boolean hasHeizungMitDg = false;
	private boolean hasKeineFliesenKuecheEg = false;
	private boolean hasFliesenBadDG = false;
	private Kunde kunde = KundeModel.getInstance().getKunde();
	private boolean hasDg = kunde.getHausnummer().getHaustyp().getDachgeschoss() == 0 ? false : true;
	
	public void gesamtpreisBerechnen (Set<SonderwuenscheParkett> wuensche) {
		for (SonderwuenscheParkett wunsch: wuensche
			 ) {
			this._preis += wunsch.getPreis();
		}
	}
	
	public double getPreis() {
		return _preis;
	}

	public void initializeBooleans(){
		List<SonderwuenscheHeizung> sonderwuenscheHeizung = kunde.getSonderwuenscheHeizung();
		Set<SonderwuenscheFliesen> sonderwuenscheFliesen = kunde.getSonderwuenscheFliesen();

		for (SonderwuenscheHeizung wunsch: sonderwuenscheHeizung
		) {
			if(wunsch == null) continue;
			if(wunsch.getId() == 4){
				this.hasHeizungOhneDg = true;
			}
			if(wunsch.getId() == 5){
				this.hasHeizungMitDg = true;
			}
		}

		for (SonderwuenscheFliesen wunsch: sonderwuenscheFliesen
		) {
			if(wunsch.getId() == 1){
				this.hasKeineFliesenKuecheEg = true;
			}
			if(wunsch.getId() == 5){
				this.hasFliesenBadDG = true;
			}
		}

	}

	public boolean check8185(){
		return this.hasHeizungMitDg || this.hasHeizungOhneDg;
	}

	public boolean check82(){
		return this.hasKeineFliesenKuecheEg && !this.hasHeizungOhneDg && !this.hasHeizungMitDg;
	}

	public boolean check84(){
		return this.hasKeineFliesenKuecheEg;
	}

	public boolean check87(){
		if(this.hasDg && !this.hasFliesenBadDG && !hasHeizungMitDg){
			return true;
		}
		return false;
	}

	public boolean check88(){
		if(this.hasDg && !hasHeizungMitDg){
			return true;
		}
		return false;
	}

	public boolean check89(){
		if(this.hasDg && !hasFliesenBadDG){
			return true;
		}
		return false;
	}

	public boolean getAuswahl() {
		return _auswahl;
	}
	
	public void resetPreis() {
		_preis = 0;
	}
	
	public void resetAuswahl(){
		_auswahl = true ;
	}
}
