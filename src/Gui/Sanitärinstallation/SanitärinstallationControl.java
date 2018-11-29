package Gui.Sanitärinstallation;

public final class SanitärinstallationControl {
    private SanitärinstallationView sanitärinstallationView;



    public SanitärinstallationControl() { this.sanitärinstallationView = new SanitärinstallationView(this);}

    public void oeffneSanitärinstallationView(){this.sanitärinstallationView.setVisible(true);}

    public void leseSanitärinstallationSonderwuensche(){}

    public boolean pruefeKonstellationSonderwuensche(int [] ausgewaehlteSw) { return true;}
}
