package Gui.Sanitaerinstallation;

import Business.KundeModel;

public class SanitaerinstallationModel {

        private int preis = 0;
        private boolean auswahl = true;
        private KundeModel kunde = KundeModel.getInstance();

      public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this.preis += preise[i];
        }

       }

    public void checkAuswahl(double[] auswahl) {

        if(auswahl[1] != 0 && kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1){
            this.auswahl = false;
        }
        if(auswahl[2] != 0 && auswahl[0] != 0){
            this.auswahl = false;
        }
        if(auswahl[3] != 0 && (auswahl[1] != 0 || kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1)){
            this.auswahl = false;
        }

    }


    public boolean getAuswahl() {
        return auswahl;
    }

    public void resetAuswahl() {
        auswahl = true;
    }

    public int getPreis() {
        return preis;
    }

    public void resetPreis() { preis = 0;}

}
