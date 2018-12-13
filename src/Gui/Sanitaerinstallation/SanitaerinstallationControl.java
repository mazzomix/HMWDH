package Gui.Sanitaerinstallation;


public final class SanitaerinstallationControl {


    private SanitaerinstallationView sanitaerinstallationView;
    private SanitaerinstallationModel sanitaerinstallationModel;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Innentueren-Fenster und
     * oeffnet das View.
     */

    public SanitaerinstallationControl() {

        this.sanitaerinstallationView = new SanitaerinstallationView(this);
        this.sanitaerinstallationModel = new SanitaerinstallationModel();
    }


    public void oeffneSanitärinstallationView(){
        this.sanitaerinstallationView.setVisible(true);
    }

    public void leseSanitaerinstallationSonderwuensche(){}



    public boolean pruefeKonstellationSonderwuensche(int [] auswahl) {
        return this.sanitaerinstallationModel.getAuswahl();
    }

    public void zeigePreisSonderwuensche(int[] auswahl) {
        this.sanitaerinstallationModel.gesamtpreisBerechnen(auswahl);
        this.sanitaerinstallationView.getTxtGesamtpreis().setText("" + sanitaerinstallationModel.getPreis());
        this.sanitaerinstallationModel.resetPreis();
    }


    public void zeigeFehlerSonderwunsch() {
        this.sanitaerinstallationView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.sanitaerinstallationModel.resetAuswahl();
    }



}
