package Gui.Grundriss;
/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

    // das View-Objekt des Grundriss-Fensters
    private GrundrissView grundrissView;
    private GrundrissModel grundrissModel;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundriss-Fenster und
     * oeffnet das View.
     */
    public GrundrissControl(){
        this.grundrissView = new GrundrissView(this);
        this.grundrissModel = new GrundrissModel();
    }

    /**
     * macht das GrundrissView-Objekt sichtbar.
     */
    public void oeffneGrundrissView(){
        this.grundrissView.setVisible(true);
    }

    public void leseGrundrissSonderwuensche(){
    }

    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
        return true;
    }
    
    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		grundrissModel.checkAuswahl(ausgewaehlteSw);
		return this.grundrissModel.getAuswahl();
	}
	
	public void zeigePreisSonderwuensche(int[] auswahl) {
		grundrissModel.gesamtpreisBerechnen(auswahl);
		this.grundrissView.getTxtGesamtpreis().setText(""+grundrissModel.getPreis());
		grundrissModel.resetPreis();
	}
}
