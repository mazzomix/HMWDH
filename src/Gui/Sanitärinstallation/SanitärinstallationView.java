package Gui.Sanitärinstallation;

import Gui.Basis.BasisView;
import javax.swing.*;

public class SanitärinstallationView extends  BasisView {
    public static final long serialVersionUID = 1L;

    private SanitärinstallationControl sanitärinstallationControl;

    private JLabel lblOGGrößeresWaschbecken = new JLabel("Größeres Waschbecken im OG");
    private JTextField txtPreisOGGrößeresWaschbecken = new JTextField("160");
    private JLabel lblOGGrößeresWaschbeckenEuro = new JLabel("Euro");
    private JCheckBox chckBxOGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblDGGrößeresWaschbecken = new JLabel("Größeres Waschbecken im DG");
    private JTextField txtPreisDGGrößeresWaschbecken = new JTextField("160");
    private JLabel lblDGGrößeresWaschbeckenEuro = new JLabel("Euro");
    private JCheckBox chckBxDGGrößeresWaschbecken = new JCheckBox();

    private JLabel lblOGBodentiefeDusche = new JLabel("Bodentiefe Dusche im OG");
    private JTextField txtPreisOGBodentiefeDusche = new JTextField("560");
    private JLabel lblOGBodentiefeDuscheEuro = new JLabel("Euro");
    private JCheckBox chckBxOGBodentiefeDusche = new JCheckBox();

    private JLabel lblDGBodentiefeDusche = new JLabel("Bodentiefe Dusche im DG");
    private JTextField txtPreisDGBodentiefeDusche = new JTextField("560");
    private JLabel lblDGBodentiefeDuscheEuro = new JLabel("Euro");
    private JCheckBox chckBxDGBodentiefeDusche = new JCheckBox();



    public SanitärinstallationView(SanitärinstallationControl sanitärinstallationControl){
        this.sanitärinstallationControl = sanitärinstallationControl;
        this.setTitle("Sonderwünsche zu Sanitärinstallation-Varianten");
        this.initKomponenten();
        this.leseSanitärinstallationSonderwuensche();
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();

        super.getLblSonderwunsch().setText("Sanitärinstallation-Varianten");
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
    }

    private void leseSanitärinstallationSonderwuensche(){this.sanitärinstallationControl.leseSanitärinstallationSonderwuensche();}

    protected  void berechneUndZeigePreisSonderwuensche(){}

    protected  void speichereSonderwuensche(){}
}
