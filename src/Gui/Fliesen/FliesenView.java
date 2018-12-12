package Gui.Fliesen;

import javax.swing.*;
import Gui.Basis.BasisView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FliesenView extends BasisView {

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des Fliesen-Fensters
    private FliesenControl fliesenControl;

    private int[] auswahl = new int[6];

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblKeinFlieseKuecheEG = new JLabel("Keine Fliesen im Küchenbereich des EG:");
    private JTextField txtPreisKeinFlieseKuecheEG = new JTextField("-590");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblKeinFlieseKuecheEGEuro = new JLabel("Euro");
    private JCheckBox chckBxKeinFlieseKuecheEG = new JCheckBox();

    private JLabel lblKeineFlieseBadOG = new JLabel("Keine Fliesen im Bad des OG:");
    private JTextField txtPreisKeineFlieseBadOG = new JTextField("-1870");
    private JLabel lblKeineFlieseBadOGEuro = new JLabel("Euro");
    private JCheckBox chckBxKeineFlieseBadOG = new JCheckBox();

    private JLabel lblGleichFormatFlieseKuecheEG = new JLabel("Mehrpreis bei großformatige Fliesen im\n" +
            "Küchenbereich des EG:");
    private JTextField txtPreisGleichFormatFlieseKuecheEG = new JTextField("170");
    private JLabel lblGleichFormatFlieseKuecheEGEuro = new JLabel("Euro");
    private JCheckBox chckBxGleichFormatFlieseKuecheEG = new JCheckBox();

    private JLabel lblGleichFormatFlieseBadOG = new JLabel("Mehrpreis bei großformatige Fliesen im Bad des OG:");
    private JTextField txtPreisGleichFormatFlieseBadOG = new JTextField("190");
    private JLabel lblGleichFormatFlieseBadOGEuro = new JLabel("Euro");
    private JCheckBox chckBxGleichFormatFlieseBadOG = new JCheckBox();

    private JLabel lblFliesenBadDG = new JLabel("Fliesen im Bad des DG:");
    private JTextField txtPreisFliesenBadDG = new JTextField("2190");
    private JLabel lblFliesenBadDGEuro = new JLabel("Euro");
    private JCheckBox chckBxFliesenBadDG = new JCheckBox();

    private JLabel lblGroßFliesenBadDG = new JLabel("Mehrpreis bei großformatige Fliesen im Bad des DG:");
    private JTextField txtPreisGroßFliesenBadDG = new JTextField("190");
    private JLabel lblGroßFliesenBadDGEuro = new JLabel("Euro");
    private JCheckBox chckBxGroßFliesenBadDG = new JCheckBox();

    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();


    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein FliesenView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     *
     * @param fliesenControl FliesenControl, enthaelt das zugehoerige Control
     */
    public FliesenView(FliesenControl fliesenControl) {
        this.fliesenControl = fliesenControl;
        this.setTitle("Sonderwünsche zu Fliesen-Varianten");
        this.initKomponenten();
        this.leseFliesenSonderwuensche();
        this.iniListener();
    }


    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten() {
        super.initKomponenten();
        // pnlSonderwunsch wird belegt.
        super.getLblSonderwunsch().setText("Fliesen-Varianten");
        super.getPnlSonderwunsch().add(lblKeinFlieseKuecheEG);
        lblKeinFlieseKuecheEG.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisKeinFlieseKuecheEG);
        txtPreisKeinFlieseKuecheEG.setBounds(350, 50, 80, 25);
        txtPreisKeinFlieseKuecheEG.setEditable(false);
        super.getPnlSonderwunsch().add(lblKeinFlieseKuecheEGEuro);
        lblKeinFlieseKuecheEGEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxKeinFlieseKuecheEG);
        chckBxKeinFlieseKuecheEG.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblKeineFlieseBadOG);
        lblKeineFlieseBadOG.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisKeineFlieseBadOG);
        txtPreisKeineFlieseBadOG.setBounds(350, 75, 80, 25);
        txtPreisKeineFlieseBadOG.setEditable(false);
        super.getPnlSonderwunsch().add(lblKeineFlieseBadOGEuro);
        lblKeineFlieseBadOGEuro.setBounds(440, 75, 50, 25);
        super.getPnlSonderwunsch().add(chckBxKeineFlieseBadOG);
        chckBxKeineFlieseBadOG.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblGleichFormatFlieseKuecheEG);
        lblGleichFormatFlieseKuecheEG.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGleichFormatFlieseKuecheEG);
        txtPreisGleichFormatFlieseKuecheEG.setBounds(350, 100, 80, 25);
        txtPreisGleichFormatFlieseKuecheEG.setEditable(false);
        super.getPnlSonderwunsch().add(lblGleichFormatFlieseKuecheEGEuro);
        lblGleichFormatFlieseKuecheEGEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGleichFormatFlieseKuecheEG);
        chckBxGleichFormatFlieseKuecheEG.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblGleichFormatFlieseBadOG);
        lblGleichFormatFlieseBadOG.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGleichFormatFlieseBadOG);
        txtPreisGleichFormatFlieseBadOG.setBounds(350, 125, 80, 25);
        txtPreisGleichFormatFlieseBadOG.setEditable(false);
        super.getPnlSonderwunsch().add(lblGleichFormatFlieseBadOGEuro);
        lblGleichFormatFlieseBadOGEuro.setBounds(440, 125, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGleichFormatFlieseBadOG);
        chckBxGleichFormatFlieseBadOG.setBounds(470, 125, 25, 25);

        super.getPnlSonderwunsch().add(lblFliesenBadDG);
        lblFliesenBadDG.setBounds(10, 150, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisFliesenBadDG);
        txtPreisFliesenBadDG.setBounds(350, 150, 80, 25);
        txtPreisFliesenBadDG.setEditable(false);
        super.getPnlSonderwunsch().add(lblFliesenBadDGEuro);
        lblFliesenBadDGEuro.setBounds(440, 150, 50, 25);
        super.getPnlSonderwunsch().add(chckBxFliesenBadDG);
        chckBxFliesenBadDG.setBounds(470, 150, 25, 25);

        super.getPnlSonderwunsch().add(lblGroßFliesenBadDG);
        lblGroßFliesenBadDG.setBounds(10, 175, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGroßFliesenBadDG);
        txtPreisGroßFliesenBadDG.setBounds(350, 175, 80, 25);
        txtPreisGroßFliesenBadDG.setEditable(false);
        super.getPnlSonderwunsch().add(lblGroßFliesenBadDGEuro);
        lblGroßFliesenBadDGEuro.setBounds(440, 175, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGroßFliesenBadDG);
        chckBxGroßFliesenBadDG.setBounds(470, 175, 25, 25);

        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(10, 275, 350, 25);
        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(350, 275, 150, 25);
        txtGesamtpreis.setEditable(false);


    }

    protected void iniListener() {
        super.initListener();
        chckBxKeinFlieseKuecheEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = Integer.parseInt(txtPreisKeinFlieseKuecheEG.getText());
                }else {
                    auswahl[0] = 0;
                }

            }
        });
        chckBxKeineFlieseBadOG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = Integer.parseInt(txtPreisKeineFlieseBadOG.getText());
                }else {
                    auswahl[1] = 0;
                }

            }
        });
        chckBxGleichFormatFlieseKuecheEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = Integer.parseInt(txtPreisGleichFormatFlieseKuecheEG.getText());
                }else {
                    auswahl[2] = 0;
                }

            }
        });
        chckBxGleichFormatFlieseBadOG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = Integer.parseInt(txtPreisGleichFormatFlieseBadOG.getText());
                }else {
                    auswahl[3] = 0;
                }

            }
        });
        chckBxFliesenBadDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[4] = Integer.parseInt(txtPreisFliesenBadDG.getText());
                }else {
                    auswahl[4] = 0;
                }

            }
        });
        chckBxGroßFliesenBadDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[5] = Integer.parseInt(txtPreisGroßFliesenBadDG.getText());
                }else {
                    auswahl[5] = 0;
                }

            }
        });

    }

    private void leseFliesenSonderwuensche() {
        this.fliesenControl.leseFliesenSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche() {
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
        fliesenControl.zeigePreisSonderwuensche(auswahl);
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche() {
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
    }
    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }


}
