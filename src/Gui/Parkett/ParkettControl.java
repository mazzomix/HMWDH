package Gui.Parkett;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class ParkettControl {

    // das View-Objekt des Grundriss-Fensters
    private ParkettView parkettView;
    private ParkettModel parkettModel;
    //vorrübergehend :
    private int hausnummer = 5;


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

  
    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		this.parkettModel.checkAuswahl(ausgewaehlteSw, hausnummer);
		return this.parkettModel.getAuswahl();
	}
	
    public void zeigePreisSonderwuensche(int[] auswahl) {
		this.parkettModel.gesamtpreisBerechnen(auswahl);
		this.parkettView.getTxtGesamtpreis().setText(""+ parkettModel.getPreis());
		this.parkettModel.resetPreis();
	}
    public void zeigeFehlerSonderwunsch () {
		this.parkettView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
	        this.parkettModel.resetAuswahl();
	}
}
