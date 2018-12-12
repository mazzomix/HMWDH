package Gui.Fliesen;

public class FliesenControl {

    // das View-Objekt des Fliesen-Fensters
    private FliesenView fliesenView;
    private FliesenModel fliesenModel;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Fliesen-Fenster und
     * oeffnet das View.
     */
    public FliesenControl(){

        this.fliesenView = new FliesenView(this);
        this.fliesenModel = new FliesenModel();
    }

    /**
     * macht das FliesenView-Objekt sichtbar.
     */
    public void oeffneFliesenView(){
        this.fliesenView.setVisible(true);
    }

    public void leseFliesenSonderwuensche(){
    }
    public void zeigePreisSonderwuensche(int[] auswahl) {
        this.fliesenModel.gesamtpreisBerechnen(auswahl);
        this.fliesenView.getTxtGesamtpreis().setText(""+fliesenModel.getPreis());
        this.fliesenModel.resetPreis();
    }

    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
        return true;
    }
}
