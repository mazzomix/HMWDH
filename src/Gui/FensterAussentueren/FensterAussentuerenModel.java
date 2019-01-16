package Gui.FensterAussentueren;

import Business.KundeModel;

public class FensterAussentuerenModel {
    private double _preis = 0;
    private boolean _auswahl;
    private KundeModel kunde = KundeModel.getInstance();


    public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i];
        }

    }
    public double getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }

    public void checkAuswahl(double[] auswahl) {

        if(auswahl[1] != 0 && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1)) {
            this._auswahl = false;
        }
        if(auswahl[6] != 0 && auswahl[3]==0){
            this._auswahl = false;
        }
        if(auswahl[7] != 0 && auswahl[4] == 0){
            this._auswahl = false;
        }
        if (auswahl[8] != 0 && auswahl[5] == 0) {
            this._auswahl = false;
        }


    }

    public boolean getAuswahl(){
        return  _auswahl;
    }

    public void resetAuswahl(){
        this._auswahl = true;
    }
}
