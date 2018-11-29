package Gui.Grundriss;
/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

    // das View-Objekt des Grundriss-Fensters
    private GrundrissView grundrissView;
    private GrundrissModel grundrissModel;
    //vorrübergehend :
    private int hausnummer = 5;


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
		this.grundrissModel.checkAuswahl(ausgewaehlteSw, hausnummer);
		return this.grundrissModel.getAuswahl();
	}
	
    public void zeigePreisSonderwuensche(int[] auswahl) {
		this.grundrissModel.gesamtpreisBerechnen(auswahl);
		this.grundrissView.getTxtGesamtpreis().setText(""+grundrissModel.getPreis());
		this.grundrissModel.resetPreis();
	}
    public void zeigeFehlerSonderwunsch () {
		this.grundrissView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
	}
}
