package Gui.Heizung;

public class HeizungModel {
    private int _preis = 0;
    public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i];
        }

    }
    public int getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }
}
