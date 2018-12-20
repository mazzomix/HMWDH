package Gui.FensterAussentueren;

import javax.swing.*;
import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheFensterAussentueren;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Set;

public class FensterAussentuerenView extends BasisView {

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des FensterAussentueren-Fensters
    private FensterAussentuerenControl fensterAussentuerenControl;

    private double[] auswahl = new double[9];

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
        this.fensterAussentuerenControl.setWuensche(db.holeSonderwuenscheFensterAussentueren());
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
                    auswahl[0] = fensterAussentuerenControl.getWuensche().get(0).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(0));
                }else {
                    auswahl[0] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(0).getId());
                }
            }
        });
        chckBxSchiebeTuerDgTerrasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = fensterAussentuerenControl.getWuensche().get(1).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(1));
                }else {
                    auswahl[1] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(1).getId());
                }

            }
        });
        chckBxGrEinbruchschutzHaustuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = fensterAussentuerenControl.getWuensche().get(2).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(2));
                }else {
                    auswahl[2] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(2).getId());
            }

            }
        });
        chckBxVorbeitetungElektRollaedenEg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = fensterAussentuerenControl.getWuensche().get(3).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(3));
                }else {
                    auswahl[3] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(3).getId());
                }

            }
        });
        chckBxVorbeitetungElektRollaedenOg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[4] = fensterAussentuerenControl.getWuensche().get(4).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(4));
                }else {
                    auswahl[4] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(4).getId());
                }

            }
        });
        chckBxVorbeitetungElektRollaedenDg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[5] = fensterAussentuerenControl.getWuensche().get(5).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(5));
                }else {
                    auswahl[5] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(5).getId());
                }

            }
        });
        chckBxElektRollaedenEg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[6] = fensterAussentuerenControl.getWuensche().get(6).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(6));
                }else {
                    auswahl[6] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(6).getId());
                }

            }
        });
        chckBxElektRollaedenOg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[7] = fensterAussentuerenControl.getWuensche().get(7).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(7));
                }else {
                    auswahl[7] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(7).getId());
                }

            }
        });
        chckBxElektRollaedenDg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[8] = fensterAussentuerenControl.getWuensche().get(8).getPreis();
                    fensterAussentuerenControl.addAusgewaehltenWuensch(fensterAussentuerenControl.getWuensche().get(8));
                }else {
                    auswahl[8] = 0;
                    fensterAussentuerenControl.removeAusgewaehltenWunsch(fensterAussentuerenControl.getWuensche().get(8).getId());
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                initFieldsFromDatabase();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                chckBxSchiebeTuerEgTerrasse.setSelected(false);
                chckBxSchiebeTuerDgTerrasse.setSelected(false);
                chckBxGrEinbruchschutzHaustuer.setSelected(false);
                chckBxVorbeitetungElektRollaedenEg.setSelected(false);
                chckBxVorbeitetungElektRollaedenOg.setSelected(false);
                chckBxVorbeitetungElektRollaedenDg.setSelected(false);
                chckBxElektRollaedenEg.setSelected(false);
                chckBxElektRollaedenOg.setSelected(false);
                chckBxElektRollaedenDg.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });
    }

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheFensterAussentueren> kundenWuensche = kunde.getKunde().getSonderwuenscheFensterAussentueren();
        fensterAussentuerenControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheFensterAussentueren wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxSchiebeTuerEgTerrasse.setSelected(true);
                    break;
                case 2:
                    chckBxSchiebeTuerDgTerrasse.setSelected(true);
                    break;
                case 3:
                    chckBxGrEinbruchschutzHaustuer.setSelected(true);
                    break;
                case 4:
                    chckBxVorbeitetungElektRollaedenEg.setSelected(true);
                    break;
                case 5:
                    chckBxVorbeitetungElektRollaedenOg.setSelected(true);
                    break;
                case 6:
                    chckBxVorbeitetungElektRollaedenDg.setSelected(true);
                    break;
                case 7:
                    chckBxElektRollaedenEg.setSelected(true);
                    break;
                case 8:
                    chckBxElektRollaedenOg.setSelected(true);
                    break;
                case 9:
                    chckBxElektRollaedenDg.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

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
        kunde.getKunde().setSonderwuenscheFensterAussentueren(fensterAussentuerenControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde());
    }
    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }
}
