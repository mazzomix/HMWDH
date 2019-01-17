package Gui.Aussenanlage;

import Business.KundeModel;

public class AussenanlageModel {
    private double _preis = 0;
    private boolean _auswahl = true;
    private KundeModel kunde = KundeModel.getInstance();

    public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i];
        }

    }

    public void checkAuswahl(double[] auswahl) {

        if(auswahl[2] !=0 && kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1){
            this._auswahl = false;
        }
        if (auswahl[3] != 0 && auswahl[1] == 0){
            this._auswahl= false;
        }
        if(auswahl[4]!= 0 && ((kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1) || auswahl[2] == 0)) {
            this._auswahl = false;
        }
        if(auswahl[5] != 0 && kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1){
            this._auswahl = false;
        }
        if(auswahl[6] != 0 && ((kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1) || auswahl[5] == 0)){
            this._auswahl = false;
        }


    }

    public boolean getAuswahl(){
        return  _auswahl;
    }

    public double getPreis() {
        return _preis;
    }

    public void resetPreis() {
        _preis = 0;
    }

    public  void resetAuswahl(){
        _auswahl = true;
    }


}

