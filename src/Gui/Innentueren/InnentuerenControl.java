package Gui.Innentueren;

public class InnentuerenControl {

    // das View-Objekt des Grundriss-Fensters TESTZWECK
    private InnentuerenView innentuerenView;
    private InnentuerenModel innentuerenModel;
    private int hausnummer = 5;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Innentueren-Fenster und
     * oeffnet das View.
     */
    public InnentuerenControl() {
        this.innentuerenView = new InnentuerenView(this);
        this.innentuerenModel = new InnentuerenModel();
    }

    public void oeffneInnentuerenView() {
        this.innentuerenView.setVisible(true);
    }

    public void leseInnentuerenSonderwuensche() {
    }

    public boolean pruefeKonstellationSonderwuensche(int[] auswahl) {
        return this.innentuerenModel.getAuswahl();
    }

    public void zeigePreisSonderwuensche(int[] auswahl, int[] anzahl) {
        this.innentuerenModel.gesamtpreisBerechnen(auswahl, anzahl);
        this.innentuerenView.getTxtGesamtpreis().setText("" + innentuerenModel.getPreis());
        this.innentuerenModel.resetPreis();
    }

    public void zeigeFehlerSonderwunsch() {
        this.innentuerenView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.innentuerenModel.resetAuswahl();
    }
}
