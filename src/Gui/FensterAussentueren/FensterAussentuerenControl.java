package Gui.FensterAussentueren;

public class FensterAussentuerenControl {

    // das View-Objekt des FensterAussentueren-Fensters
    private FensterAussentuerenView fensterAussentuerenView;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum FensterAussentueren-Fenster und
     * oeffnet das View.
     */
    public FensterAussentuerenControl(){
        this.fensterAussentuerenView = new FensterAussentuerenView(this);
    }

    /**
     * macht das FensterAussentuerenView-Objekt sichtbar.
     */
    public void oeffneFensterAussentuerenView(){
        this.fensterAussentuerenView.setVisible(true);
    }

    public void leseFensterAussentuerenSonderwuensche(){
    }

    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
        return true;
    }
}
