package Gui.FensterAussentueren;

public class FensterAussentuerenControl {

    // das View-Objekt des FensterAussentueren-Fensters
    private FensterAussentuerenView fensterAussentuerenView;
    private FensterAussentuerenModel fensterAussentuerenModel;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum FensterAussentueren-Fenster und
     * oeffnet das View.
     */
    public FensterAussentuerenControl(){

        this.fensterAussentuerenView = new FensterAussentuerenView(this);
        this.fensterAussentuerenModel = new FensterAussentuerenModel();
    }

    /**
     * macht das FensterAussentuerenView-Objekt sichtbar.
     */
    public void oeffneFensterAussentuerenView(){
        this.fensterAussentuerenView.setVisible(true);
    }

    public void leseFensterAussentuerenSonderwuensche(){
    }
    public void zeigePreisSonderwuensche(int[] auswahl) {
        this.fensterAussentuerenModel.gesamtpreisBerechnen(auswahl);
        this.fensterAussentuerenView.getTxtGesamtpreis().setText(""+fensterAussentuerenModel.getPreis());
        this.fensterAussentuerenModel.resetPreis();
    }

    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
        return true;
    }
}
