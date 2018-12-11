package Gui.Basis;

import HibernateCont.Hausnummer;
import HibernateCont.HibernateUtil;
import HibernateCont.Kunde;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;

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

    public int speichereKunden (Kunde kunde, int hausnummer_id) {
        int kundennummer = 0;
        // Session erstellen und Transaction beginnen
        Session session = factory.openSession();
        session.beginTransaction();

        Hausnummer hausnummer = session.load(Hausnummer.class, hausnummer_id);
        kunde.setHausnummer(hausnummer);

        // Speichere die änderungen
        session.save(kunde);
        kundennummer = kunde.getId();
        // Änderungen in die Datenbank schreiben
        try{
            session.getTransaction().commit();
        } catch (PersistenceException p){
            throw p;
        }

        session.close();

        return kundennummer;
    }

    public Kunde holeKunde(int id) {
        Kunde kunde = null;
        int hausnr = 0;
        Session session = factory.openSession();
        session.beginTransaction();
        hausnr = session.load(Hausnummer.class, id).getHausnummer();

        String hql = "from Kunde as kunde where kunde.hausnummer.hausnummer=" + hausnr;
        Query query = session.createQuery(hql);
        try {
            kunde = (Kunde) query.list().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }


        session.close();

        return kunde;
    }

    public boolean hasDachgeschoss(int id) {
        Hausnummer hausnummer = null;
        boolean hasDg = false;
        Session session = factory.openSession();
        session.beginTransaction();

        hausnummer = session.load(Hausnummer.class, id);

        if(hausnummer.getHaustyp().getDachgeschoss() == 1){
            hasDg = true;
        }

        session.close();

        return hasDg;
    }
}
