package Gui.Kunde;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import HibernateCont.Hausnummer;
import HibernateCont.Haustyp;
import HibernateCont.Kunde;

import java.awt.*;
import javax.persistence.PersistenceException;
import javax.swing.*;

public class KundeView extends JFrame {

    // das Control-Objekt des Grundfensters
    private KundeControl kundeControl;

    public static final long serialVersionUID = 1L;

    //---Anfang Attribute der grafischen Oberflaeche---
    private JPanel pnlKunde    	  	  = new JPanel();
    private JLabel lblKunde    	      = new JLabel("Kunde");
    private JLabel lblNummerHaus      = new JLabel("Plannummer des Hauses");
    private JComboBox<Integer>
            cmbBxNummerHaus               = new JComboBox<Integer>(
            new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24});
    private JLabel lblVorname         = new JLabel("Vorname");
    private JTextField txtVorname     = new JTextField();
    private JLabel lblNachname         = new JLabel("Nachname");
    private JTextField txtNachname     = new JTextField();
    private JLabel lblKundennummer         = new JLabel("Kundennummer");
    private JLabel lblTextKundennummer         = new JLabel("");
    private JLabel lblTelefon         = new JLabel("Telefon");
    private JTextField txtTelefon     = new JTextField();
    private JLabel lblEmail         = new JLabel("Email");
    private JTextField txtEmail     = new JTextField();
    private JLabel lblDachgeschoss         = new JLabel("Dachgeschoss");
    private JLabel lblTxtDachgeschoss         = new JLabel("");
    private JLabel lblError         = new JLabel("");
    private JButton btnAnlegen	 	  = new JButton("Anlegen");
    private JButton btnAendern 	      = new JButton("Ändern");
    private JButton btnLoeschen 	  = new JButton("Löschen");
    private JMenuBar mnBar 			  = new JMenuBar();
    private JMenu mnSonderwuensche    = new JMenu("Sonderwünsche");
    private JMenuItem mnItmGrundriss  = new JMenuItem("Grundrissvarianten");
    private JMenuItem mnItmFensterAussentueren  = new JMenuItem("Fenster und Aussentueren");
    private JMenuItem mnItmSanitärinstallation = new JMenuItem("Sanitaerinstallation");
    private JMenuItem mnItmInnentueren = new JMenuItem("Innentüren");
    private JMenuItem mnItmAussenanlage = new JMenuItem("Außenanlage");
    private JMenuItem mnItmParkett = new JMenuItem("Parkett");
    private JMenuItem mnItmFliesen = new JMenuItem("Fliesen");

    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein KundeView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     * @param kundeControl KundeControl, enthaelt das zugehoerige Control
     */
    public KundeView (KundeControl kundeControl){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.kundeControl = kundeControl;
        this.setTitle("Verwaltung der Sonderwunschlisten");
        this.setSize(550,500);
        this.setLayout(null);
        this.initKomponenten();
        this.initListener();
        this.setLocation(400, 300);
        this.setVisible(true);
    }


    /* initialisiert die Steuerelemente auf der Maske */
    private void initKomponenten(){
        // pnlKunde wird erzeugt.
        this.add(pnlKunde);
        pnlKunde.setBounds(10, 10, 510, 370);
        pnlKunde.setLayout(null);
        pnlKunde.add(lblKunde);
        lblKunde.setFont(new Font("Arial", Font.BOLD, 24));
        lblKunde.setBounds(10, 10, 150, 40);
        pnlKunde.add(lblNummerHaus);
        lblNummerHaus.setBounds(10, 50, 150, 20);
        pnlKunde.add(cmbBxNummerHaus);
        cmbBxNummerHaus.setBounds(170, 50, 130, 20);
        cmbBxNummerHaus.setEditable(false);
        pnlKunde.add(lblVorname);
        lblVorname.setBounds(10, 80, 150, 20);
        pnlKunde.add(txtVorname);
        txtVorname.setBounds(170, 80, 130, 20);
        pnlKunde.add(lblNachname);
        lblNachname.setBounds(10, 110, 150, 20);
        pnlKunde.add(txtNachname);
        txtNachname.setBounds(170, 110, 130, 20);
        pnlKunde.add(lblKundennummer);
        lblKundennummer.setBounds(10, 140, 150, 20);
        pnlKunde.add(lblTextKundennummer);
        lblTextKundennummer.setBounds(170, 140, 130, 20);
        pnlKunde.add(lblTelefon);
        lblTelefon.setBounds(10, 170, 150, 20);
        pnlKunde.add(txtTelefon);
        txtTelefon.setBounds(170, 170, 130, 20);
        pnlKunde.add(lblEmail);
        lblEmail.setBounds(10, 200, 150, 20);
        pnlKunde.add(txtEmail);
        txtEmail.setBounds(170, 200, 130, 20);
        pnlKunde.add(lblDachgeschoss);
        lblDachgeschoss.setBounds(10, 230, 130, 20);
        pnlKunde.add(lblTxtDachgeschoss);
        lblTxtDachgeschoss.setBounds(170, 230, 130, 20);
        pnlKunde.add(lblError);
        lblError.setBounds(10, 260, 400, 40);
        // Buttons
        this.add(btnAnlegen);
        btnAnlegen.setBounds(50, 400, 150, 25);
        this.add(btnAendern);
        btnAendern.setBounds(210, 400, 150, 25);
        this.add(btnLoeschen);
        btnLoeschen.setBounds(370, 400, 150, 25);
        // MenuBar und Menu
        this.setJMenuBar(mnBar);
        mnBar.add(mnSonderwuensche);
        mnSonderwuensche.add(mnItmGrundriss);
        mnSonderwuensche.add(mnItmFensterAussentueren);
        mnSonderwuensche.add(mnItmSanitärinstallation);
        mnSonderwuensche.add(mnItmInnentueren);
        mnSonderwuensche.add(mnItmAussenanlage);
        mnSonderwuensche.add(mnItmParkett);
        mnSonderwuensche.add(mnItmFliesen);
    }

    /* initialisiert die Listener zu den Steuerelementen auf de Maske */
    private void initListener(){
        cmbBxNummerHaus.addActionListener(aEvent-> {
            holeInfoDachgeschoss();
            leseKunden();
        });
        btnAnlegen.addActionListener(aEvent-> {
            legeKundenAn();
        });
        btnAendern.addActionListener(aEvent-> {
            aendereKunden();
        });
        btnLoeschen.addActionListener(aEvent-> {
            loescheKunden();
        });
        mnItmGrundriss.addActionListener(aEvent-> {
            kundeControl.oeffneGrundrissControl();
        });
        mnItmFensterAussentueren.addActionListener(aEvent-> {
            kundeControl.oeffneFensterAussentuerenControl();
        });
        mnItmSanitärinstallation.addActionListener(aEvent-> {
            kundeControl.oeffneSanitärinstallationControl();
        });
        mnItmInnentueren.addActionListener(aEvent-> {
            kundeControl.oeffneInnentuerenControl();
        });
        mnItmAussenanlage.addActionListener(aEvent-> {
            kundeControl.oeffneAussenanlageControl();
        });
        mnItmParkett.addActionListener(aEvent-> {
            kundeControl.oeffneParkettControl();
        });
        mnItmFliesen.addActionListener(aEvent-> {
            kundeControl.oeffneFliesenControl();
        });
    }

    private void holeInfoDachgeschoss(){
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();
        boolean dg = db.hasDachgeschoss((Integer) this.cmbBxNummerHaus.getSelectedItem());

        if(dg) {
            this.lblTxtDachgeschoss.setText("Ja");
        } else {
            this.lblTxtDachgeschoss.setText("Nein");
        }
    }

    private void leseKunden(){
        this.lblError.setText("");
        Kunde kunde = null;
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();
        try{
            kunde = db.holeKunde((Integer)this.cmbBxNummerHaus.getSelectedItem());
            this.txtVorname.setText(kunde.getVorname());
            this.txtNachname.setText(kunde.getNachname());
            this.txtEmail.setText(kunde.getEmail());
            this.txtTelefon.setText(kunde.getTelefonNummer());
            this.lblTextKundennummer.setText(String.valueOf(kunde.getId()));
            Hausnummer hausnummer = kunde.getHausnummer();
            Haustyp haustyp = hausnummer.getHaustyp();
            KundeModel.getInstance().setKunde(kunde);
        } catch (IndexOutOfBoundsException e) {
            this.lblError.setText("<html>Für diese Hausnummer existiert kein Kunde</html>");
        }

    }

    private void legeKundenAn(){
        // Objekt kunde fuellen
        Kunde kunde = new Kunde();
        kunde.setVorname(this.txtVorname.getText());
        kunde.setNachname(this.txtNachname.getText());
        kunde.setEmail(this.txtEmail.getText());
        kunde.setTelefonNummer(this.txtTelefon.getText());
        kunde.setDeleted((byte)0);
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();
        try{
            int kundennummer = db.speichereKunden(kunde, (Integer)this.cmbBxNummerHaus.getSelectedItem());
            this.lblTextKundennummer.setText(String.valueOf(kundennummer));
            KundeModel.getInstance().setKunde(kunde);
        } catch (PersistenceException p) {
            this.lblError.setText("<html>ConstraintViolationException: Möglicherweise ist diese Hausnummer bereits an einen Kunden vergeben</html>");
        }

    }

    private void aendereKunden(){
    }

    private void loescheKunden(){
    }

}
