package Gui.Heizung;

public class HeizungModel {
    private int _preis = 0;
    public void gesamtpreisBerechnen (double[] preise, int[] stueck) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i]*stueck[i];
        }

    }
    public int getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }
}
