package Gui.Parkett;

import HibernateCont.SonderwuenscheParkett;

import java.util.*;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class ParkettControl {

    // das View-Objekt des Grundriss-Fensters
    private ParkettView parkettView;
    private ParkettModel parkettModel;
    private List<SonderwuenscheParkett> wuensche = new ArrayList();
    private Set<SonderwuenscheParkett> ausgewaehlteWuensche = new HashSet<>();


    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundriss-Fenster und
     * oeffnet das View.
     */
    public ParkettControl(){
        this.parkettView = new ParkettView(this);
        this.parkettModel = new ParkettModel();
    }

    /**
     * macht das ParkettView-Objekt sichtbar.
     */
    public void oeffneParkettView(){
        this.parkettView.setVisible(true);
    }

    public void leseParkettSonderwuensche(){
    }

  
    public boolean pruefeKonstellationSonderwuensche(double[] ausgewaehlteSw){
		this.parkettModel.checkAuswahl(ausgewaehlteSw);
		return this.parkettModel.getAuswahl();
	}
	
    public void zeigePreisSonderwuensche(double[] auswahl) {
		this.parkettModel.gesamtpreisBerechnen(auswahl);
		this.parkettView.getTxtGesamtpreis().setText(""+ parkettModel.getPreis());
		this.parkettModel.resetPreis();
	}
    public void zeigeFehlerSonderwunsch () {
		this.parkettView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
	        this.parkettModel.resetAuswahl();
	}

    public List<SonderwuenscheParkett> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheParkett> wuensche) {
        this.wuensche = wuensche;
    }

    public Set<SonderwuenscheParkett> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheParkett ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheParkett> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheParkett> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheParkett element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }
}
