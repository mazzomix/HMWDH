package Gui.Innentueren;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Gui.Basis.BasisView;

/**
 * Klasse, welche das Fenster fuer die Sonderwuensche zu den Innentueren
 * bereitstellt. 29.11 : V1 noch keine beruecksichtigung von Menge der Tueren
 * pro Geschoss . Notwendig?!
 *
 **/
public class InnentuerenView extends BasisView {

    public static final long serialVersionUID = 1L;
    private int[] auswahl = new int[3];
    private int[] anzahl = new int[3];

    private InnentuerenControl innentuerenControl;
    // Definition der grafischen Oberflaeche

    private JLabel lblKlarGlasInnentuer = new JLabel("Glasausschnitt (Klarglas) in einer Innentuer");
    private JTextField txtPreisKlarGlasInnentuer = new JTextField("460");
    private JLabel lblKlarGlasInnentuerPreis = new JLabel("Euro");
    private JCheckBox chckBxKlarGlasInnentuer = new JCheckBox();
    private JLabel lblKlarGlasInnentuerMaenge = new JLabel("Stk: ");
    private JTextField txtMaengeKlarGlasInnentuer = new JTextField("");

    private JLabel lblMilchglasInnentuer = new JLabel("Glasausschnitt (Milchglas) in einer Innentuer");
    private JTextField txtPreisMilchglasInnentuer = new JTextField("560");
    private JLabel lblMilchglasInnentuerPreis = new JLabel("Euro");
    private JCheckBox chckBxMilchglasInnentuer = new JCheckBox();
    private JLabel lblMilchglasInnentuerMaenge = new JLabel("Stk: ");
    private JTextField txtMaengeMilchglasInnentuer = new JTextField("");

    private JLabel lblGaragentuerHolz = new JLabel("Innentuer zur Garage als Holztuer");
    private JTextField txtPreisGaragentuerHolz = new JTextField("660");
    private JLabel lblGaragentuerHolzPreis = new JLabel("Euro");
    private JCheckBox chckBxGaragentuerHolz = new JCheckBox();
    private JLabel lblGaragentuerHolzMaenge = new JLabel("Stk: ");
    private JTextField txtMaengeGaragentuerHolz = new JTextField("1");

    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();

    public InnentuerenView(InnentuerenControl innentuerenControl) {
        this.innentuerenControl = innentuerenControl;
        this.setTitle("Sonderwuensche zu den Innentueren");
        this.initKomponenten();
        this.iniListener();
        this.leseInnentuerenSonderwuensche();
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();
        super.getLblSonderwunsch().setText("Innentueren-Varianten");
        super.getPnlSonderwunsch().setBackground(new Color(255, 255, 255));

        super.getPnlSonderwunsch().add(lblKlarGlasInnentuer);
        lblKlarGlasInnentuer.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisKlarGlasInnentuer);
        txtPreisKlarGlasInnentuer.setBounds(280, 50, 40, 25);
        txtPreisKlarGlasInnentuer.setEditable(false);
        super.getPnlSonderwunsch().add(lblKlarGlasInnentuerPreis);
        lblKlarGlasInnentuerPreis.setBounds(330, 50, 30, 25);
        super.getPnlSonderwunsch().add(lblKlarGlasInnentuerMaenge);
        lblKlarGlasInnentuerMaenge.setBounds(370, 50, 30, 25);
        super.getPnlSonderwunsch().add(txtMaengeKlarGlasInnentuer);
        txtMaengeKlarGlasInnentuer.setBounds(405, 50, 50, 25);
        txtMaengeKlarGlasInnentuer.setEditable(true);
        super.getPnlSonderwunsch().add(chckBxKlarGlasInnentuer);
        chckBxKlarGlasInnentuer.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblMilchglasInnentuer);
        lblMilchglasInnentuer.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisMilchglasInnentuer);
        txtPreisMilchglasInnentuer.setBounds(280, 75, 40, 25);
        txtPreisMilchglasInnentuer.setEditable(false);
        super.getPnlSonderwunsch().add(lblMilchglasInnentuerPreis);
        lblMilchglasInnentuerPreis.setBounds(330, 75, 30, 25);
        super.getPnlSonderwunsch().add(lblMilchglasInnentuerMaenge);
        lblMilchglasInnentuerMaenge.setBounds(370, 75, 30, 25);
        super.getPnlSonderwunsch().add(txtMaengeMilchglasInnentuer);
        txtMaengeMilchglasInnentuer.setBounds(405, 75, 50, 25);
        txtMaengeMilchglasInnentuer.setEditable(true);
        super.getPnlSonderwunsch().add(chckBxMilchglasInnentuer);
        chckBxMilchglasInnentuer.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblGaragentuerHolz);
        lblGaragentuerHolz.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGaragentuerHolz);
        txtPreisGaragentuerHolz.setBounds(280, 100, 40, 25);
        txtPreisGaragentuerHolz.setEditable(false);
        super.getPnlSonderwunsch().add(lblGaragentuerHolzPreis);
        lblGaragentuerHolzPreis.setBounds(330, 100, 30, 25);
        super.getPnlSonderwunsch().add(lblGaragentuerHolzMaenge);
        lblGaragentuerHolzMaenge.setBounds(370, 100, 30, 25);
        super.getPnlSonderwunsch().add(txtMaengeGaragentuerHolz);
        txtMaengeGaragentuerHolz.setBounds(405, 100, 50, 25);
        txtMaengeGaragentuerHolz.setEditable(false);
        super.getPnlSonderwunsch().add(chckBxGaragentuerHolz);
        chckBxGaragentuerHolz.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(10, 225, 350, 25);
        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(350, 225, 150, 25);
        txtGesamtpreis.setEditable(false);
    }

    protected void iniListener() {
        super.initListener();
        chckBxKlarGlasInnentuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
                    auswahl[0] = Integer.parseInt(txtPreisKlarGlasInnentuer.getText());
                    anzahl[0] = Integer.parseInt(txtMaengeKlarGlasInnentuer.getText());
                } else {
                    auswahl[0] = 0;
                    anzahl[0] = 0;
                }

            }
        });
        chckBxMilchglasInnentuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
                    auswahl[1] = Integer.parseInt(txtPreisMilchglasInnentuer.getText());
                    anzahl[1] = Integer.parseInt(txtMaengeMilchglasInnentuer.getText());
                } else {
                    auswahl[1] = 0;
                    anzahl[1] = 0;
                }

            }
        });
        chckBxGaragentuerHolz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
                    auswahl[2] = Integer.parseInt(txtPreisGaragentuerHolz.getText());
                } else {
                    auswahl[2] = 0;
                }

            }
        });

    }

    private void leseInnentuerenSonderwuensche() {
        this.innentuerenControl.leseInnentuerenSonderwuensche();
    }

    @Override
    protected void berechneUndZeigePreisSonderwuensche() {
        if (innentuerenControl.pruefeKonstellationSonderwuensche(auswahl)) {
            innentuerenControl.zeigePreisSonderwuensche(auswahl, anzahl);

        } else {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
    }

    @Override
    protected void speichereSonderwuensche() {
        // to be done
    }

    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;
    }
}
