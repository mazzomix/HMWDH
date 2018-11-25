package Gui.Grundriss;

import Gui.Basis.BasisView;
import javax.swing.*;
import Business.Kunde.KundeModel;


/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView{

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des Grundriss-Fensters
    private GrundrissControl grundrissControl;

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblWandKueche
            = new JLabel("Wand zur Abtrennung der Küche von dem Essbereich");
    private JTextField txtPreisWandKueche = new JTextField();
    private JLabel lblWandKuecheEuro = new JLabel("Euro");
    private JCheckBox chckBxWandKueche = new JCheckBox();
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
