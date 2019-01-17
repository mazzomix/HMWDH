package Gui.Grundriss;

import Business.KundeModel;
import HibernateCont.SonderwuenscheGrundriss;

import java.util.*;

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
    private List<SonderwuenscheGrundriss> wuensche = new ArrayList();
    private Set<SonderwuenscheGrundriss> ausgewaehlteWuensche = new HashSet<>();


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
		this.grundrissModel.checkAuswahl(ausgewaehlteSw);
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

    public void addWunsch(SonderwuenscheGrundriss wunsch) {
        this.wuensche.add(wunsch);
    }

    public Set<SonderwuenscheGrundriss> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheGrundriss> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheGrundriss ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public List<SonderwuenscheGrundriss> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheGrundriss> wuensche) {
        this.wuensche = wuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheGrundriss> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheGrundriss element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }
}
