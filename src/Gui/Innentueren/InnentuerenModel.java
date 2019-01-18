package Gui.Innentueren;

import Business.KundeModel;
import HibernateCont.Kunde;
import HibernateCont.SonderwuenscheGrundriss;
import HibernateCont.SonderwuenscheInnentueren;

import java.util.List;
import java.util.Set;

public class InnentuerenModel {

    private int preis = 0;
    private boolean auswahl = true;
    private int anzahl;
    private Kunde kunde = KundeModel.getInstance().getKunde();
    private boolean hasDg = kunde.getHausnummer().getHaustyp().getDachgeschoss() == 0 ? false : true;
    private boolean hasGrossesZimmerOG = false;
    private boolean hasAbgetrenntenTreppenraum = false;
    private boolean hasAusfuehrungBad = false;
    public int anzTueren = 0;

    public boolean getAuswahl() {
        return auswahl;
    }

    public void resetAuswahl() {
        auswahl = true;
    }

    public void initializeData(){
        Set<SonderwuenscheGrundriss> sonderwuenscheGrundrisses = kunde.getSonderwuenscheGrundriss();
        // Keller
        if(hasDg){
            this.anzTueren += 1;
        } else{
            this.anzTueren += 2;
        }

        //EG
        for (SonderwuenscheGrundriss wunsch : sonderwuenscheGrundrisses
             ) {
            if(wunsch.getId() == 2){
                this.anzTueren += 1;
            }
            if(wunsch.getId() == 3){
                hasGrossesZimmerOG = true;
            }
            if(wunsch.getId() == 4){
                hasAbgetrenntenTreppenraum = true;
            }
            if(wunsch.getId() == 6){
                hasAusfuehrungBad = true;
            }
        }

        //OG
        if(hasGrossesZimmerOG){
            this.anzTueren += 3;
        } else{
            this.anzTueren += 4;
        }

        //DG
        if(hasAbgetrenntenTreppenraum && hasAusfuehrungBad){
            this.anzTueren +=2;
        }
        if(hasDg && (hasAbgetrenntenTreppenraum ||hasAusfuehrungBad)){
            this.anzTueren += 1;
        }
    }

    public boolean check41(int anzDoors){
        if(anzDoors < 1 || anzDoors > anzTueren){
            return false;
        }
        return true;
    }

    public boolean check42(int anzDoors){
        return this.check41(anzDoors);
    }

    public boolean check43(){
        if(hasDg){
            return true;
        }
        return false;
    }

    public void gesamtpreisBerechnen(List<SonderwuenscheInnentueren> wuensche) {
    	for(SonderwuenscheInnentueren wunsch: wuensche){
    	    this.preis += wunsch.getPreis();
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
