package Gui.Innentueren;

import Business.KundeModel;
import HibernateCont.SonderwuenscheGrundriss;

import java.util.Set;

public class InnentuerenModel {

    private int preis = 0;
    private boolean auswahl = true;
    private int anzahl;
    public int anzkeller = 2;
    public int anzeg = 0;
    public int anzog = 4;
    public int anzdg = 0;


    private KundeModel kunde = KundeModel.getInstance();
    Set<SonderwuenscheGrundriss> grundriss;

    public boolean getAuswahl() {
        return auswahl;
    }

    public void resetAuswahl() {
        auswahl = true;
    }

    public void checkAuswahl(double[] auswahl, KundeModel kunde) {

        // Bedingungen
        /*
        A11 -   Der Kundenberater möchte innerhalb von A10 eine Prüfung haben, welche sicherstellt, dass die Kombination der Sonderwünsche möglich ist.
                Hierbei ist explizit zu beachten, dass aus /F40/ für 4.1 eine Anzahl x Türen zwischen 1 und max. Anzahl gewählt werden muss.
                Für 4.2 muss eine Anzahl Türen y zwischen 1 und max. liegen. Zu beachten ist hierbei das Anzahl x + y kleiner gleich max. sein muss.
                Die Anzahl der Türen ist gesondert definiert.
                Funktion 4.3 kann nur ausgewählt werden, wenn ein DG vorhanden ist. Der Gesamtpreis wird nach jeder Auswahl berechnet werden falls die Prüfung positiv verläuft.
                Außerdem wird der Gesamtpreis danach angezeigt. Verläuft eine Prüfung negativ, wird eine entsprechende Fehlermeldung ausgegeben.
         */

        grundriss = kunde.getKunde().getSonderwuenscheGrundriss();

        for (SonderwuenscheGrundriss sg : grundriss) {

            if (sg.getWunsch().contains("Tür in der Wand zwischen Küche und Essbereich")) {

                anzeg = 1;
                break;
            }
            if (sg.getWunsch().contains("Großes Zimmer im OG statt zwei kleinen Zimmern")) {

                anzog = 3;
                break;
            }
            if ((sg.getWunsch().contains("Abgetrennter Treppenraum im DG")) && (sg.getWunsch().contains("Ausführung eines Bades im DG")) && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() == 1)) {

                anzdg = 2;
                break;
            }
            if ((sg.getWunsch().contains("Abgetrennter Treppenraum im DG")) || (sg.getWunsch().contains("Ausführung eines Bades im DG")) && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() == 1)) {

                anzdg = 1;
                break;
            }
            if ((kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() != 1) || ((!sg.getWunsch().contains("Abgetrennter Treppenraum im DG")) && (!sg.getWunsch().contains("Ausführung eines Bades im DG")) && (kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() == 1))) {

                anzdg = 0;
                break;
            }

        }
        if(kunde.getKunde().getHausnummer().getHaustyp().getDachgeschoss() == 1)
        {
            anzkeller = 1 ;
        }
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
    public int getAnzkeller() {
        return anzkeller;
    }
    protected int getAnzeg() {
        return anzeg;
    }
    public int getAnzog() {
        return anzog;
    }
    public int getAnzdg() {
        return anzdg;
    }
}
