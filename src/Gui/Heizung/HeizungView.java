package Gui.Heizung;

import Gui.Basis.BasisView;
import Gui.Heizung.HeizungControl;
import HibernateCont.SonderwuenscheHeizung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

public class HeizungView extends BasisView {

    public static final long serialVersionUID = 1L;

    // das Control-Objekt des Heizung-Fensters
    private HeizungControl HeizungControl;

    private double[] auswahl = new double[6];

    //---Anfang Attribute der grafischen Oberflaeche---
    private JLabel lblZusaetzlichHeizung = new JLabel("");
    private JTextField txtPreisZusaetzlichHeizung = new JTextField("");                                  //String Preis wird später direkt aus der Datenbank gelesen
    private JLabel lblZusaetzlichHeizungEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxZusaetzlichHeizung = new JCheckBox();

    private JLabel lblGlatteOberflaeche = new JLabel("");
    private JTextField txtPreisGlatteOberflaeche = new JTextField("");
    private JLabel lblGlatteOberflaecheEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxGlatteOberflaeche = new JCheckBox();

    private JLabel lblHandtuchHeizkoerper = new JLabel("");
    private JTextField txtPreisHandtuchHeizkoerper = new JTextField("");
    private JLabel lblHandtuchHeizkoerperEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxHandtuchHeizkoerper = new JCheckBox();

    private JLabel lblFussbodenheizungOhneDG = new JLabel("");
    private JTextField txtPreisFussbodenheizungOhneDG = new JTextField("");
    private JLabel lblPreisFussbodenheizungOhneDGOGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxPreisFussbodenheizungOhneDG = new JCheckBox();

    private JLabel lblFussbodenheizungMitDG = new JLabel("");
    private JTextField txtPreisFussbodenheizungMitDG = new JTextField("");
    private JLabel lblFussbodenheizungMitDGEuro = new JLabel(BasisView.currency);
    private JCheckBox chckBxFussbodenheizungMitDG = new JCheckBox();


    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();


    //-------Ende Attribute der grafischen Oberflaeche-------

    /**
     * erzeugt ein HeizungView-Objekt, belegt das zugehoerige Model und Control
     * mit den vorgegebenen Objekten und initialisiert die Steuerelemente der Maske
     *
     * @param HeizungControl HeizungControl, enthaelt das zugehoerige Control
     */
    public HeizungView(HeizungControl HeizungControl) {
        this.HeizungControl = HeizungControl;
        this.setTitle("Sonderwünsche zu Heizung-Varianten");
        this.HeizungControl.setWuensche(db.holeSonderwuenscheHeizung());
        this.initKomponenten();
        this.leseHeizungSonderwuensche();
        this.iniListener();
    }


    /* initialisiert die Steuerelemente auf der Maske */
    protected void initKomponenten() {
        super.initKomponenten();
        // pnlSonderwunsch wird belegt.
        super.getLblSonderwunsch().setText("Heizung-Varianten");
        super.getPnlSonderwunsch().add(lblZusaetzlichHeizung);
        lblZusaetzlichHeizung.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisZusaetzlichHeizung);
        txtPreisZusaetzlichHeizung.setBounds(350, 50, 80, 25);
        txtPreisZusaetzlichHeizung.setEditable(false);
        super.getPnlSonderwunsch().add(lblZusaetzlichHeizungEuro);
        lblZusaetzlichHeizungEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxZusaetzlichHeizung);
        chckBxZusaetzlichHeizung.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblGlatteOberflaeche);
        lblGlatteOberflaeche.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGlatteOberflaeche);
        txtPreisGlatteOberflaeche.setBounds(350, 75, 80, 25);
        txtPreisGlatteOberflaeche.setEditable(false);
        super.getPnlSonderwunsch().add(lblGlatteOberflaecheEuro);
        lblGlatteOberflaecheEuro.setBounds(440, 75, 50, 25);
        super.getPnlSonderwunsch().add(chckBxGlatteOberflaeche);
        chckBxGlatteOberflaeche.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblHandtuchHeizkoerper);
        lblHandtuchHeizkoerper.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisHandtuchHeizkoerper);
        txtPreisHandtuchHeizkoerper.setBounds(350, 100, 80, 25);
        txtPreisHandtuchHeizkoerper.setEditable(false);
        super.getPnlSonderwunsch().add(lblHandtuchHeizkoerperEuro);
        lblHandtuchHeizkoerperEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxHandtuchHeizkoerper);
        chckBxHandtuchHeizkoerper.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblFussbodenheizungOhneDG);
        lblFussbodenheizungOhneDG.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisFussbodenheizungOhneDG);
        txtPreisFussbodenheizungOhneDG.setBounds(350, 125, 80, 25);
        txtPreisFussbodenheizungOhneDG.setEditable(false);
        super.getPnlSonderwunsch().add(lblPreisFussbodenheizungOhneDGOGEuro);
        lblPreisFussbodenheizungOhneDGOGEuro.setBounds(440, 125, 50, 25);
        super.getPnlSonderwunsch().add(chckBxPreisFussbodenheizungOhneDG);
        chckBxPreisFussbodenheizungOhneDG.setBounds(470, 125, 25, 25);

        super.getPnlSonderwunsch().add(lblFussbodenheizungMitDG);
        lblFussbodenheizungMitDG.setBounds(10, 150, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisFussbodenheizungMitDG);
        txtPreisFussbodenheizungMitDG.setBounds(350, 150, 80, 25);
        txtPreisFussbodenheizungMitDG.setEditable(false);
        super.getPnlSonderwunsch().add(lblFussbodenheizungMitDGEuro);
        lblFussbodenheizungMitDGEuro.setBounds(440, 150, 50, 25);
        super.getPnlSonderwunsch().add(chckBxFussbodenheizungMitDG);
        chckBxFussbodenheizungMitDG.setBounds(470, 150, 25, 25);


        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(10, 275, 350, 25);
        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(350, 275, 150, 25);
        txtGesamtpreis.setEditable(false);


        lblZusaetzlichHeizung.setText(HeizungControl.getWuensche().get(0).getWunsch());
        txtPreisZusaetzlichHeizung.setText(String.valueOf(HeizungControl.getWuensche().get(0).getPreis()));
        lblGlatteOberflaeche.setText(HeizungControl.getWuensche().get(1).getWunsch());
        txtPreisGlatteOberflaeche.setText(String.valueOf(HeizungControl.getWuensche().get(1).getPreis()));
        lblHandtuchHeizkoerper.setText(HeizungControl.getWuensche().get(2).getWunsch());
        txtPreisHandtuchHeizkoerper.setText(String.valueOf(HeizungControl.getWuensche().get(2).getPreis()));
        lblFussbodenheizungOhneDG.setText(String.valueOf(HeizungControl.getWuensche().get(3).getWunsch()));
        txtPreisFussbodenheizungOhneDG.setText(String.valueOf(HeizungControl.getWuensche().get(3).getPreis()));
        lblFussbodenheizungMitDG.setText(String.valueOf(HeizungControl.getWuensche().get(4).getWunsch()));
        txtPreisFussbodenheizungMitDG.setText(String.valueOf(HeizungControl.getWuensche().get(4).getPreis()));
    }

    protected void iniListener() {
        super.initListener();
        chckBxZusaetzlichHeizung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = HeizungControl.getWuensche().get(0).getPreis();
                    HeizungControl.addAusgewaehltenWuensch(HeizungControl.getWuensche().get(0));
                }else {
                    auswahl[0] = 0;
                    HeizungControl.removeAusgewaehltenWunsch(HeizungControl.getWuensche().get(0).getId());
                }

            }
        });
        chckBxGlatteOberflaeche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = HeizungControl.getWuensche().get(1).getPreis();
                    HeizungControl.addAusgewaehltenWuensch(HeizungControl.getWuensche().get(1));
                }else {
                    auswahl[1] = 0;
                    HeizungControl.removeAusgewaehltenWunsch(HeizungControl.getWuensche().get(1).getId());
                }

            }
        });
        chckBxHandtuchHeizkoerper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = HeizungControl.getWuensche().get(2).getPreis();
                    HeizungControl.addAusgewaehltenWuensch(HeizungControl.getWuensche().get(2));
                }else {
                    auswahl[2] = 0;
                    HeizungControl.removeAusgewaehltenWunsch(HeizungControl.getWuensche().get(2).getId());
                }

            }
        });
        chckBxPreisFussbodenheizungOhneDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = HeizungControl.getWuensche().get(3).getPreis();
                    HeizungControl.addAusgewaehltenWuensch(HeizungControl.getWuensche().get(3));
                }else {
                    auswahl[3] = 0;
                    HeizungControl.removeAusgewaehltenWunsch(HeizungControl.getWuensche().get(3).getId());
                }

            }
        });
        chckBxFussbodenheizungMitDG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[4] = HeizungControl.getWuensche().get(4).getPreis();
                    HeizungControl.addAusgewaehltenWuensch(HeizungControl.getWuensche().get(4));
                }else {
                    auswahl[4] = 0;
                    HeizungControl.removeAusgewaehltenWunsch(HeizungControl.getWuensche().get(4).getId());
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
                chckBxZusaetzlichHeizung.setSelected(false);
                chckBxGlatteOberflaeche.setSelected(false);
                chckBxHandtuchHeizkoerper.setSelected(false);
                chckBxPreisFussbodenheizungOhneDG.setSelected(false);
                chckBxFussbodenheizungMitDG.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });

    }

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheHeizung> kundenWuensche = kunde.getKunde().getSonderwuenscheHeizung();
        HeizungControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheHeizung wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxZusaetzlichHeizung.setSelected(true);
                    break;
                case 2:
                    chckBxGlatteOberflaeche.setSelected(true);
                    break;
                case 3:
                    chckBxHandtuchHeizkoerper.setSelected(true);
                    break;
                case 4:
                    chckBxPreisFussbodenheizungOhneDG.setSelected(true);
                    break;
                case 5:
                    chckBxFussbodenheizungMitDG.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

    }

    private void leseHeizungSonderwuensche() {
        this.HeizungControl.leseHeizungSonderwuensche();
    }

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected void berechneUndZeigePreisSonderwuensche() {
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann der Preis berechnet.
        HeizungControl.zeigePreisSonderwuensche(auswahl);
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche() {
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.

        kunde.getKunde().setSonderwuenscheHeizung(HeizungControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde(), kunde.getKunde().getHausnummer().getId());
    }
    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }


}