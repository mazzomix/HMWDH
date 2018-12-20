package Gui.Aussenanlage;

import Business.KundeModel;

public class AussenanlageModel {
    private int _preis = 0;
    private boolean _auswahl = true;
    private KundeModel kunde = KundeModel.getInstance();

    public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i];
        }

    }

    public int getPreis() {
        return _preis;
    }



}
