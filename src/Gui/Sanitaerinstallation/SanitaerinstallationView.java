package Gui.Sanitaerinstallation;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheSanitaerinstallation;

import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;


public class SanitaerinstallationView extends  BasisView {
    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[6];
    private SanitaerinstallationControl sanitaerinstallationControl;

    private JLabel lblOGGrößeresWaschbecken = new JLabel();
    private JTextField txtPreisOGGrößeresWaschbecken = new JTextField();
    private JLabel lblOGGrößeresWaschbeckenEuro = new JLabel("Euro");
    public JCheckBox chckBxOGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblDGGrößeresWaschbecken = new JLabel();
    private JTextField txtPreisDGGrößeresWaschbecken = new JTextField();
    private JLabel lblDGGrößeresWaschbeckenEuro = new JLabel("Euro");
    public JCheckBox chckBxDGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblOGBodentiefeDusche = new JLabel();
    private JTextField txtPreisOGBodentiefeDusche = new JTextField();
    private JLabel lblOGBodentiefeDuscheEuro = new JLabel("Euro");
    public JCheckBox chckBxOGBodentiefeDusche = new JCheckBox();

    private JLabel lblDGBodentiefeDusche = new JLabel();
    private JTextField txtPreisDGBodentiefeDusche = new JTextField();
    private JLabel lblDGBodentiefeDuscheEuro = new JLabel("Euro");
    public JCheckBox chckBxDGBodentiefeDusche = new JCheckBox();

    private JLabel txtGesamtpreis = new JLabel("Gesamtpreis");





    public SanitaerinstallationView(SanitaerinstallationControl sanitaerinstallationControl){
        this.sanitaerinstallationControl = sanitaerinstallationControl;
        this.setTitle("Sonderwünsche zu Sanitaerinstallation-Varianten");
        this.sanitaerinstallationControl.setWuensche(db.holeSonderwuenscheSanitaerinstallation());
        this.initKomponenten();
        this.leseSanitaerinstallationSonderwuensche();
        this.iniListener();
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();

        super.getLblSonderwunsch().setText("Sanitaerinstallation-Varianten");
        super.getPnlSonderwunsch().add(lblOGGrößeresWaschbecken);
        lblOGGrößeresWaschbecken.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisOGGrößeresWaschbecken);
        txtPreisOGGrößeresWaschbecken.setBounds(350, 50, 80, 25);
        txtPreisOGGrößeresWaschbecken.setEditable(false);
        super.getPnlSonderwunsch().add(lblOGGrößeresWaschbeckenEuro);
        lblOGGrößeresWaschbeckenEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxOGGrößeresWaschbecken);
        chckBxOGGrößeresWaschbecken.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblDGGrößeresWaschbecken);
        lblDGGrößeresWaschbecken.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisDGGrößeresWaschbecken);
        txtPreisDGGrößeresWaschbecken.setBounds(350, 75, 80, 25);
        txtPreisDGGrößeresWaschbecken.setEditable(false);
        super.getPnlSonderwunsch().add(lblDGGrößeresWaschbeckenEuro);
        lblDGGrößeresWaschbeckenEuro.setBounds(440, 75, 50, 25);
        super.getPnlSonderwunsch().add(chckBxDGGrößeresWaschbecken);
        chckBxDGGrößeresWaschbecken.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblOGBodentiefeDusche);
        lblOGBodentiefeDusche.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisOGBodentiefeDusche);
        txtPreisOGBodentiefeDusche.setBounds(350, 100, 80, 25);
        txtPreisOGBodentiefeDusche.setEditable(false);
        super.getPnlSonderwunsch().add(lblOGBodentiefeDuscheEuro);
        lblOGBodentiefeDuscheEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxOGBodentiefeDusche);
        chckBxOGBodentiefeDusche.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblDGBodentiefeDusche);
        lblDGBodentiefeDusche.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisDGBodentiefeDusche);
        txtPreisDGBodentiefeDusche.setBounds(350, 125, 80, 25);
        txtPreisDGBodentiefeDusche.setEditable(false);
        super.getPnlSonderwunsch().add(lblDGBodentiefeDuscheEuro);
        lblDGBodentiefeDuscheEuro.setBounds(440, 125, 50, 25);
        super.getPnlSonderwunsch().add(chckBxDGBodentiefeDusche);
        chckBxDGBodentiefeDusche.setBounds(470, 125, 25, 25);

        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(200, 200, 200, 25);

        lblOGGrößeresWaschbecken.setText(sanitaerinstallationControl.getWuensche().get(0).getWunsch());
        txtPreisOGGrößeresWaschbecken.setText(String.valueOf(sanitaerinstallationControl.getWuensche().get(0).getPreis()));
        lblDGGrößeresWaschbecken.setText(sanitaerinstallationControl.getWuensche().get(1).getWunsch());
        txtPreisDGGrößeresWaschbecken.setText(String.valueOf(sanitaerinstallationControl.getWuensche().get(1).getPreis()));
        lblOGBodentiefeDusche.setText(sanitaerinstallationControl.getWuensche().get(2).getWunsch());
        txtPreisOGBodentiefeDusche.setText(String.valueOf(sanitaerinstallationControl.getWuensche().get(2).getPreis()));
        lblDGBodentiefeDusche.setText(sanitaerinstallationControl.getWuensche().get(3).getWunsch());
        txtPreisDGBodentiefeDusche.setText(String.valueOf(sanitaerinstallationControl.getWuensche().get(3).getPreis()));

    }

    protected void iniListener() {
        super.initListener();
        chckBxOGGrößeresWaschbecken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = sanitaerinstallationControl.getWuensche().get(0).getPreis();
                    sanitaerinstallationControl.addAusgewaehltenWuensch(sanitaerinstallationControl.getWuensche().get(0));
                }else {
                    auswahl[0] = 0;
                    sanitaerinstallationControl.removeAusgewaehltenWunsch(sanitaerinstallationControl.getWuensche().get(0).getId());
                }

            }
        });
        chckBxDGGrößeresWaschbecken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = sanitaerinstallationControl.getWuensche().get(1).getPreis();
                    sanitaerinstallationControl.addAusgewaehltenWuensch(sanitaerinstallationControl.getWuensche().get(1));
                }else {
                    auswahl[1] = 0;
                    sanitaerinstallationControl.removeAusgewaehltenWunsch(sanitaerinstallationControl.getWuensche().get(1).getId());
                }

            }
        });
        chckBxOGBodentiefeDusche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = auswahl[1] = sanitaerinstallationControl.getWuensche().get(2).getPreis();
                    sanitaerinstallationControl.addAusgewaehltenWuensch(sanitaerinstallationControl.getWuensche().get(2));
                }else {
                    auswahl[2] = 0;
                    sanitaerinstallationControl.removeAusgewaehltenWunsch(sanitaerinstallationControl.getWuensche().get(2).getId());
                }

            }
        });
        chckBxDGBodentiefeDusche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = auswahl[2] = auswahl[1] = sanitaerinstallationControl.getWuensche().get(3).getPreis();
                    sanitaerinstallationControl.addAusgewaehltenWuensch(sanitaerinstallationControl.getWuensche().get(3));
                }else {
                    auswahl[3] = 0;
                    sanitaerinstallationControl.removeAusgewaehltenWunsch(sanitaerinstallationControl.getWuensche().get(3).getId());
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
                chckBxOGGrößeresWaschbecken.setSelected(false);
                chckBxDGGrößeresWaschbecken.setSelected(false);
                chckBxOGBodentiefeDusche.setSelected(false);
                chckBxDGBodentiefeDusche.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });

        };

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheSanitaerinstallation> kundenWuensche = kunde.getKunde().getSonderwuenscheSanitaerinstallation();
        sanitaerinstallationControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheSanitaerinstallation wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxOGGrößeresWaschbecken.setSelected(true);
                    break;
                case 2:
                    chckBxDGGrößeresWaschbecken.setSelected(true);
                    break;
                case 3:
                    chckBxOGBodentiefeDusche.setSelected(true);
                    break;
                case 4:
                    chckBxDGBodentiefeDusche.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

    }


    private void leseSanitaerinstallationSonderwuensche(){this.sanitaerinstallationControl.leseSanitaerinstallationSonderwuensche();}

    /* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
    protected  void berechneUndZeigePreisSonderwuensche(){

        if(sanitaerinstallationControl.pruefeKonstellationSonderwuensche(auswahl)) {
            sanitaerinstallationControl.zeigePreisSonderwuensche(auswahl);

        }else {
            sanitaerinstallationControl.zeigeFehlerSonderwunsch();
        }
    }

    /* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
    protected void speichereSonderwuensche(){
        // Es wird erst die Methode pruefeKonstellationSonderwuensche(int[] auswahl)
        // aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
        kunde.getKunde().setSonderwuenscheSanitaerinstallation(sanitaerinstallationControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde(), kunde.getKunde().getHausnummer().getId());
    }
    protected JLabel getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }
}
