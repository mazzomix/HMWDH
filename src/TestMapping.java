import HibernateCont.HibernateUtil;
import HibernateCont.Kunde;
import HibernateCont.SonderwuenscheAussenanlagen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestMapping {

        /*public static void main(String[] args) {

            SessionFactory factory = null;
            try {
                factory = HibernateUtil.createSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Kunde kunde = new Kunde("Penner", "Pu", "drdrg", "rdgdrg@arcor.de");

            if (factory != null) {

                Session session = factory.openSession();
                session.beginTransaction();

                //Haustyp haustyp = session.load(Haustyp.class, 2);
                //kunde.setHaustyp(haustyp);
                //haustyp.addKunde(kunde);

                Kunde kunde = session.load(Kunde.class, 1);

                SonderwuenscheAussenanlagen wunsch1 = session.get(SonderwuenscheAussenanlagen.class, 1);
                SonderwuenscheAussenanlagen wunsch2 = session.get(SonderwuenscheAussenanlagen.class, 2);

                kunde.addSonderWunsch(wunsch1);
                kunde.addSonderWunsch(wunsch2);

                wunsch1.addKunde(kunde);
                wunsch2.addKunde(kunde);

                //session.save(haustyp);
                session.save(kunde);

                session.getTransaction().commit();
                session.close();
                factory.close();
            }
    }*/
}
