package Gui.Innentueren;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheInnentueren;

/**
 * Klasse, welche das Fenster fuer die Sonderwuensche zu den Innentueren
 * bereitstellt. 
 * 29.11 : V1 noch keine beruecksichtigung von Menge der Tueren
 * pro Geschoss . Notwendig?! JA
 *
 * 16.12 : V2 label hinzugef�gt, Maske angepasst um Tueren pro geschoss zu ber�cksichtigen
 **/
public class InnentuerenView extends BasisView {

    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[10];
    private int[] anzahl = new int[9];
    private int[] anzahl1 = new int[4];

    private InnentuerenControl innentuerenControl;
    // Definition der grafischen Oberflaeche

    private JCheckBox chckBxKlarGlasInnentuer = new JCheckBox();
    private JCheckBox chckBxMilchglasInnentuer = new JCheckBox();
    private JCheckBox chckBxGaragentuerHolz = new JCheckBox();    
    
    // NEU
    private JLabel lblMaenge = new JLabel("Anzahl");

    private JLabel lblKlarglas = new JLabel("");
    private JLabel lblMilchglas = new JLabel("");
    private JLabel lblHolztuer = new JLabel("");
    private JLabel lblPreis = new JLabel("Preis");
    private JLabel lblKlarglasPreis = new JLabel("");
    private JLabel lblMilchglasPreis = new JLabel("");
    private JLabel lblHolztuerPreis = new JLabel("");

    private JTextField txtKlarglas = new JTextField("0");
    private JTextField txtMilchglas = new JTextField("0");
    private JTextField txtHolztuer = new JTextField("0");
    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();

    public InnentuerenView(InnentuerenControl innentuerenControl) {
        this.innentuerenControl = innentuerenControl;
        this.setTitle("Sonderwuensche zu den Innentueren");
        this.innentuerenControl.setWuensche(db.holeSonderwuenscheInnentueren());
        this.initKomponenten();
        this.iniListener();
        this.leseInnentuerenSonderwuensche();
        
        // NEU
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();
        super.getLblSonderwunsch().setText("Innentueren-Varianten");
        super.getPnlSonderwunsch().setBackground(new Color(255, 255, 255));

        	
        super.getPnlSonderwunsch().add(lblMaenge);
        lblMaenge.setBounds(410, 20, 150, 75);
        super.getPnlSonderwunsch().add(lblPreis);
        lblPreis.setBounds(490, 20, 150, 75);
        super.getPnlSonderwunsch().add(lblKlarglas);
        lblKlarglas.setBounds(10, 60, 400, 75);
        lblKlarglas.setText("<html>" + this.innentuerenControl.getWuensche().get(0).getWunsch() + "</html>");
        super.getPnlSonderwunsch().add(lblMilchglas);
        lblMilchglas.setBounds(10, 100, 400, 75);
        lblMilchglas.setText("<html>" + this.innentuerenControl.getWuensche().get(1).getWunsch() + "</html>");
        super.getPnlSonderwunsch().add(lblHolztuer);
        lblHolztuer.setBounds(10, 140, 400, 75);
        lblHolztuer.setText("<html>" + this.innentuerenControl.getWuensche().get(2).getWunsch() + "</html>");
        super.getPnlSonderwunsch().add(lblKlarglasPreis);
        lblKlarglasPreis.setBounds(490, 60, 150, 75);
        lblKlarglasPreis.setText(String.valueOf(this.innentuerenControl.getWuensche().get(0).getPreis()) + " " + BasisView.currency);
        super.getPnlSonderwunsch().add(lblMilchglasPreis);
        lblMilchglasPreis.setBounds(490, 100, 150, 75);
        lblMilchglasPreis.setText(String.valueOf(this.innentuerenControl.getWuensche().get(1).getPreis()) + " " + BasisView.currency);
        super.getPnlSonderwunsch().add(lblHolztuerPreis);
        lblHolztuerPreis.setBounds(490, 140, 150, 75);
        lblHolztuerPreis.setText(String.valueOf(this.innentuerenControl.getWuensche().get(2).getPreis()) + " " + BasisView.currency);
        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(10, 240, 150, 25);

        super.getPnlSonderwunsch().add(txtKlarglas);
        txtKlarglas.setBounds(410, 80, 40, 25);
        txtKlarglas.setEditable(true);

        super.getPnlSonderwunsch().add(txtMilchglas);
        txtMilchglas.setBounds(410, 120, 40, 25);
        txtMilchglas.setEditable(true);

        super.getPnlSonderwunsch().add(txtHolztuer);
        txtHolztuer.setBounds(410, 160, 40, 25);
        txtHolztuer.setEditable(true);
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
                chckBxKlarGlasInnentuer.setSelected(false);
                chckBxMilchglasInnentuer.setSelected(false);
                chckBxGaragentuerHolz.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });


    }

    private void initFieldsFromDatabase(){
        List<SonderwuenscheInnentueren> kundenWuensche = kunde.getKunde().getSonderwuenscheInnentueren();
        innentuerenControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        txtKlarglas.setText("" + this.innentuerenControl.getAnzahlSonderwunsch(1));
        summePreis += this.innentuerenControl.getAnzahlSonderwunsch(1) * this.innentuerenControl.getWuensche().get(0).getPreis();
        txtMilchglas.setText("" + this.innentuerenControl.getAnzahlSonderwunsch(1));
        summePreis += this.innentuerenControl.getAnzahlSonderwunsch(2) * this.innentuerenControl.getWuensche().get(0).getPreis();
        txtHolztuer.setText("" + this.innentuerenControl.getAnzahlSonderwunsch(1));
        summePreis += this.innentuerenControl.getAnzahlSonderwunsch(3) * this.innentuerenControl.getWuensche().get(0).getPreis();

        txtGesamtpreis.setText(String.valueOf(summePreis));

    }
    
    private void leseInnentuerenSonderwuensche() {
        this.innentuerenControl.leseInnentuerenSonderwuensche();
        
    }

    @Override
    protected void berechneUndZeigePreisSonderwuensche() {

        this.innentuerenControl.setAusgewaehlteWuensche(new ArrayList<>());
        this.innentuerenControl.berechneAnzahl(Integer.parseInt(txtKlarglas.getText()), 0);
        this.innentuerenControl.berechneAnzahl(Integer.parseInt(txtMilchglas.getText()), 1);
        this.innentuerenControl.berechneAnzahl(Integer.parseInt(txtHolztuer.getText()), 2);
    	
        if (innentuerenControl.pruefeKonstellationSonderwuensche()) {
            innentuerenControl.zeigePreisSonderwuensche(auswahl, anzahl);

        } else {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
    }

    @Override
    protected void speichereSonderwuensche() {
        if (innentuerenControl.pruefeKonstellationSonderwuensche()) {
            kunde.getKunde().setSonderwuenscheInnentueren(innentuerenControl.getAusgewaehlteWuensche());
            db.speichereKunden(kunde.getKunde());
        } else {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
    }

    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;
    }
}
