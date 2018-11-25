package Gui.Kunde;

import Business.Kunde.Kunde;
import Business.Kunde.KundeModel;
import Gui.Grundriss.GrundrissControl;
import javax.swing.JOptionPane;
public class KundeControl {

    // das View-Objekt des Grundfensters
    private KundeView kundeView;
    // das Model-Objekt des Grundfensters
    private KundeModel kundeModel;
    // das GrundrissControl-Objekt zum Kunden
    private GrundrissControl grundrissControl;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundfenster und
     * oeffnet das View.
     */
    public KundeControl() {
        this.kundeModel = KundeModel.getInstance();
        this.kundeView = new KundeView(this, kundeModel);
    }

    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das View wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
        if (this.grundrissControl == null){
            this.grundrissControl = new GrundrissControl(kundeModel);
        }
        this.grundrissControl.oeffneGrundrissView();
    }

    public void speichereKunden(Kunde kunde){
        try{
            kundeModel.speichereKunden(kunde);
        }
        catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this.kundeView,
                    "DB-Fehler: Der Kunde konnte nicht gespeichert werden.");
        }
    }

}
