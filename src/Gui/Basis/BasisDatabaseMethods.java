package Gui.Basis;

import HibernateCont.Hausnummer;
import HibernateCont.Haustyp;
import HibernateCont.HibernateUtil;
import HibernateCont.Kunde;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BasisDatabaseMethods {

    private SessionFactory factory;
    private static BasisDatabaseMethods instance;

    private BasisDatabaseMethods() {
        factory = null;
        // Erzeuge SessionFactory
        try {
            factory = HibernateUtil.createSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(factory == null) {
            return;
        }
    }

    public static synchronized  BasisDatabaseMethods getInstance () {
        if (BasisDatabaseMethods.instance == null) {
            BasisDatabaseMethods.instance = new BasisDatabaseMethods ();
        }
        return BasisDatabaseMethods.instance;
    }

    public void speichereKunden (Kunde kunde, int hausnummer_id) {
        // Session erstellen und Transaction beginnen
        Session session = factory.openSession();
        session.beginTransaction();

        Hausnummer hausnummer = session.load(Hausnummer.class, hausnummer_id);
        hausnummer.getHaustyp();
        kunde.setHausnummer(hausnummer);

        // Speichere die änderungen
        session.save(kunde);

        // Änderungen in die Datenbank schreiben
        session.getTransaction().commit();
        session.close();

    }

    public Kunde holeKunde(int id) {
        Kunde kunde = null;
        Session session = factory.openSession();
        session.beginTransaction();

        kunde = session.load(Kunde.class, id);

        session.close();

        return kunde;
    }

    public int verfuegbareKunden() {
        Session session = factory.openSession();
        session.beginTransaction();

        session.close();

        return 0;
    }
}
