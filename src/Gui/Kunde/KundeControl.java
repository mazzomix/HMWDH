package Gui.Kunde;

import Gui.Grundriss.GrundrissControl;
import HibernateCont.Haustyp;
import HibernateCont.HibernateUtil;
import HibernateCont.Kunde;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.JOptionPane;
public class KundeControl {

    // das View-Objekt des Grundfensters
    private KundeView kundeView;
    // das GrundrissControl-Objekt zum Kunden
    private GrundrissControl grundrissControl;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundfenster und
     * oeffnet das View.
     */
    public KundeControl() {
        this.kundeView = new KundeView(this);
    }

    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das View wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
        if (this.grundrissControl == null){
            this.grundrissControl = new GrundrissControl();
        }
        this.grundrissControl.oeffneGrundrissView();
    }

    public void speichereKunden(Kunde kunde){
        SessionFactory factory = null;
        // Erzeuge SessionFactory
        try {
            factory = HibernateUtil.createSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Wenn das Erzeugen der factory geklappt hat speichere Daten
        if (factory != null) {
            // Session erstellen und Transaction beginnen
            Session session = factory.openSession();
            session.beginTransaction();

            // TODO: Haustyp wird hier aus der DB geladen. Ist Plannummer = Haustyp?
            // Haustyp mit id 2 wird aus Datenbank geladen, danach wird jeweils Kunde und Haustyp gesetzt
            Haustyp haustyp = session.load(Haustyp.class, 2);
            kunde.setHaustyp(haustyp);
            haustyp.addKunde(kunde);

            // Speichere die änderungen
            session.save(kunde);
            session.save(haustyp);

            // Änderungen in die Datenbank schreiben
            session.getTransaction().commit();
            session.close();
            factory.close();
        }
    }

}
