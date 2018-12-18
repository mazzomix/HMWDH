package Gui.Innentueren;

public class InnentuerenModel {

    private int preis = 0;
    private boolean auswahl;
    private int anzahl;

    public boolean getAuswahl() {
        return auswahl;
    }

    public void resetAuswahl() {
        auswahl = true;
    }

    public void gesamtpreisBerechnen(double[] preise, int[] anzahle) {
        for (int i = 0; i < preise.length; i++) {
            this.preis += preise[i] * (this.anzahl += anzahle[i]);
            this.anzahl = 0;
        }
    }

    public void resetPreis() {
        preis = 0;
        anzahl = 0;

    }

    public int getPreis() {
        return preis;
    }

    public int getAnzahl() {
        return anzahl;
    }
}