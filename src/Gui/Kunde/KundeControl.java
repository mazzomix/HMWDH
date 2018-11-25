package Gui.Kunde;

import Business.Kunde.Kunde;
import Business.Kunde.KundeModel;
import Gui.Grundriss.GrundrissControl;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KundeControl {

    // das View-Objekt des Grundfensters
    private KundeView kundeView;
    // das Model-Objekt des Grundfensters
    private KundeModel kundeModel;
    // das GrundrissControl-Objekt zum Kunden
    private GrundrissControl grundrissControl;
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Grundfenster und
     * oeffnet das View.
     */
    public KundeControl() {
        this.kundeModel = KundeModel.getInstance();
        this.kundeView = new KundeView(this, kundeModel);
    }

    /*
     * erstellt, falls nicht vorhanden, ein Grundriss-Control-Objekt.
     * Das View wird sichtbar gemacht.
     */
    public void oeffneGrundrissControl(){
        if (this.grundrissControl == null){
            this.grundrissControl = new GrundrissControl(kundeModel);
        }
        this.grundrissControl.oeffneGrundrissView();
    }

    public void speichereKunden(Kunde kunde){
        try{
            //cn = DriverManager.getConnection( "jdbc:mysql://localhost", "root", "hmwdh1234" );
            //kundeModel.speichereKunden(kunde);
            //st = cn.createStatement();
            st.executeQuery( "SELECT * FROM kunde");
        }
        catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this.kundeView,
                    "DB-Fehler: Der Kunde konnte nicht gespeichert werden.");
        }
    }

}
