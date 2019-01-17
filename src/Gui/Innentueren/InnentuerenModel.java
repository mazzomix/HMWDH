package Gui.Innentueren;

import Business.KundeModel;
import HibernateCont.SonderwuenscheGrundriss;

import java.util.Set;

public class InnentuerenModel {

    private int preis = 0;
    private boolean auswahl = true;
    private int anzahl;
    private int anzkeller = 2;
    private int anzeg = 0;
    private int anzog = 4;
    private int anzdg = 0;


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
        A14 - Der Kundenberater möchte innerhalb von A13 eine Prüfung haben, welche sicherstellt, dass die Kombination der Sonderwünsche möglich ist.
        Hierbei ist explizit zu beachten, dass aus /F50/ für 5.1 eine Anzahl x zusätzlicher Heizkörper zwischen 1 und 5 gewählt werden muss.
        Für 5.2 muss eine Anzahl Heizungen mit glatter Oberfläche z zwischen 1 und Anzahl vorhandener Heizkörper + den in 5.1 gewählten liegen. Die Anzahl der Heizkörper ist gesondert definiert.
        Funktion 5.3 kann nur zwischen 1 und 2 gewählt werden, und 2 auch nur wenn DG vorhanden und 2.6 ausgewählt.
        5.4 kann nur gewählt werden, wenn kein DG vorhanden ist, 5.5 wiederum nur wenn DG vorhanden. Der Gesamtpreis wird nach jeder Auswahl berechnet werden falls die Prüfung positiv verläuft.
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

    public void checkMaenge(int anzahl1, int anzahl2, int maxanzahl) {

        if((anzahl1+anzahl2)>maxanzahl)
        {
            this.auswahl = false;
        }
        if((anzahl1+anzahl2)<1)
        {
            this.auswahl = false;
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
    public int getAnzeg() {
        return anzeg;
    }
    public int getAnzog() {
        return anzog;
    }
    public int getAnzdg() {
        return anzdg;
    }
}
