package Gui.Parkett;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheParkett;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class ParkettView extends BasisView{

    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[10];
    // das Control-Objekt des Grundriss-Fensters
    private ParkettControl parkettControl;
	private BasisView basisView;

	//---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblEGEssbereichDielen = new JLabel("");
    private JTextField txtPreisEGEssbereichDielen = new JTextField("");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblEGEssbereichDielenEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxEGEssbereichDielen = new JCheckBox();
    
    private JLabel lblEGKuechenbereichDielen = new JLabel("");
    private JTextField txtPreisEGKuechenbereichDielen = new JTextField("");
    private JLabel lblEGKuechenbereichDielenEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxEGKuechenbereichDielen = new JCheckBox();
    
    private JLabel lblEGEssbereichParkett = new JLabel("");
    private JTextField txtPreisEGEssbereichParkett = new JTextField("");
    private JLabel lblEGEssbereichParkettEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxEGEssbereichParkett = new JCheckBox();
    
    private JLabel lblEGKuechenbereichParkett = new JLabel("");
    private JTextField txtPreisEGKuechenbereichParkett = new JTextField("");
    private JLabel lblEGKuechenbereichParkettEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxEGKuechenbereichParkett = new JCheckBox();
    
    private JLabel lblParkettOG = new JLabel("");
    private JTextField txtPreisParkettOG = new JTextField("");
    private JLabel lblParkettOGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxParkettOG = new JCheckBox();
    
    private JLabel lblDielenOG = new JLabel("");
    private JTextField txtPreisDielenOG = new JTextField("");
    private JLabel lblDielenOGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxDielenOG = new JCheckBox();

    private JLabel lblDGKomplettDielen = new JLabel("");
    private JTextField txtPreisDGKomplettDielen = new JTextField("");
    private JLabel lblDGKomplettDielenEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxDGKomplettDielen = new JCheckBox();

	private JLabel lblDGOhneBadbereichDielen = new JLabel("");
	private JTextField txtPreisDGOhneBadbereichDielen = new JTextField("");
	private JLabel lblDGOhneBadbereichDielenEuro = new JLabel(BasisView.currency);
	private JCheckBox chckBxDGOhneBadbereichDielen = new JCheckBox();

	private JLabel lblDGKomplettParkett = new JLabel("");
	private JTextField txtPreisDGKomplettParkett = new JTextField("");
	private JLabel lblDGKomplettParkettEuro = new JLabel(BasisView.currency);
	private JCheckBox chckBxDGKomplettParkett = new JCheckBox();

	private JLabel lblDGOhneBadbereichParkett = new JLabel("");
	private JTextField txtPreisDGOhneBadbereichParkett = new JTextField("");
	private JLabel lblDGOhneBadbereichParkettEuro = new JLabel(BasisView.currency);
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
		this.parkettControl.setWuensche(db.holeSonderwuenscheParkett());
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
    	
    	super.getPnlSonderwunsch().add(lblDielenOG);
		lblDielenOG.setBounds(10, 150, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisParkettOG);
    	txtPreisDielenOG.setBounds(350, 150, 80, 25);
		txtPreisDielenOG.setEditable(false);
    	super.getPnlSonderwunsch().add(lblParkettOGEuro);
       	lblDielenOGEuro.setBounds(440, 150, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxDielenOG);
		chckBxDielenOG.setBounds(470, 150, 25, 25);
    	
    	super.getPnlSonderwunsch().add(lblParkettOG);
    	lblParkettOG.setBounds(10, 175, 350, 25);
    	super.getPnlSonderwunsch().add(txtPreisDielenOG);
    	txtPreisParkettOG.setBounds(350, 175, 80, 25);
		txtPreisParkettOG.setEditable(false);
    	super.getPnlSonderwunsch().add(lblDielenOGEuro);
       	lblParkettOGEuro.setBounds(440, 175, 50, 25);
    	super.getPnlSonderwunsch().add(chckBxParkettOG);
		chckBxParkettOG.setBounds(470, 175, 25, 25);

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

    	lblEGEssbereichDielen.setText(parkettControl.getWuensche().get(0).getWunsch());
		lblEGKuechenbereichDielen.setText(parkettControl.getWuensche().get(1).getWunsch());
		lblEGEssbereichParkett.setText(parkettControl.getWuensche().get(2).getWunsch());
		lblEGKuechenbereichParkett.setText(parkettControl.getWuensche().get(3).getWunsch());
		lblDielenOG.setText(parkettControl.getWuensche().get(4).getWunsch());
		lblParkettOG.setText(parkettControl.getWuensche().get(5).getWunsch());
		lblDGKomplettDielen.setText(parkettControl.getWuensche().get(6).getWunsch());
		lblDGOhneBadbereichDielen.setText(parkettControl.getWuensche().get(7).getWunsch());
		lblDGKomplettParkett.setText(parkettControl.getWuensche().get(8).getWunsch());
		lblDGOhneBadbereichParkett.setText(parkettControl.getWuensche().get(9).getWunsch());

		txtPreisEGEssbereichDielen.setText(String.valueOf(parkettControl.getWuensche().get(0).getPreis()));
		txtPreisEGKuechenbereichDielen.setText(String.valueOf(parkettControl.getWuensche().get(1).getPreis()));
		txtPreisEGEssbereichParkett.setText(String.valueOf(parkettControl.getWuensche().get(2).getPreis()));
		txtPreisEGKuechenbereichParkett.setText(String.valueOf(parkettControl.getWuensche().get(3).getPreis()));
		txtPreisDielenOG.setText(String.valueOf(parkettControl.getWuensche().get(4).getPreis()));
		txtPreisParkettOG.setText(String.valueOf(parkettControl.getWuensche().get(5).getPreis()));
		txtPreisDGKomplettDielen.setText(String.valueOf(parkettControl.getWuensche().get(6).getPreis()));
		txtPreisDGOhneBadbereichDielen.setText(String.valueOf(parkettControl.getWuensche().get(7).getPreis()));
		txtPreisDGKomplettParkett.setText(String.valueOf(parkettControl.getWuensche().get(8).getPreis()));
		txtPreisDGOhneBadbereichParkett.setText(String.valueOf(parkettControl.getWuensche().get(9).getPreis()));
    }
    
    protected void iniListener() {
    	super.initListener();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				initFieldsFromDatabase();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				chckBxEGEssbereichDielen.setSelected(false);
				chckBxEGKuechenbereichDielen.setSelected(false);
				chckBxEGEssbereichParkett.setSelected(false);
				chckBxEGKuechenbereichParkett.setSelected(false);
				chckBxDielenOG.setSelected(false);
				chckBxParkettOG.setSelected(false);
				chckBxDGKomplettDielen.setSelected(false);
				chckBxDGOhneBadbereichDielen.setSelected(false);
				chckBxDGKomplettParkett.setSelected(false);
				chckBxDGOhneBadbereichParkett.setSelected(false);
				txtGesamtpreis.setText("");
			}
		});

	}

	private void initFieldsFromDatabase(){
		Set<SonderwuenscheParkett> kundenWuensche = kunde.getKunde().getSonderwuenscheParkett();
		parkettControl.setAusgewaehlteWuensche(kundenWuensche);
		double summePreis = 0;
		for(SonderwuenscheParkett wunsch: kundenWuensche){
			switch (wunsch.getId()){
				case 1:
					chckBxEGEssbereichDielen.setSelected(true);
					break;
				case 2:
					chckBxEGKuechenbereichDielen.setSelected(true);
					break;
				case 3:
					chckBxEGEssbereichParkett.setSelected(true);
					break;
				case 4:
					chckBxEGKuechenbereichParkett.setSelected(true);
					break;
				case 5:
					chckBxDielenOG.setSelected(true);
					break;
				case 6:
					chckBxParkettOG.setSelected(true);
					break;
				case 7:
					chckBxDGKomplettDielen.setSelected(true);
					break;
				case 8:
					chckBxDGOhneBadbereichDielen.setSelected(true);
					break;
				case 9:
					chckBxDGKomplettParkett.setSelected(true);
					break;
				case 10:
					chckBxDGOhneBadbereichParkett.setSelected(true);
					break;
			}
			summePreis += wunsch.getPreis();
		}
		txtGesamtpreis.setText(String.valueOf(summePreis));

	}
    private void leseParkettSonderwuensche(){
        this.parkettControl.leseParkettSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
		this.parkettControl.setAusgewaehlteWuensche(new HashSet<>());
		boolean selects[] = isSelected();
		for(int i = 0; i<selects.length; i++){
			if(selects[i]){
				this.parkettControl.addAusgewaehltenWuensch(this.parkettControl.getWuensche().get(i));
			}
		}
        if(parkettControl.pruefeKonstellationSonderwuensche()) {
            parkettControl.zeigePreisSonderwuensche();
  			
  	}else {
  	    parkettControl.zeigeFehlerSonderwunsch();
  	}
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
		this.parkettControl.setAusgewaehlteWuensche(new HashSet<>());
		boolean selects[] = isSelected();
		for(int i = 0; i<selects.length; i++){
			if(selects[i]){
				this.parkettControl.addAusgewaehltenWuensch(this.parkettControl.getWuensche().get(i));
			}
		}
		if(parkettControl.pruefeKonstellationSonderwuensche()) {
			kunde.getKunde().setSonderwuenscheParkett(parkettControl.getAusgewaehlteWuensche());
			db.speichereKunden(kunde.getKunde());
		} else {
			parkettControl.zeigeFehlerSonderwunsch();
		}

    }
    

    protected JTextField getTxtGesamtpreis() {
  		return this.txtGesamtpreis;
  		
  	}

  	protected boolean[] isSelected(){
    	boolean[] selects = {false,false,false,false,false,false,false,false,false,false};
    	if(chckBxEGEssbereichDielen.isSelected()){
    		selects[0] = true;
		}
		if(chckBxEGKuechenbereichDielen.isSelected()){
			selects[1] = true;
		}
		if(chckBxEGEssbereichParkett.isSelected()){
			selects[2] = true;
		}
		if(chckBxEGKuechenbereichParkett.isSelected()){
			selects[3] = true;
		}
		if(chckBxDielenOG.isSelected()){
			selects[4] = true;
		}
		if(chckBxParkettOG.isSelected()){
			selects[5] = true;
		}
		if(chckBxDGKomplettDielen.isSelected()){
			selects[6] = true;
		}
		if(chckBxDGOhneBadbereichDielen.isSelected()){
			selects[7] = true;
		}
		if(chckBxDGKomplettParkett.isSelected()){
			selects[8] = true;
		}
		if(chckBxDGOhneBadbereichParkett.isSelected()){
			selects[9] = true;
		}

		return selects;
	}

}
