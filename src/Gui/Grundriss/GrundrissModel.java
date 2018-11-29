package gui.grundriss;


public class GrundrissModel  {
	private int _preis = 0;
	private boolean _auswahl; 
	
	public void gesamtpreisBerechnen (int[] preise) { 
		for(int i = 0; i<preise.length; i++) {
			this._preis += preise[i]; 
		}
		
	}
	
	public int getPreis() {
		return _preis;
	}
	
	public void checkAuswahl(int[] auswahl) {
		//2.2 geht nur wenn 2.1 auch ausgesucht wurde
		//2.4 geht nur , wenn DG vorhanden ist. Standardgem�� ist die Treppe von dem Raum im DG nur durch eine Br�stung getrennt.
		//2.5 genut nur, wenn DG vorhanden ist.Die Vorrichtung eines Bades beinhaltet die Verlegung von Leitungen f�r Warmwasser, Kaltwasser und Abwasser.
		//2.6 get nur, wenn DG vorhanden ist und 2.5 ausgesucht wurde. Die Ausf�hrung eines Bades beinhaltet den Erbau einer Dusche, eines WC�s und eines Waschbeckens.
		this._auswahl = true;
	}
	public boolean getAuswahl() {
		return _auswahl;
	}
	
	public void resetPreis() {
		_preis = 0;
	}
}
