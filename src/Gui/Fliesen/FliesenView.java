package Gui.Fliesen;

import javax.swing.*;
import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheFliesen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

public class FliesenView extends BasisView {

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des Fliesen-Fensters
    private FliesenControl fliesenControl;

    private double[] auswahl = new double[6];

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblKeinFlieseKuecheEG = new JLabel("");
    private JTextField txtPreisKeinFlieseKuecheEG = new JTextField("");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblKeinFlieseKuecheEGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxKeinFlieseKuecheEG = new JCheckBox();

    private JLabel lblKeineFlieseBadOG = new JLabel("");
    private JTextField txtPreisKeineFlieseBadOG = new JTextField("");
    private JLabel lblKeineFlieseBadOGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxKeineFlieseBadOG = new JCheckBox();

    private JLabel lblGroßFormatFlieseKuecheEG = new JLabel("");
    private JTextField txtPreisGroßFormatFlieseKuecheEG = new JTextField("");
    private JLabel lblGleichFormatFlieseKuecheEGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxGleichFormatFlieseKuecheEG = new JCheckBox();

    private JLabel lblGroßFormatFlieseBadOG = new JLabel("");
    private JTextField txtPreisGroßFormatFlieseBadOG = new JTextField("");
    private JLabel lblGleichFormatFlieseBadOGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxGleichFormatFlieseBadOG = new JCheckBox();

    private JLabel lblFliesenBadDG = new JLabel("");
    private JTextField txtPreisFliesenBadDG = new JTextField("");
    private JLabel lblFliesenBadDGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxFliesenBadDG = new JCheckBox();

    private JLabel lblGroßFliesenBadDG = new JLabel("");
    private JTextField txtPreisGroßFliesenBadDG = new JTextField("");
    private JLabel lblGroßFliesenBadDGEuro = new JLabel(BasisView.currency);
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
        this.fliesenControl.setWuensche(db.holeSonderwuenscheFliesen());
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

        super.getPnlSonderwunsch().add(lblGroßFormatFlieseKuecheEG);
        lblGroßFormatFlieseKuecheEG.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGroßFormatFlieseKuecheEG);
        txtPreisGroßFormatFlieseKuecheEG.setBounds(350, 100, 80, 25);
        txtPreisGroßFormatFlieseKuecheEG.setEditable(false);
        super.getPnlSonderwunsch().add(lblGleichFormatFlieseKuecheEGEuro);
        lblGleichFormatFlieseKuecheEGEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGleichFormatFlieseKuecheEG);
        chckBxGleichFormatFlieseKuecheEG.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblGroßFormatFlieseBadOG);
        lblGroßFormatFlieseBadOG.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGroßFormatFlieseBadOG);
        txtPreisGroßFormatFlieseBadOG.setBounds(350, 125, 80, 25);
        txtPreisGroßFormatFlieseBadOG.setEditable(false);
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


        lblKeinFlieseKuecheEG.setText(fliesenControl.getWuensche().get(0).getWunsch());
        txtPreisKeinFlieseKuecheEG.setText(String.valueOf(fliesenControl.getWuensche().get(0).getPreis()));
        lblKeineFlieseBadOG.setText(fliesenControl.getWuensche().get(1).getWunsch());
        txtPreisKeineFlieseBadOG.setText(String.valueOf(fliesenControl.getWuensche().get(1).getPreis()));
        lblGroßFormatFlieseKuecheEG.setText(fliesenControl.getWuensche().get(2).getWunsch());
        txtPreisGroßFormatFlieseKuecheEG.setText(String.valueOf(fliesenControl.getWuensche().get(2).getPreis()));
        lblGroßFormatFlieseBadOG.setText(String.valueOf(fliesenControl.getWuensche().get(3).getWunsch()));
        txtPreisGroßFormatFlieseBadOG.setText(String.valueOf(fliesenControl.getWuensche().get(3).getPreis()));
        lblFliesenBadDG.setText(String.valueOf(fliesenControl.getWuensche().get(4).getWunsch()));
        txtPreisFliesenBadDG.setText(String.valueOf(fliesenControl.getWuensche().get(4).getPreis()));
        lblGroßFliesenBadDG.setText(String.valueOf(fliesenControl.getWuensche().get(5).getWunsch()));
        txtPreisGroßFliesenBadDG.setText(String.valueOf(fliesenControl.getWuensche().get(5).getPreis()));
    }

    protected void iniListener() {
        super.initListener();
        chckBxKeinFlieseKuecheEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = fliesenControl.getWuensche().get(0).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(0));
                }else {
                    auswahl[0] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(0).getId());
                }

            }
        });
        chckBxKeineFlieseBadOG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = fliesenControl.getWuensche().get(1).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(1));
                }else {
                    auswahl[1] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(1).getId());
                }

            }
        });
        chckBxGleichFormatFlieseKuecheEG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = fliesenControl.getWuensche().get(2).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(2));
                }else {
                    auswahl[2] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(2).getId());
                }

            }
        });
        chckBxGleichFormatFlieseBadOG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = fliesenControl.getWuensche().get(3).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(3));
                }else {
                    auswahl[3] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(3).getId());
                }

            }
        });
        chckBxFliesenBadDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[4] = fliesenControl.getWuensche().get(4).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(4));
                }else {
                    auswahl[4] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(4).getId());
                }

            }
        });
        chckBxGroßFliesenBadDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[5] = fliesenControl.getWuensche().get(5).getPreis();
                    fliesenControl.addAusgewaehltenWuensch(fliesenControl.getWuensche().get(5));
                }else {
                    auswahl[5] = 0;
                    fliesenControl.removeAusgewaehltenWunsch(fliesenControl.getWuensche().get(5).getId());
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
                chckBxKeinFlieseKuecheEG.setSelected(false);
                chckBxKeineFlieseBadOG.setSelected(false);
                chckBxGleichFormatFlieseKuecheEG.setSelected(false);
                chckBxGleichFormatFlieseBadOG.setSelected(false);
                chckBxFliesenBadDG.setSelected(false);
                chckBxGroßFliesenBadDG.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });

    }

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheFliesen> kundenWuensche = kunde.getKunde().getSonderwuenscheFliesen();
        fliesenControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheFliesen wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxKeinFlieseKuecheEG.setSelected(true);
                    break;
                case 2:
                    chckBxKeineFlieseBadOG.setSelected(true);
                    break;
                case 3:
                    chckBxGleichFormatFlieseKuecheEG.setSelected(true);
                    break;
                case 4:
                    chckBxGleichFormatFlieseBadOG.setSelected(true);
                    break;
                case 5:
                    chckBxFliesenBadDG.setSelected(true);
                    break;
                case 6:
                    chckBxGroßFliesenBadDG.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

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

        kunde.getKunde().setSonderwuenscheFliesen(fliesenControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde(), kunde.getKunde().getHausnummer().getId());
    }
    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }


}
