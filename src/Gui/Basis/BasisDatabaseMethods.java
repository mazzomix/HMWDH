package Gui.Basis;

import HibernateCont.*;
import org.hibernate.*;
import org.hibernate.query.Query;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PersistenceException;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasisDatabaseMethods
{

    private SessionFactory factory;
    private static BasisDatabaseMethods instance;

    private BasisDatabaseMethods()
    {
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

    public static synchronized  BasisDatabaseMethods getInstance ()
    {
        if (BasisDatabaseMethods.instance == null) {
            BasisDatabaseMethods.instance = new BasisDatabaseMethods ();
        }
        return BasisDatabaseMethods.instance;
    }

    public int speichereKunden (Kunde kunde)
    {
        int kundennummer = 0;
        // Session erstellen und Transaction beginnen
        Session session = factory.openSession();
        session.beginTransaction();

        // Speichere die änderungen
        session.saveOrUpdate(kunde);
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

    public Kunde holeKunde(int hausnummer)
    {
        Kunde kunde = null;

        Session session = factory.openSession();

        try {
            String hql =    "select k " +
                            "from Kunde k " +
                            "where k.hausnummer.hausnummer=:hausnr";
            Query query = session.createQuery(hql, Kunde.class).setParameter("hausnr", hausnummer);

            kunde = (Kunde) query.list().get(0);

            if(!Hibernate.isInitialized(kunde.getHausnummer().getHaustyp())){
                Hibernate.initialize(kunde.getHausnummer().getHaustyp());
            }
            //init = Hibernate.isInitialized(kunde);

        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (ObjectNotFoundException e){
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return kunde;
    }

    public Hausnummer holeHausnummer(int hausnummer)
    {
        Hausnummer hausnummerObject = new Hausnummer();
        Session session = factory.openSession();

        String hql =    "select h " +
                "from Hausnummer h " +
                "where h.hausnummer=:hausnr";
        Query query = session.createQuery(hql, Hausnummer.class).setParameter("hausnr", hausnummer);

        hausnummerObject = (Hausnummer) query.list().get(0);

        if(!Hibernate.isInitialized(hausnummerObject.getHaustyp())){
            Hibernate.initialize(hausnummerObject.getHaustyp());
        }
        session.close();

        return hausnummerObject;
    }

    public boolean loescheKunde(Kunde kunde)
    {

        boolean deleted = true;
        Session session = factory.openSession();
        session.beginTransaction();

        String hql = "delete  " +
                "from Kunde k " +
                "where k.id= :kunde";
        Query query = session.createQuery(hql).setParameter("kunde", kunde.getId());
        query.executeUpdate();

        try{
            session.getTransaction().commit();
        } catch (PersistenceException p){
            deleted = false;
            throw p;
        } catch (Exception e){
            deleted = false;
        }

        session.close();
        return deleted;
    }

    public boolean hasDachgeschoss(int id)
    {
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

    public List<SonderwuenscheGrundriss> holeSonderwuenscheGrundriss()
    {
        List<SonderwuenscheGrundriss> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheGrundriss ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheFensterAussentueren> holeSonderwuenscheFensterAussentueren()
    {
        List<SonderwuenscheFensterAussentueren> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheFensterAussentueren ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheSanitaerinstallation> holeSonderwuenscheSanitaerinstallation()
    {
        List<SonderwuenscheSanitaerinstallation> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheSanitaerinstallation ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheInnentueren> holeSonderwuenscheInnentueren()
    {
        List<SonderwuenscheInnentueren> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheInnentueren ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheAussenanlagen> holeSonderwuenscheAussenanlagen()
    {
        List<SonderwuenscheAussenanlagen> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheAussenanlagen ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheParkett> holeSonderwuenscheParkett()
    {
        List<SonderwuenscheParkett> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheParkett ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }

    public List<SonderwuenscheFliesen> holeSonderwuenscheFliesen()
    {
        List<SonderwuenscheFliesen> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheFliesen ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }
    public List<SonderwuenscheHeizung> holeSonderwuenscheHeizung()
    {
        List<SonderwuenscheHeizung> sonderwuensche = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from SonderwuenscheHeizung ");
        sonderwuensche = query.list();
        session.close();

        return sonderwuensche;
    }
}
