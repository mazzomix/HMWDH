package Gui.Grundriss;
import Business.Kunde.KundeModel;
/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

    // das View-Objekt des Grundriss-Fensters
    private GrundrissView grundrissView;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundriss-Fenster und
     * oeffnet das View.
     */
    public GrundrissControl(KundeModel kundeModel){
        this.grundrissView = new GrundrissView(this, kundeModel);
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
}
