package Gui.Sanitärinstallation;

import Gui.Basis.BasisView;

public final class SanitärinstallationControl {
    private SanitärinstallationView sanitärinstallationView;
    private double preis;



    public SanitärinstallationControl() { this.sanitärinstallationView = new SanitärinstallationView(this);}

    public void oeffneSanitärinstallationView(){this.sanitärinstallationView.setVisible(true);}

    public void leseSanitärinstallationSonderwuensche(){}

    public boolean pruefeKonstellationSonderwuensche(int [] ausgewaehlteSw) { return true;}

    public double berechnePreis(){
        preis = 0;
        if(sanitärinstallationView.chckBxOGGrößeresWaschbecken.isSelected() == true){
            preis += 160;
        }
        if(sanitärinstallationView.chckBxDGGrößeresWaschbecken.isSelected() == true){
            preis += 160;
        }
        if(sanitärinstallationView.chckBxOGBodentiefeDusche.isSelected() == true){
            preis += 560;
        }
        if(sanitärinstallationView.chckBxDGBodentiefeDusche.isSelected() == true){
            preis += 560;
        }
        return preis;
    }



}
