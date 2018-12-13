package Gui.Parkett;

import Gui.Basis.BasisView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class ParkettView extends BasisView{

    public static final long serialVersionUID = 1L;
    private int[] auswahl = new int[10];
    // das Control-Objekt des Grundriss-Fensters
    private ParkettControl parkettControl;
	private BasisView basisView;

	//---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblEGEssbereichDielen = new JLabel("Landhausdielen massiv im Essbereich des EG");
    private JTextField txtPreisEGEssbereichDielen = new JTextField("2890");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblEGEssbereichDielenEuro = new JLabel("Euro");
    private JCheckBox chckBxEGEssbereichDielen = new JCheckBox();
    
    private JLabel lblEGKuechenbereichDielen = new JLabel("Landhausdielen massiv im Küchenbereich des EG");
    private JTextField txtPreisEGKuechenbereichDielen = new JTextField("2090");
    private JLabel lblEGKuechenbereichDielenEuro = new JLabel("Euro");
    private JCheckBox chckBxEGKuechenbereichDielen = new JCheckBox();
    
    private JLabel lblEGEssbereichParkett = new JLabel("Stäbchenparkett im Essbereich des EG");
    private JTextField txtPreisEGEssbereichParkett = new JTextField("2090");
    private JLabel lblEGEssbereichParkettEuro = new JLabel("Euro");
    private JCheckBox chckBxEGEssbereichParkett = new JCheckBox();
    
    private JLabel lblEGKuechenbereichParkett = new JLabel("Stäbchenparkett im Küchenbereich des EG");
    private JTextField txtPreisEGKuechenbereichParkett = new JTextField("1790");
    private JLabel lblEGKuechenbereichParkettEuro = new JLabel("Euro");
    private JCheckBox chckBxEGKuechenbereichParkett = new JCheckBox();
    
    private JLabel lblParkettOG = new JLabel("Stäbchenparkett im OG");
    private JTextField txtPreisParkettOG = new JTextField("1690");
    private JLabel lblParkettOGEuro = new JLabel("Euro");
    private JCheckBox chckBxParkettOG = new JCheckBox();
    
    private JLabel lblDielenOG = new JLabel("Landhausdielen massiv im OG");
    private JTextField txtPreisDielenOG = new JTextField("2490");
    private JLabel lblDielenOGEuro = new JLabel("Euro");
    private JCheckBox chckBxDielenOG = new JCheckBox();

    private JLabel lblDGKomplettDielen = new JLabel("Landhausdielen massiv komplett im DG");
    private JTextField txtPreisDGKomplettDielen = new JTextField("2490");
    private JLabel lblDGKomplettDielenEuro = new JLabel("Euro");
    private JCheckBox chckBxDGKomplettDielen = new JCheckBox();

	private JLabel lblDGOhneBadbereichDielen = new JLabel("Landhausdielen massiv ohne Badebereich im DG");
	private JTextField txtPreisDGOhneBadbereichDielen = new JTextField("2090");
	private JLabel lblDGOhneBadbereichDielenEuro = new JLabel("Euro");
	private JCheckBox chckBxDGOhneBadbereichDielen = new JCheckBox();

	private JLabel lblDGKomplettParkett = new JLabel("Stäbchenparkett im DG komplett im DG");
	private JTextField txtPreisDGKomplettParkett = new JTextField("1690");
	private JLabel lblDGKomplettParkettEuro = new JLabel("Euro");
	private JCheckBox chckBxDGKomplettParkett = new JCheckBox();

	private JLabel lblDGOhneBadbereichParkett = new JLabel("Landhausdielen ohne Badbereich im DG");
	private JTextField txtPreisDGOhneBadbereichParkett = new JTextField("1690");
	private JLabel lblDGOhneBadbereichParkettEuro = new JLabel("Euro");
	private JCheckBox chckBxDGOhneBadbereichParkett = new JCheckBox();
    
    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();
    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein ParkettView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     * @param parkettControl ParkettControl, enthaelt das zugehoerige Control
     */
    public ParkettView(ParkettControl parkettControl){

        this.parkettControl = parkettControl;
        this.setTitle("Sonderwünsche zu Parkett-Varianten");
        this.initKomponenten();
        this.leseParkettSonderwuensche();
        this.iniListener();
    }


    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
        super.initKomponenten();
        // pnlSonderwunsch wird belegt.
		super.setSize(550, 450);	//Fenster vergrößern
		super.getPnlSonderwunsch().setSize(510, 360);
		super.getBtnBerechnen().setLocation(210, 380);
		super.getBtnSpeichern().setLocation(370, 380);
        super.getLblSonderwunsch().setText("Parkett-Varianten");
        super.getPnlSonderwunsch().add(lblEGEssbereichDielen);
        lblEGEssbereichDielen.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEGEssbereichDielen);
        txtPreisEGEssbereichDielen.setBounds(350, 50, 80, 25);
        txtPreisEGEssbereichDielen.setEditable(false);
        super.getPnlSonderwunsch().add(lblEGEssbereichDielenEuro);
        lblEGEssbereichDielenEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxEGEssbereichDielen);
        chckBxEGEssbereichDielen.setBounds(470, 50, 25, 25);
        
        super.getPnlSonderwunsch().add(lblEGKuechenbereichDielen);
    	lblEGKuechenbereichDielen.setBounds(10, 75, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisEGKuechenbereichDielen);
    	txtPreisEGKuechenbereichDielen.setBounds(350, 75, 80, 25);
    	txtPreisEGKuechenbereichDielen.setEditable(false);
    	super.getPnlSonderwunsch().add(lblEGKuechenbereichDielenEuro);
       	lblEGKuechenbereichDielenEuro.setBounds(440, 75, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxEGKuechenbereichDielen);
    	chckBxEGKuechenbereichDielen.setBounds(470, 75, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblEGEssbereichParkett);
    	lblEGEssbereichParkett.setBounds(10, 100, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisEGEssbereichParkett);
    	txtPreisEGEssbereichParkett.setBounds(350, 100, 80, 25);
    	txtPreisEGEssbereichParkett.setEditable(false);
    	super.getPnlSonderwunsch().add(lblEGEssbereichParkettEuro);
       	lblEGEssbereichParkettEuro.setBounds(440, 100, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxEGEssbereichParkett);
    	chckBxEGEssbereichParkett.setBounds(470, 100, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblEGKuechenbereichParkett);
    	lblEGKuechenbereichParkett.setBounds(10, 125, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisEGKuechenbereichParkett);
    	txtPreisEGKuechenbereichParkett.setBounds(350, 125, 80, 25);
    	txtPreisEGKuechenbereichParkett.setEditable(false);
    	super.getPnlSonderwunsch().add(lblEGKuechenbereichParkettEuro);
       	lblEGKuechenbereichParkettEuro.setBounds(440, 125, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxEGKuechenbereichParkett);
    	chckBxEGKuechenbereichParkett.setBounds(470, 125, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblParkettOG);
    	lblParkettOG.setBounds(10, 150, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisParkettOG);
    	txtPreisParkettOG.setBounds(350, 150, 80, 25);
    	txtPreisParkettOG.setEditable(false);
    	super.getPnlSonderwunsch().add(lblParkettOGEuro);
       	lblParkettOGEuro.setBounds(440, 150, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxParkettOG);
    	chckBxParkettOG.setBounds(470, 150, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblDielenOG);
    	lblDielenOG.setBounds(10, 175, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisDielenOG);
    	txtPreisDielenOG.setBounds(350, 175, 80, 25);
    	txtPreisDielenOG.setEditable(false);
    	super.getPnlSonderwunsch().add(lblDielenOGEuro);
       	lblDielenOGEuro.setBounds(440, 175, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxDielenOG);
    	chckBxDielenOG.setBounds(470, 175, 25, 25);

    	super.getPnlSonderwunsch().add(lblDGKomplettDielen);
		lblDGKomplettDielen.setBounds(10, 200, 350, 25);
		super.getPnlSonderwunsch().add(txtPreisDGKomplettDielen);
		txtPreisDGKomplettDielen.setBounds(350, 200, 80, 25);
		txtPreisDGKomplettDielen.setEditable(false);
		super.getPnlSonderwunsch().add(lblDGKomplettDielenEuro);
		lblDGKomplettDielenEuro.setBounds(440, 200, 50, 25);
		super.getPnlSonderwunsch().add(chckBxDGKomplettDielen);
		chckBxDGKomplettDielen.setBounds(470, 200, 25, 25);

		super.getPnlSonderwunsch().add(lblDGOhneBadbereichDielen);
		lblDGOhneBadbereichDielen.setBounds(10, 225, 350, 25);
		super.getPnlSonderwunsch().add(txtPreisDGOhneBadbereichDielen);
		txtPreisDGOhneBadbereichDielen.setBounds(350, 225, 80, 25);
		txtPreisDGOhneBadbereichDielen.setEditable(false);
		super.getPnlSonderwunsch().add(lblDGOhneBadbereichDielenEuro);
		lblDGOhneBadbereichDielenEuro.setBounds(440, 225, 50, 25);
		super.getPnlSonderwunsch().add(chckBxDGOhneBadbereichDielen);
		chckBxDGOhneBadbereichDielen.setBounds(470, 225, 25, 25);

		super.getPnlSonderwunsch().add(lblDGKomplettParkett);
		lblDGKomplettParkett.setBounds(10, 250, 350, 25);
		super.getPnlSonderwunsch().add(txtPreisDGKomplettParkett);
		txtPreisDGKomplettParkett.setBounds(350, 250, 80, 25);
		txtPreisDGKomplettParkett.setEditable(false);
		super.getPnlSonderwunsch().add(lblDGKomplettParkettEuro);
		lblDGKomplettParkettEuro.setBounds(440, 250, 50, 25);
		super.getPnlSonderwunsch().add(chckBxDGKomplettParkett);
		chckBxDGKomplettParkett.setBounds(470, 250, 25, 25);

		super.getPnlSonderwunsch().add(lblDGOhneBadbereichParkett);
		lblDGOhneBadbereichParkett.setBounds(10, 275, 350, 25);
		super.getPnlSonderwunsch().add(txtPreisDGOhneBadbereichParkett);
		txtPreisDGOhneBadbereichParkett.setBounds(350, 275, 80, 25);
		txtPreisDGOhneBadbereichParkett.setEditable(false);
		super.getPnlSonderwunsch().add(lblDGOhneBadbereichParkettEuro);
		lblDGOhneBadbereichParkettEuro.setBounds(440, 275, 50, 25);
		super.getPnlSonderwunsch().add(chckBxDGOhneBadbereichParkett);
		chckBxDGOhneBadbereichParkett.setBounds(470, 275, 25, 25);
        
        super.getPnlSonderwunsch().add(lblGesamtpreis);
    	lblGesamtpreis.setBounds(10, 325, 350, 25);
    	super.getPnlSonderwunsch().add(txtGesamtpreis);
    	txtGesamtpreis.setBounds(350, 325, 150, 25);
    	txtGesamtpreis.setEditable(false);
    }
    
    protected void iniListener() {
    	super.initListener();
    	chckBxEGEssbereichDielen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[0] = Integer.parseInt(txtPreisEGEssbereichDielen.getText());
	  	        }else {
	  	        	auswahl[0] = 0;
	  	        }
				
			}
		});
    	chckBxEGKuechenbereichDielen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[1] = Integer.parseInt(txtPreisEGKuechenbereichDielen.getText());
	  	        }else {
	  	        	auswahl[1] = 0;
	  	        }
				
			}
		});
    	chckBxEGEssbereichParkett.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[2] = Integer.parseInt(txtPreisEGEssbereichParkett.getText());
	  	        }else {
	  	        	auswahl[2] = 0;
	  	        }
				
			}
		});
    	chckBxEGKuechenbereichParkett.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[3] = Integer.parseInt(txtPreisEGKuechenbereichParkett.getText());
	  	        }else {
	  	        	auswahl[3] = 0;
	  	        }
				
			}
		});
    	chckBxParkettOG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[4] = Integer.parseInt(txtPreisParkettOG.getText());
	  	        }else {
	  	        	auswahl[4] = 0;
	  	        }
				
			}
		});
    	chckBxDielenOG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
	  	        if(abBttn.getModel().isSelected()) {
	  	        	auswahl[5] = Integer.parseInt(txtPreisDielenOG.getText());
	  	        }else {
	  	        	auswahl[5] = 0;
	  	        }
				
			}
		});
		chckBxDGOhneBadbereichParkett.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
				if(abBttn.getModel().isSelected()) {
					auswahl[6] = Integer.parseInt(txtPreisDGOhneBadbereichParkett.getText());
				}else {
					auswahl[6] = 0;
				}
			}
		});
		chckBxDGOhneBadbereichDielen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
				if(abBttn.getModel().isSelected()) {
					auswahl[7] = Integer.parseInt(txtPreisDGOhneBadbereichDielen.getText());
				}else {
					auswahl[7] = 0;
				}
			}
		});
		chckBxDGKomplettParkett.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
				if(abBttn.getModel().isSelected()) {
					auswahl[8] = Integer.parseInt(txtPreisDGKomplettParkett.getText());
				}else {
					auswahl[8] = 0;
				}
			}
		});
		chckBxDGKomplettDielen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
				if(abBttn.getModel().isSelected()) {
					auswahl[9] = Integer.parseInt(txtPreisDGKomplettDielen.getText());
				}else {
					auswahl[9] = 0;
				}
			}
		});
    }

    private void leseParkettSonderwuensche(){
        this.parkettControl.leseParkettSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
        if(parkettControl.pruefeKonstellationSonderwuensche(auswahl)) {
            parkettControl.zeigePreisSonderwuensche(auswahl);
  			
  	}else {
  	    parkettControl.zeigeFehlerSonderwunsch();
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
