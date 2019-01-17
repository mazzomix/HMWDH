package Gui.Grundriss;


import Business.KundeModel;

public class GrundrissModel  {
	private int _preis = 0;
	private boolean _auswahl = true;
	private KundeModel kunde = KundeModel.getInstance();
	
	public void gesamtpreisBerechnen (double[] preise) {
		for(int i = 0; i<preise.length; i++) {
			this._preis += preise[i]; 
		}
		
	}
	
	public int getPreis() {
		return _preis;
	}
	
	public void checkAuswahl(double[] auswahl) {
		
		//2.2 geht nur wenn 2.1 auch ausgesucht wurde
		//2.4 geht nur , wenn DG vorhanden ist. Standardgemäß ist die Treppe von dem Raum im DG nur durch eine Brüstung getrennt.
		//2.5 genut nur, wenn DG vorhanden ist.Die Vorrichtung eines Bades beinhaltet die Verlegung von Leitungen für Warmwasser, Kaltwasser und Abwasser.
		//2.6 get nur, wenn DG vorhanden ist und 2.5 ausgesucht wurde. Die Ausführung eines Bades beinhaltet den Erbau einer Dusche, eines WC’s und eines Waschbeckens.
	
		if(auswahl[1]!=0 && auswahl[0] == 0) {
			this._auswahl = false;
		}
		if(auswahl[3] != 0 && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1)) {
			this._auswahl = false;
		}
		if(auswahl[4] != 0 && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1)){
			this._auswahl = false;
		}
		if(auswahl[5]!= 0 && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1 || auswahl[4] == 0)) {
			this._auswahl = false;
		}
		
		
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
