package Gui.Sanitaerinstallation;

import Gui.Basis.BasisView;

import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SanitaerinstallationView extends  BasisView {
    public static final long serialVersionUID = 1L;
    private int[] auswahl = new int[6];
    private SanitaerinstallationControl sanitaerinstallationControl;

    private JLabel lblOGGrößeresWaschbecken = new JLabel("Größeres Waschbecken im OG");
    private JTextField txtPreisOGGrößeresWaschbecken = new JTextField("160");
    private JLabel lblOGGrößeresWaschbeckenEuro = new JLabel("Euro");
    public JCheckBox chckBxOGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblDGGrößeresWaschbecken = new JLabel("Größeres Waschbecken im DG");
    private JTextField txtPreisDGGrößeresWaschbecken = new JTextField("160");
    private JLabel lblDGGrößeresWaschbeckenEuro = new JLabel("Euro");
    public JCheckBox chckBxDGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblOGBodentiefeDusche = new JLabel("Bodentiefe Dusche im OG");
    private JTextField txtPreisOGBodentiefeDusche = new JTextField("560");
    private JLabel lblOGBodentiefeDuscheEuro = new JLabel("Euro");
    public JCheckBox chckBxOGBodentiefeDusche = new JCheckBox();

    private JLabel lblDGBodentiefeDusche = new JLabel("Bodentiefe Dusche im DG");
    private JTextField txtPreisDGBodentiefeDusche = new JTextField("560");
    private JLabel lblDGBodentiefeDuscheEuro = new JLabel("Euro");
    public JCheckBox chckBxDGBodentiefeDusche = new JCheckBox();

    private JLabel txtGesamtpreis = new JLabel("Gesamtpreis");





    public SanitaerinstallationView(SanitaerinstallationControl sanitaerinstallationControl){
        this.sanitaerinstallationControl = sanitaerinstallationControl;
        this.setTitle("Sonderwünsche zu Sanitaerinstallation-Varianten");
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


    }

    protected void iniListener() {
        super.initListener();
        chckBxOGGrößeresWaschbecken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[0] = Integer.parseInt(txtPreisOGGrößeresWaschbecken.getText());
                }else {
                    auswahl[0] = 0;
                }

            }
        });
        chckBxDGGrößeresWaschbecken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[1] = Integer.parseInt(txtPreisDGGrößeresWaschbecken.getText());
                }else {
                    auswahl[1] = 0;
                }

            }
        });
        chckBxOGBodentiefeDusche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[2] = Integer.parseInt(txtPreisOGBodentiefeDusche.getText());
                }else {
                    auswahl[2] = 0;
                }

            }
        });
        chckBxDGBodentiefeDusche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    auswahl[3] = Integer.parseInt(txtPreisDGBodentiefeDusche.getText());
                }else {
                    auswahl[3] = 0;
                }

            }
        });

        };





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
    }
    protected JLabel getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }
}
