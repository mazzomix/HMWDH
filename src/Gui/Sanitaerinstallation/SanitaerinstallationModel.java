package Gui.Sanitaerinstallation;

public class SanitaerinstallationModel {

        private int preis = 0;
        private boolean auswahl;


      public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this.preis += preise[i];
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

