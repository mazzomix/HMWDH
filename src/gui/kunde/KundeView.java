package gui.kunde;

import business.kunde.Kunde;
import business.kunde.KundeModel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten bereitstellt.
 */
public class KundeView extends JFrame{
 
	// das Control-Objekt des Grundfensters
	private KundeControl kundeControl;

	// das Model-Objekt des Grundfensters
	private KundeModel kundeModel;

    public static final long serialVersionUID = 1L;
   
    //---Anfang Attribute der grafischen Oberflaeche---
    private JPanel pnlKunde    	  	  = new JPanel();
    private JLabel lblKunde    	      = new JLabel("Kunde");
    private JLabel lblNummerHaus      = new JLabel("Plannummer des Hauses");
    private JComboBox<Integer> 
        cmbBxNummerHaus               = new JComboBox<Integer>(
        new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24});
    private JLabel lblVorname         = new JLabel("Vorname");
    private JTextField txtVorname     = new JTextField();   
    private JButton btnAnlegen	 	  = new JButton("Anlegen");
    private JButton btnAendern 	      = new JButton("�ndern");
    private JButton btnLoeschen 	  = new JButton("L�schen");
    private JMenuBar mnBar 			  = new JMenuBar();
    private JMenu mnSonderwuensche    = new JMenu("Sonderw�nsche");
    private JMenuItem mnItmGrundriss  = new JMenuItem("Grundrissvarianten");
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein KundeView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     * @param kundeControl KundeControl, enthaelt das zugehoerige Control
     * @param kundeModel KundeModel, enthaelt das zugehoerige Model
    */
    public KundeView (KundeControl kundeControl, 
    	KundeModel kundeModel){
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.kundeControl = kundeControl;
        this.kundeModel = kundeModel;
        this.setTitle("Verwaltung der Sonderwunschlisten");
	    this.setSize(550,400);
	    this.setLayout(null);
	    this.initKomponenten();
	    this.initListener();
	    this.setLocation(400, 200);
        this.setVisible(true);
    }

 
    /* initialisiert die Steuerelemente auf der Maske */
    private void initKomponenten(){
    	// pnlKunde wird erzeugt.
    	this.add(pnlKunde);
    	pnlKunde.setBounds(10, 10, 510, 270);
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
	    // Buttons
	    this.add(btnAnlegen);
	    btnAnlegen.setBounds(50, 300, 150, 25);
	    this.add(btnAendern);
	    btnAendern.setBounds(210, 300, 150, 25);
	    this.add(btnLoeschen);
	    btnLoeschen.setBounds(370, 300, 150, 25);
	    // MenuBar und Menu
	    this.setJMenuBar(mnBar);
	    mnBar.add(mnSonderwuensche);
	    mnSonderwuensche.add(mnItmGrundriss);
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
    }
    
    private void holeInfoDachgeschoss(){ 
    }
    
    private void leseKunden(){
    }
    
    private void legeKundenAn(){
         Kunde kunde = null;
         // Objekt kunde fuellen
         kundeControl.speichereKunden(kunde);
   	}
    
  	private void aendereKunden(){
   	}
  	
   	private void loescheKunden(){
   	}
}

