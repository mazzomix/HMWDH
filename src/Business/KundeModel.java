package Business;

import HibernateCont.Kunde;

import java.sql.SQLException;

/**
 * Klasse, welche das Model des Grundfensters mit den Kundendaten enthaelt.
 */
public final class KundeModel {

    // enthaelt den aktuellen Kunden
    private Kunde kunde;

    // enthaelt das einzige KundeModel-Objekt
    private static KundeModel kundeModel;

    // privater Konstruktor zur Realisierung des Singleton-Pattern
    private KundeModel(){
        super();
    }

    /**
     *  Methode zum Erhalt des einzigen KundeModel-Objekts.
     *  Das Singleton-Pattern wird realisiert.
     *  @return KundeModel, welches das einzige Objekt dieses
     *          Typs ist.
     */
    public static KundeModel getInstance(){
        if(kundeModel == null){
            kundeModel = new KundeModel();
        }
        return kundeModel;
    }

    public Kunde getKunde(){
        return this.kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}