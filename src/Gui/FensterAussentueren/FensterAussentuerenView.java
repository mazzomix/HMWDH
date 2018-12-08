package Gui.FensterAussentueren;

import javax.swing.*;
import Gui.Basis.BasisView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FensterAussentuerenView extends BasisView {

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des FensterAussentueren-Fensters
    private FensterAussentuerenControl fensterAussentuerenControl;

    private int[] auswahl = new int[9];

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblSchiebeTuerEgTerrasse = new JLabel("Schiebetüren im EG zur Terrasse:");
    private JTextField txtPreisSchiebeTuerEgTerrasse = new JTextField("590");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblSchiebeTuerEgTerrasseEuro = new JLabel("Euro");
    private JCheckBox chckBxSchiebeTuerEgTerrasse = new JCheckBox();

    private JLabel lblSchiebeTuerDgTerrasse = new JLabel("Schiebetüren im DG zur Dachterrasse:");
    private JTextField txtPreisSchiebeTuerDgTerrasse = new JTextField("590");
    private JLabel lblSchiebeTuerDgTerrasseEuro = new JLabel("Euro");
    private JCheckBox chckBxSchiebeTuerDgTerrasse = new JCheckBox();

    private JLabel lblEinbruchschutzHaustuer = new JLabel("Erhöhter Einbruchschutz an der Haustür:");
    private JTextField txtPreisEinbruchschutzHaustuer = new JTextField("690");
    private JLabel lblEinbruchschutzHaustuerEuro = new JLabel("Euro");
    private JCheckBox chckBxGrEinbruchschutzHaustuer = new JCheckBox();

    private JLabel lblVorbeitetungElektRollaedenEg = new JLabel("Vorbereitung für elektrische Antriebe Rolläden EG:");
    private JTextField txtPreisVorbeitetungElektRollaedenEg = new JTextField("190");
    private JLabel lblVorbeitetungElektRollaedenEgEuro = new JLabel("Euro");
    private JCheckBox chckBxVorbeitetungElektRollaedenEg = new JCheckBox();

    private JLabel lblVorbeitetungElektRollaedenOg = new JLabel("Vorbereitung für elektrische Antriebe Rolläden OG:");
    private JTextField txtPreisVorbeitetungElektRollaedenOg = new JTextField("190");
    private JLabel lblVorbeitetungElektRollaedenOgEuro = new JLabel("Euro");
    private JCheckBox chckBxVorbeitetungElektRollaedenOg = new JCheckBox();

    private JLabel lblVorbeitetungElektRollaedenDg = new JLabel("Vorbereitung für elektrische Antriebe Rolläden DG:");
    private JTextField txtPreisVorbeitetungElektRollaedenDg = new JTextField("190");
    private JLabel lblVorbeitetungElektRollaedenDgEuro = new JLabel("Euro");
    private JCheckBox chckBxVorbeitetungElektRollaedenDg = new JCheckBox();

    private JLabel lblElektRollaedenEg = new JLabel("Elektrische Rolläden EG:");
    private JTextField txtPreisElektRollaedenEg = new JTextField("990");
    private JLabel lblElektRollaedenEgEuro = new JLabel("Euro");
    private JCheckBox chckBxElektRollaedenEg = new JCheckBox();

    private JLabel lblElektRollaedenOg = new JLabel("Elektrische Rolläden OG:");
    private JTextField txtPreisElektRollaedenOg = new JTextField("990");
    private JLabel lblElektRollaedenOgEuro = new JLabel("Euro");
    private JCheckBox chckBxElektRollaedenOg = new JCheckBox();

    private JLabel lblElektRollaedenDg = new JLabel("Elektrische Rolläden DG::");
    private JTextField txtPreisElektRollaedenDg = new JTextField("990");
    private JLabel lblElektRollaedenDgEuro = new JLabel("Euro");
    private JCheckBox chckBxElektRollaedenDg = new JCheckBox();

    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();

    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein FensterAussentuerenView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     *
     * @param fensterAussentuerenControl FensterAussentuerenControl, enthaelt das zugehoerige Control
     */
    public FensterAussentuerenView(FensterAussentuerenControl fensterAussentuerenControl) {
        this.fensterAussentuerenControl = fensterAussentuerenControl;
        this.setTitle("Sonderwünsche zu FensterAussentueren-Varianten");
        this.initKomponenten();
        this.leseFensterAussentuerenSonderwuensche();
        this.iniListener();
    }


    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten() {
        super.initKomponenten();
        // pnlSonderwunsch wird belegt.
        super.getLblSonderwunsch().setText("FensterAussentueren-Varianten");
        super.getPnlSonderwunsch().add(lblSchiebeTuerEgTerrasse);
        lblSchiebeTuerEgTerrasse.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisSchiebeTuerEgTerrasse);
        txtPreisSchiebeTuerEgTerrasse.setBounds(350, 50, 80, 25);
        txtPreisSchiebeTuerEgTerrasse.setEditable(false);
        super.getPnlSonderwunsch().add(lblSchiebeTuerEgTerrasseEuro);
        lblSchiebeTuerEgTerrasseEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxSchiebeTuerEgTerrasse);
        chckBxSchiebeTuerEgTerrasse.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblSchiebeTuerDgTerrasse);
        lblSchiebeTuerDgTerrasse.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisSchiebeTuerDgTerrasse);
        txtPreisSchiebeTuerDgTerrasse.setBounds(350, 75, 80, 25);
        txtPreisSchiebeTuerDgTerrasse.setEditable(false);
        super.getPnlSonderwunsch().add(lblSchiebeTuerDgTerrasseEuro);
        lblSchiebeTuerDgTerrasseEuro.setBounds(440, 75, 50, 25);
        super.getPnlSonderwunsch().add(chckBxSchiebeTuerDgTerrasse);
        chckBxSchiebeTuerDgTerrasse.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblEinbruchschutzHaustuer);
        lblEinbruchschutzHaustuer.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEinbruchschutzHaustuer);
        txtPreisEinbruchschutzHaustuer.setBounds(350, 100, 80, 25);
        txtPreisEinbruchschutzHaustuer.setEditable(false);
        super.getPnlSonderwunsch().add(lblEinbruchschutzHaustuerEuro);
        lblEinbruchschutzHaustuerEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGrEinbruchschutzHaustuer);
        chckBxGrEinbruchschutzHaustuer.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenEg);
        lblVorbeitetungElektRollaedenEg.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisVorbeitetungElektRollaedenEg);
        txtPreisVorbeitetungElektRollaedenEg.setBounds(350, 125, 80, 25);
        txtPreisVorbeitetungElektRollaedenEg.setEditable(false);
        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenEgEuro);
        lblVorbeitetungElektRollaedenEgEuro.setBounds(440, 125, 50, 25);
        super.getPnlSonderwunsch().add(chckBxVorbeitetungElektRollaedenEg);
        chckBxVorbeitetungElektRollaedenEg.setBounds(470, 125, 25, 25);

        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenOg);
        lblVorbeitetungElektRollaedenOg.setBounds(10, 150, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisVorbeitetungElektRollaedenOg);
        txtPreisVorbeitetungElektRollaedenOg.setBounds(350, 150, 80, 25);
        txtPreisVorbeitetungElektRollaedenOg.setEditable(false);
        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenOgEuro);
        lblVorbeitetungElektRollaedenOgEuro.setBounds(440, 150, 50, 25);
        super.getPnlSonderwunsch().add(chckBxVorbeitetungElektRollaedenOg);
        chckBxVorbeitetungElektRollaedenOg.setBounds(470, 150, 25, 25);

        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenDg);
        lblVorbeitetungElektRollaedenDg.setBounds(10, 175, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisVorbeitetungElektRollaedenDg);
        txtPreisVorbeitetungElektRollaedenDg.setBounds(350, 175, 80, 25);
        txtPreisVorbeitetungElektRollaedenDg.setEditable(false);
        super.getPnlSonderwunsch().add(lblVorbeitetungElektRollaedenDgEuro);
        lblVorbeitetungElektRollaedenDgEuro.setBounds(440, 175, 50, 25);
        super.getPnlSonderwunsch().add(chckBxVorbeitetungElektRollaedenDg);
        chckBxVorbeitetungElektRollaedenDg.setBounds(470, 175, 25, 25);

        super.getPnlSonderwunsch().add(lblElektRollaedenEg);
        lblElektRollaedenEg.setBounds(10, 200, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisElektRollaedenEg);
        txtPreisElektRollaedenEg.setBounds(350, 200, 80, 25);
        txtPreisElektRollaedenEg.setEditable(false);
        super.getPnlSonderwunsch().add(lblElektRollaedenEgEuro);
        lblElektRollaedenEgEuro.setBounds(440, 200, 50, 25);
        super.getPnlSonderwunsch().add(chckBxElektRollaedenEg);
        chckBxElektRollaedenEg.setBounds(470, 200, 25, 25);

        super.getPnlSonderwunsch().add(lblElektRollaedenOg);
        lblElektRollaedenOg.setBounds(10, 225, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisElektRollaedenOg);
        txtPreisElektRollaedenOg.setBounds(350, 225, 80, 25);
        txtPreisElektRollaedenOg.setEditable(false);
        super.getPnlSonderwunsch().add(lblElektRollaedenOgEuro);
        lblElektRollaedenOgEuro.setBounds(440, 225, 50, 25);
        super.getPnlSonderwunsch().add(chckBxElektRollaedenOg);
        chckBxElektRollaedenOg.setBounds(470, 225, 25, 25);

        super.getPnlSonderwunsch().add(lblElektRollaedenDg);
        lblElektRollaedenDg.setBounds(10, 250, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisElektRollaedenDg);
        txtPreisElektRollaedenDg.setBounds(350, 250, 80, 25);
        txtPreisElektRollaedenDg.setEditable(false);
        super.getPnlSonderwunsch().add(lblElektRollaedenDgEuro);
        lblElektRollaedenDgEuro.setBounds(440, 250, 50, 25);
        super.getPnlSonderwunsch().add(chckBxElektRollaedenDg);
        chckBxElektRollaedenDg.setBounds(470, 250, 25, 25);

        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(10, 275, 350, 25);
        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(350, 275, 150, 25);
        txtGesamtpreis.setEditable(false);
    }

    protected void iniListener() {
        super.initListener();
        chckBxSchiebeTuerEgTerrasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = Integer.parseInt(txtPreisSchiebeTuerEgTerrasse.getText());
                }else {
                    auswahl[0] = 0;
                }

            }
        });
        chckBxSchiebeTuerDgTerrasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = Integer.parseInt(txtPreisSchiebeTuerDgTerrasse.getText());
                }else {
                    auswahl[1] = 0;
                }

            }
        });
        chckBxGrEinbruchschutzHaustuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = Integer.parseInt(txtPreisEinbruchschutzHaustuer.getText());
                }else {
                    auswahl[2] = 0;
                }

            }
        });
        chckBxVorbeitetungElektRollaedenEg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = Integer.parseInt(txtPreisVorbeitetungElektRollaedenEg.getText());
                }else {
                    auswahl[3] = 0;
                }

            }
        });
        chckBxVorbeitetungElektRollaedenOg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[4] = Integer.parseInt(txtPreisVorbeitetungElektRollaedenOg.getText());
                }else {
                    auswahl[4] = 0;
                }

            }
        });
        chckBxVorbeitetungElektRollaedenDg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[5] = Integer.parseInt(txtPreisVorbeitetungElektRollaedenDg.getText());
                }else {
                    auswahl[5] = 0;
                }

            }
        });
        chckBxElektRollaedenEg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[6] = Integer.parseInt(txtPreisElektRollaedenEg.getText());
                }else {
                    auswahl[6] = 0;
                }

            }
        });
        chckBxElektRollaedenOg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[7] = Integer.parseInt(txtPreisElektRollaedenOg.getText());
                }else {
                    auswahl[7] = 0;
                }

            }
        });
        chckBxElektRollaedenDg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[8] = Integer.parseInt(txtPreisElektRollaedenDg.getText());
                }else {
                    auswahl[8] = 0;
                }

            }
        });
    }

    private void leseFensterAussentuerenSonderwuensche() {
        this.fensterAussentuerenControl.leseFensterAussentuerenSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche() {
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
        fensterAussentuerenControl.zeigePreisSonderwuensche(auswahl);
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
