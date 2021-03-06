package Gui.Kunde;

import Gui.Aussenanlage.AussenanlageControl;
import Gui.Fliesen.FliesenControl;
import Gui.Grundriss.GrundrissControl;
import Gui.FensterAussentueren.FensterAussentuerenControl;
import Gui.Heizung.HeizungControl;
import Gui.Innentueren.InnentuerenControl;
import Gui.Parkett.ParkettControl;
import Gui.Sanitaerinstallation.SanitaerinstallationControl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class KundeControl {

    // das View-Objekt des Grundfensters
    private KundeView kundeView;
    // das GrundrissControl-Objekt zum Kunden
    private GrundrissControl grundrissControl;
    private FensterAussentuerenControl fensterAussentuerenControl;
    private SanitaerinstallationControl sanitärinstallationControl;
    private InnentuerenControl innentuerenControl;
    private AussenanlageControl aussenanlageControl;
    private ParkettControl parkettControl;
    private FliesenControl fliesenControl;
    private HeizungControl heizungControl;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundfenster und
     * oeffnet das View.
     */
    public KundeControl() {
        this.kundeView = new KundeView(this);
    }

    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das View wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
        if (this.grundrissControl == null){
            this.grundrissControl = new GrundrissControl();
        }
        this.grundrissControl.oeffneGrundrissView();
    }
    public void oeffneFensterAussentuerenControl() {
        if (this.fensterAussentuerenControl == null) {
            this.fensterAussentuerenControl = new FensterAussentuerenControl();
        }
        this.fensterAussentuerenControl.oeffneFensterAussentuerenView();
    }
    public void oeffneSanitärinstallationControl(){
        if(this.sanitärinstallationControl == null){
            this.sanitärinstallationControl = new SanitaerinstallationControl();
        }
        this.sanitärinstallationControl.oeffneSanitärinstallationView();
    }
    public void oeffneInnentuerenControl() {
        if (this.innentuerenControl == null) {
            this.innentuerenControl = new InnentuerenControl();
        }
        this.innentuerenControl.oeffneInnentuerenView();
    }
    public void oeffneAussenanlageControl() {
        if (this.aussenanlageControl == null) {
            this.aussenanlageControl = new AussenanlageControl();
        }
        this.aussenanlageControl.oeffneAussenanlageView();
    }

    public void oeffneParkettControl() {
        if (this.parkettControl == null) {
            this.parkettControl = new ParkettControl();
        }
        this.parkettControl.oeffneParkettView();
    }
    public void oeffneFliesenControl() {
        if (this.fliesenControl == null) {
            this.fliesenControl = new FliesenControl();
        }
        this.fliesenControl.oeffneFliesenView();
    }
    public void oeffneHeizungControl() {
        if (this.heizungControl == null) {
            this.heizungControl = new HeizungControl();
        }
        this.heizungControl.oeffneHeizungView();
    }
}
