package gui.grundriss;

import gui.basis.BasisView;

import java.awt.event.ActionListener;

import javax.swing.*;
import business.kunde.KundeModel;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu 
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{
 
    public static final long serialVersionUID = 1L;
    
	// das Control-Objekt des Grundriss-Fensters
	private GrundrissControl grundrissControl;
   
    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblWandKueche = new JLabel("Wand zur Abtrennung der Küche von dem Essbereich");
    private JTextField txtPreisWandKueche = new JTextField("300");
    private JLabel lblWandKuecheEuro = new JLabel("Euro");
    private JCheckBox chckBxWandKueche = new JCheckBox();
    
    private JLabel lblTuerKueche = new JLabel("Tür in der Wand zwischen Küche und Essbereich");
    private JTextField txtPreisTuerKueche = new JTextField("300");
    private JLabel lblTuerKuecheEuro = new JLabel("Euro");
    private JCheckBox chckBxTuerKueche = new JCheckBox();
    
    private JLabel lblGrZimmer = new JLabel("Großes Zimmer im OG statt zwei kleinen Zimmern");
    private JTextField txtPreisGrZimmer = new JTextField("0");
    private JLabel lblGrZimmerEuro = new JLabel("Euro");
    private JCheckBox chckBxGrZimmer = new JCheckBox();
    
    private JLabel lblTreppenraum = new JLabel("Abgetrennter Treppenraum im DG");
    private JTextField txtPreisTreppenraum = new JTextField("890");
    private JLabel lblTreppenraumEuro = new JLabel("Euro");
    private JCheckBox chckBxTreppenraum = new JCheckBox();
    
    private JLabel lblBadVorrichtung = new JLabel("Vorrichtung eines Bades im DG");
    private JTextField txtPreisBadVorrichtung = new JTextField("990");
    private JLabel lblBadVorrichtungEuro = new JLabel("Euro");
    private JCheckBox chckBxBadVorrichtung = new JCheckBox();
    
    private JLabel lblBadAusfuehrung = new JLabel("Ausführung eines Bades im DG");
    private JTextField txtPreisBadAusfuehrung = new JTextField("8.990");
    private JLabel lblBadAusfuehrungEuro = new JLabel("Euro");
    private JCheckBox chckBxBadAusfuehrung = new JCheckBox();
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    
    
    /**
     * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
     * @param grundrissModel GrundrissModel, enthaelt das zugehoerige Model
    */
    public GrundrissView (GrundrissControl grundrissControl, KundeModel kundeModel){
        super(kundeModel);
        this.grundrissControl = grundrissControl;
        this.setTitle("Sonderwünsche zu Grundriss-Varianten");
	    this.initKomponenten();
	    this.leseGrundrissSonderwuensche();
    }

  
    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	super.initKomponenten(); 
    	// pnlSonderwunsch wird belegt.
       	super.getLblSonderwunsch().setText("Grundriss-Varianten");
       	super.getPnlSonderwunsch().add(lblWandKueche);
       	lblWandKueche.setBounds(10, 50, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisWandKueche);
    	txtPreisWandKueche.setBounds(350, 50, 80, 25);
    	txtPreisWandKueche.setEditable(false);
    	super.getPnlSonderwunsch().add(lblWandKuecheEuro);
       	lblWandKuecheEuro.setBounds(440, 50, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxWandKueche);
    	chckBxWandKueche.setBounds(470, 50, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblTuerKueche);
    	lblTuerKueche.setBounds(10, 75, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisTuerKueche);
    	txtPreisTuerKueche.setBounds(350, 75, 80, 25);
    	txtPreisTuerKueche.setEditable(false);
    	super.getPnlSonderwunsch().add(lblTuerKuecheEuro);
       	lblTuerKuecheEuro.setBounds(440, 75, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxTuerKueche);
    	chckBxTuerKueche.setBounds(470, 75, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblGrZimmer);
    	lblGrZimmer.setBounds(10, 100, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisGrZimmer);
    	txtPreisGrZimmer.setBounds(350, 100, 80, 25);
    	txtPreisGrZimmer.setEditable(false);
    	super.getPnlSonderwunsch().add(lblGrZimmerEuro);
       	lblGrZimmerEuro.setBounds(440, 100, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxGrZimmer);
    	chckBxGrZimmer.setBounds(470, 100, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblTreppenraum);
    	lblTreppenraum.setBounds(10, 125, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisTreppenraum);
    	txtPreisTreppenraum.setBounds(350, 125, 80, 25);
    	txtPreisTreppenraum.setEditable(false);
    	super.getPnlSonderwunsch().add(lblTreppenraumEuro);
       	lblTreppenraumEuro.setBounds(440, 125, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxTreppenraum);
    	chckBxTreppenraum.setBounds(470, 125, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblBadVorrichtung);
    	lblBadVorrichtung.setBounds(10, 150, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisBadVorrichtung);
    	txtPreisBadVorrichtung.setBounds(350, 150, 80, 25);
    	txtPreisBadVorrichtung.setEditable(false);
    	super.getPnlSonderwunsch().add(lblBadVorrichtungEuro);
       	lblBadVorrichtungEuro.setBounds(440, 150, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxBadVorrichtung);
    	chckBxBadVorrichtung.setBounds(470, 150, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblBadAusfuehrung);
    	lblBadAusfuehrung.setBounds(10, 175, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisBadAusfuehrung);
    	txtPreisBadAusfuehrung.setBounds(350, 175, 80, 25);
    	txtPreisBadAusfuehrung.setEditable(false);
    	super.getPnlSonderwunsch().add(lblBadAusfuehrungEuro);
       	lblBadAusfuehrungEuro.setBounds(440, 175, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxBadAusfuehrung);
    	chckBxBadAusfuehrung.setBounds(470, 175, 25, 25);
    }

    private void leseGrundrissSonderwuensche(){
    	this.grundrissControl.leseGrundrissSonderwuensche();
    }

 	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected void berechneUndZeigePreisSonderwuensche(){
  		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann der Preis berechnet.
  	}
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected void speichereSonderwuensche(){
 		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
  		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
  	}
  	
 	
 }

