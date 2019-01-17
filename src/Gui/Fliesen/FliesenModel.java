package Gui.Fliesen;

import Business.KundeModel;
import HibernateCont.SonderwuenscheGrundriss;
import java.util.Set;

public class FliesenModel {
    private int _preis = 0;
    private boolean _auswahl = true;
    private KundeModel kunde = KundeModel.getInstance();
    Set<SonderwuenscheGrundriss> grundriss;


    public void gesamtpreisBerechnen (double[] preise) {
        for(int i = 0; i<preise.length; i++) {
            this._preis += preise[i];
        }

    }
    public boolean getAuswahl() {
        return _auswahl;
    }

    public void checkAuswahl(double[] auswahl, KundeModel kunde) {
     grundriss = kunde.getKunde().getSonderwuenscheGrundriss();
     boolean wunschGrundriss = false;
     for(SonderwuenscheGrundriss g : grundriss){
         if(g.getWunsch().contains("Ausführung eines Bades im DG")){
             wunschGrundriss = true;
             break;
         }
     }

     if(auswahl[2] != 0 && auswahl[0] != 0){
         this._auswahl = false;
     }
     if(auswahl[3] != 0 && auswahl[1] != 0){
         this._auswahl = false;
     }
     if(auswahl[4] != 0 && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1 || wunschGrundriss == false)) {
         this._auswahl = false;
     }
     if(auswahl[5] != 0 && auswahl[4] ==0 ){
         this._auswahl = false;
     }


    }

    public int getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }

    public  void resetAuswahl(){
        _auswahl = true;
    }
}
