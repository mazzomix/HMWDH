package Gui.Grundriss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheGrundriss;
import org.hibernate.Hibernate;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{

    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[6];
    // das Control-Objekt des Grundriss-Fensters
    private GrundrissControl grundrissControl;
	// Liste der Sonderwünsche aus der Datenbank
    private List<SonderwuenscheGrundriss> sonderwuenscheGrundriss = db.holeSonderwuenscheGrundriss();
   

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblWandKueche = new JLabel(sonderwuenscheGrundriss.get(0).getWunsch());
    private JTextField txtPreisWandKueche = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(0).getPreis()));                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblWandKuecheEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxWandKueche = new JCheckBox();
    
    private JLabel lblTuerKueche = new JLabel(sonderwuenscheGrundriss.get(1).getWunsch());
    private JTextField txtPreisTuerKueche = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(1).getPreis()));
    private JLabel lblTuerKuecheEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxTuerKueche = new JCheckBox();
    
    private JLabel lblGrZimmer = new JLabel(sonderwuenscheGrundriss.get(2).getWunsch());
    private JTextField txtPreisGrZimmer = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(2).getPreis()));
    private JLabel lblGrZimmerEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxGrZimmer = new JCheckBox();
    
    private JLabel lblTreppenraum = new JLabel(sonderwuenscheGrundriss.get(3).getWunsch());
    private JTextField txtPreisTreppenraum = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(3).getPreis()));
    private JLabel lblTreppenraumEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxTreppenraum = new JCheckBox();
    
    private JLabel lblBadVorrichtung = new JLabel(sonderwuenscheGrundriss.get(4).getWunsch());
    private JTextField txtPreisBadVorrichtung = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(4).getPreis()));
    private JLabel lblBadVorrichtungEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxBadVorrichtung = new JCheckBox();
    
    private JLabel lblBadAusfuehrung = new JLabel(sonderwuenscheGrundriss.get(5).getWunsch());
    private JTextField txtPreisBadAusfuehrung = new JTextField(String.valueOf(sonderwuenscheGrundriss.get(5).getPreis()));
    private JLabel lblBadAusfuehrungEuro = new JLabel(BasisView.currency);
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
    	txtGesamtpreis.setBounds(350, 225, 150, 25);
    	txtGesamtpreis.setEditable(false);
    }
    
    protected void iniListener() {
    	super.initListener();
    	chckBxWandKueche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(0));
	  	        	auswahl[0] = sonderwuenscheGrundriss.get(0).getPreis();
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
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(1));
	  	        	auswahl[1] = sonderwuenscheGrundriss.get(1).getPreis();
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
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(2));
	  	        	auswahl[2] = sonderwuenscheGrundriss.get(2).getPreis();
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
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(3));
	  	        	auswahl[3] = sonderwuenscheGrundriss.get(3).getPreis();
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
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(4));
	  	        	auswahl[4] = sonderwuenscheGrundriss.get(4).getPreis();
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
                    grundrissControl.addWunsch(sonderwuenscheGrundriss.get(5));
	  	        	auswahl[5] = sonderwuenscheGrundriss.get(5).getPreis();
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
  			
  	}else {
  	    grundrissControl.zeigeFehlerSonderwunsch();
  	}
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
        Set kunden = new HashSet();
        for (SonderwuenscheGrundriss wunsch: grundrissControl.getWuensche()){
            kunden = wunsch.getKunden();
            kunden.add(kunde.getKunde());
            wunsch.setKunden(kunden);
        }
        kunde.getKunde().setSonderwuenscheGrundriss(grundrissControl.getWuensche());
        db.speichereKunden(kunde.getKunde(), kunde.getKunde().getHausnummer().getId());


    }
    
    protected JTextField getTxtGesamtpreis() {
  		return this.txtGesamtpreis;
  		
  	}

}
