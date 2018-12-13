package Gui.Grundriss;

import Business.KundeModel;
import HibernateCont.SonderwuenscheGrundriss;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

    // das View-Objekt des Grundriss-Fensters
    private GrundrissView grundrissView;
    private GrundrissModel grundrissModel;
    //vorrübergehend :
    private int hausnummer;
    KundeModel kunde;
    private Set<SonderwuenscheGrundriss> wuensche = new HashSet();


    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundriss-Fenster und
     * oeffnet das View.
     */
    public GrundrissControl(){
        this.grundrissView = new GrundrissView(this);
        this.grundrissModel = new GrundrissModel();
        this.kunde = KundeModel.getInstance();
        this.hausnummer = kunde.getKunde().getHausnummer().getHausnummer();
    }

    /**
     * macht das GrundrissView-Objekt sichtbar.
     */
    public void oeffneGrundrissView(){
        this.grundrissView.setVisible(true);
    }

    public void leseGrundrissSonderwuensche(){
    }

  
    public boolean pruefeKonstellationSonderwuensche(double[] ausgewaehlteSw){
		this.grundrissModel.checkAuswahl(ausgewaehlteSw, hausnummer);
		return this.grundrissModel.getAuswahl();
	}
	
    public void zeigePreisSonderwuensche(double[] auswahl) {
		this.grundrissModel.gesamtpreisBerechnen(auswahl);
		this.grundrissView.getTxtGesamtpreis().setText(""+grundrissModel.getPreis());
		this.grundrissModel.resetPreis();
	}
    public void zeigeFehlerSonderwunsch () {
		this.grundrissView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
	        this.grundrissModel.resetAuswahl();
	}

    public Set<SonderwuenscheGrundriss> getWuensche() {
        return this.wuensche;
    }

    public void addWunsch(SonderwuenscheGrundriss wunsch) {
        this.wuensche.add(wunsch);
    }
}
