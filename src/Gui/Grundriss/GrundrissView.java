package Gui.Grundriss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{

    public static final long serialVersionUID = 1L;
    private int[] auswahl = new int[6]; 
    // das Control-Objekt des Grundriss-Fensters
    private GrundrissControl grundrissControl;
   

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblWandKueche = new JLabel("Wand zur Abtrennung der Küche von dem Essbereich");
    private JTextField txtPreisWandKueche = new JTextField("300");                                  //String Preis wird später direkt aus der Datenbank gelesen 
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
    private JTextField txtPreisBadAusfuehrung = new JTextField("8990");
    private JLabel lblBadAusfuehrungEuro = new JLabel("Euro");
    private JCheckBox chckBxBadAusfuehrung = new JCheckBox();
    
    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();
    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
     */
    public GrundrissView (GrundrissControl grundrissControl){
        this.grundrissControl = grundrissControl;
        this.setTitle("Sonderwünsche zu Grundriss-Varianten");
        this.initKomponenten();
        this.leseGrundrissSonderwuensche();
        this.iniListener();
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
        
        super.getPnlSonderwunsch().add(lblGesamtpreis);
    	lblGesamtpreis.setBounds(10, 225, 350, 25);
    	super.getPnlSonderwunsch().add(txtGesamtpreis);
    	txtGesamtpreis.setBounds(350, 225, 80, 25);
    	txtGesamtpreis.setEditable(false);
    }
    
    protected void iniListener() {
    	super.initListener();
    	chckBxWandKueche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[0] = Integer.parseInt(txtPreisWandKueche.getText());
	  	        }else {
	  	        	auswahl[0] = 0;
	  	        }
				
			}
		});
    	chckBxTuerKueche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[1] = Integer.parseInt(txtPreisTuerKueche.getText());
	  	        }else {
	  	        	auswahl[1] = 0;
	  	        }
				
			}
		});
    	chckBxGrZimmer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[2] = Integer.parseInt(txtPreisGrZimmer.getText());
	  	        }else {
	  	        	auswahl[2] = 0;
	  	        }
				
			}
		});
    	chckBxTreppenraum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[3] = Integer.parseInt(txtPreisTreppenraum.getText());
	  	        }else {
	  	        	auswahl[3] = 0;
	  	        }
				
			}
		});
    	chckBxBadVorrichtung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[4] = Integer.parseInt(txtPreisBadVorrichtung.getText());
	  	        }else {
	  	        	auswahl[4] = 0;
	  	        }
				
			}
		});
    	chckBxBadAusfuehrung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[5] = Integer.parseInt(txtPreisBadAusfuehrung.getText());
	  	        }else {
	  	        	auswahl[5] = 0;
	  	        }
				
			}
		});
    }

    private void leseGrundrissSonderwuensche(){
        this.grundrissControl.leseGrundrissSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
        if(grundrissControl.pruefeKonstellationSonderwuensche(auswahl)) {
  			grundrissControl.zeigePreisSonderwuensche(auswahl);
  			
  		}
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
    }
    
    protected JTextField getTxtGesamtpreis() {
  		return this.txtGesamtpreis;
  		
  	}

}
