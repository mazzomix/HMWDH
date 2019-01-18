package Gui.Heizung;

import Business.KundeModel;
import HibernateCont.Kunde;
import HibernateCont.SonderwuenscheGrundriss;
import HibernateCont.SonderwuenscheHeizung;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HeizungModel {
    private double _preis = 0;
    private boolean _auswahl;
    private Kunde kunde = KundeModel.getInstance().getKunde();
    private boolean hasDG = this.kunde.getHausnummer().getHaustyp().getDachgeschoss() == 0 ? false : true;
    public void gesamtpreisBerechnen (List<SonderwuenscheHeizung> wuensche) {
        for (SonderwuenscheHeizung wunsch: wuensche
             ) {
            _preis += wunsch.getPreis();
        }

    }

    public int berechneVorhandeneHeizkoerper(){
        int heizkoerper = 0;
        boolean hasGrossesZimmer = false;
        boolean hasBadDG = false;
        Set<SonderwuenscheGrundriss> sonderwuenscheGrundriss = this.kunde.getSonderwuenscheGrundriss();
        // Keller
        if(this.hasDG){
            heizkoerper += 1;
            //DG
            heizkoerper+=2;
        } else {
            heizkoerper += 2;
        }
        // EG
        heizkoerper += 2;
        //OG
        for (SonderwuenscheGrundriss wunsch: sonderwuenscheGrundriss
             ) {
            if(wunsch.getId() == 3){
                hasGrossesZimmer = true;
            }
            if(wunsch.getId() == 6){
                hasBadDG = true;
            }
        }
        heizkoerper += hasGrossesZimmer ? 3 : 4;

        //DG
        if(this.hasDG && hasBadDG){
            heizkoerper += 3;
        }

        return heizkoerper;

    }

    public boolean checkHandtuchHeizung(int anzhHeizkoerper){
        if(this.hasDG){
            if (anzhHeizkoerper < 1 || anzhHeizkoerper > 2) return false;
        } else{
            if(anzhHeizkoerper != 1){
                return false;
            }
        }
        return true;
    }
    public double getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }
}
