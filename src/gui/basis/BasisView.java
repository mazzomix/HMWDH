package gui.basis;

import java.awt.*;
import javax.swing.*;
import business.kunde.KundeModel;

/**
 * Klasse, welche die Basis fuer die Fenster zu den Sonderwuenschen bereitstellt.
 */
public abstract class BasisView extends JFrame{
 
	public static final long serialVersionUID = 1L;
   
    //---Anfang Attribute der grafischen Oberflaeche---
    private JPanel pnlSonderwunsch 	 = new JPanel();
  	private JLabel lblSonderwunsch   = new JLabel("Sonderwunsch");
    private JButton btnBerechnen 	 = new JButton("Preis berechnen");
    private JButton btnSpeichern 	 = new JButton("Speichern");
    private JMenuBar mnBar 			 = new JMenuBar();
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    private KundeModel kundeModel;
    
    /**
     * erzeugt ein BasisView-Objekt
    */
    public BasisView (KundeModel kundeModel){
    	this.kundeModel = kundeModel;
       	this.setSize(550,400);
	    this.setLayout(null);
	    this.setLocation(400, 200);
        this.initListener();
    }


    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten(){
    	// pnlSonderwunsch wird erzeugt.
    	this.add(pnlSonderwunsch);
    	pnlSonderwunsch.setBounds(10, 10, 510, 270);
    	pnlSonderwunsch.setLayout(null);
    	pnlSonderwunsch.setBackground(new Color(255, 255, 102));
    	pnlSonderwunsch.add(lblSonderwunsch);
	    lblSonderwunsch.setFont(new Font("Arial", Font.BOLD, 24));
	    lblSonderwunsch.setBounds(10,10,300,40);
	    // Buttons
	    this.add(btnBerechnen);
	    btnBerechnen.setBounds(210, 300, 150, 25);
	    this.add(btnSpeichern);
	    btnSpeichern.setBounds(370, 300, 150, 25);
	    // MenuBar und Menu
	    this.setJMenuBar(mnBar);
    }  
    
    /* Es muessen die Listener implementiert werden. */
    protected void initListener(){
       	btnBerechnen.addActionListener(aEvent -> {
    		berechneUndZeigePreisSonderwuensche();
     	});
        btnSpeichern.addActionListener(aEvent -> {
    		speichereSonderwuensche();
    	});
    }
    
    protected JPanel getPnlSonderwunsch() {
  		return pnlSonderwunsch;
  	}

  	protected JLabel getLblSonderwunsch() {
  		return lblSonderwunsch;
  	}
  	     	
  	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
  	protected abstract void berechneUndZeigePreisSonderwuensche();
  	
   	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
  	protected abstract void speichereSonderwuensche();
  	
 	
}
