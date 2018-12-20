package Gui.Aussenanlage;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheAussenanlagen;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

public class AussenanlageView extends  BasisView {
    public static final long serialVersionUID = 1L;

    private AussenanlageControl aussenanlageControl;

    private JLabel lblEGAbstellraumTerrasse = new JLabel("Abstellraum auf der Terrasse des EG");
    private JTextField txtPreisEGAbstellraumTerrasse = new JTextField("3590");
    private JLabel lblEGAbstellraumTerrasseEuro = new JLabel("Euro");
    public JCheckBox chckBxEGAbstellraumTerrasse = new JCheckBox();

    private JLabel lblEGVorbereitungEleAntriebe = new JLabel("Vorbereitung für die elektrische Antriebe Markise EG");
    private JTextField txtPreisEGVorbereitungEleAntriebe = new JTextField("170");
    private JLabel lblEGVorbereitungEleAntriebeEuro = new JLabel("Euro");
    public JCheckBox chckBxVorbereitungEleAntriebe = new JCheckBox();

    private JLabel lblDGVorbereitungEleAntriebe = new JLabel("Vorbereitung für elektrische Antriebe Markise DG");
    private JTextField txtPreisDGVorbereitungEleAntriebe = new JTextField("170");
    private JLabel lblDGVorbereitungEleAntriebeEuro = new JLabel("Euro");
    public JCheckBox chckBxDGVorbereitungEleAntriebe = new JCheckBox();

    private JLabel lblEGElektrischeMarkise = new JLabel("Elektrische Markise EG");
    private JTextField txtPreisEGElektrischeMarkise = new JTextField("890");
    private JLabel lblEGElektrischeMarkiseEuro = new JLabel("Euro");
    public JCheckBox chckBxEGElektrischeMarkise = new JCheckBox();

    private JLabel lblDGElektrischeMarkise = new JLabel("Elektrische Markise DG");
    private JTextField txtPreisDGElektrischeMarkise = new JTextField("890");
    private JLabel lblDGElektrischeMarkiseEuro = new JLabel("Euro");
    public JCheckBox chckBxDGElektrischeMarkise = new JCheckBox();

    private JLabel lblEleAntriebGaragentor = new JLabel("Elektrischen Antrieb für das Garagentor");
    private JTextField txtPreisEleAntriebGaragentor = new JTextField("990");
    private JLabel lblEleAntriebGaragentorEuro = new JLabel("Euro");
    public JCheckBox chckBxEleAntriebGaragentor = new JCheckBox();

    private JLabel lblSektionaltor = new JLabel("Sektionaltor anstatt Schwingtor für die Garage");
    private JTextField txtPreisSektionaltor = new JTextField("790");
    private JLabel lblSektionaltorEuro = new JLabel("Euro");
    public JCheckBox chckBxSektionaltor = new JCheckBox();

    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();


    public AussenanlageView(AussenanlageControl aussenanlageControl){
        this.aussenanlageControl = aussenanlageControl;
        this.setTitle("Sonderwünsche zu Aussenanlage-Varianten");
        this.aussenanlageControl.setWuensche(db.holeSonderwuenscheAussenanlagen());
        this.initKomponenten();
        this.initListener();
        this.leseAussenanlageSonderwuensche();
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();

        super.getLblSonderwunsch().setText("Aussenanlage-Varianten");
        super.getPnlSonderwunsch().add(lblEGAbstellraumTerrasse);
        lblEGAbstellraumTerrasse.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEGAbstellraumTerrasse);
        txtPreisEGAbstellraumTerrasse.setBounds(350, 50, 80, 25);
        txtPreisEGAbstellraumTerrasse.setEditable(false);
        super.getPnlSonderwunsch().add(lblEGAbstellraumTerrasseEuro);
        lblEGAbstellraumTerrasseEuro.setBounds(440, 50, 50, 25);
        super.getPnlSonderwunsch().add(chckBxEGAbstellraumTerrasse);
        chckBxEGAbstellraumTerrasse.setBounds(470, 50, 25, 25);

        super.getPnlSonderwunsch().add(lblEGVorbereitungEleAntriebe);
        lblEGVorbereitungEleAntriebe.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEGVorbereitungEleAntriebe);
        txtPreisEGVorbereitungEleAntriebe.setBounds(350, 75, 80, 25);
        txtPreisEGVorbereitungEleAntriebe.setEditable(false);
        super.getPnlSonderwunsch().add(lblEGVorbereitungEleAntriebeEuro);
        lblEGVorbereitungEleAntriebeEuro.setBounds(440, 75, 50, 25);
        super.getPnlSonderwunsch().add(chckBxVorbereitungEleAntriebe);
        chckBxVorbereitungEleAntriebe.setBounds(470, 75, 25, 25);

        super.getPnlSonderwunsch().add(lblDGVorbereitungEleAntriebe);
        lblDGVorbereitungEleAntriebe.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisDGVorbereitungEleAntriebe);
        txtPreisDGVorbereitungEleAntriebe.setBounds(350, 100, 80, 25);
        txtPreisDGVorbereitungEleAntriebe.setEditable(false);
        super.getPnlSonderwunsch().add(lblDGVorbereitungEleAntriebeEuro);
        lblDGVorbereitungEleAntriebeEuro.setBounds(440, 100, 50, 25);
        super.getPnlSonderwunsch().add(chckBxDGVorbereitungEleAntriebe);
        chckBxDGVorbereitungEleAntriebe.setBounds(470, 100, 25, 25);

        super.getPnlSonderwunsch().add(lblEGElektrischeMarkise);
        lblEGElektrischeMarkise.setBounds(10, 125, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEGElektrischeMarkise);
        txtPreisEGElektrischeMarkise.setBounds(350, 125, 80, 25);
        txtPreisEGElektrischeMarkise.setEditable(false);
        super.getPnlSonderwunsch().add(lblEGElektrischeMarkiseEuro);
        lblEGElektrischeMarkiseEuro.setBounds(440, 125, 50, 25);
        super.getPnlSonderwunsch().add(chckBxEGElektrischeMarkise);
        chckBxEGElektrischeMarkise.setBounds(470, 125, 25, 25);

        super.getPnlSonderwunsch().add(lblSektionaltor);
        lblSektionaltor.setBounds(10, 150, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisSektionaltor);
        txtPreisSektionaltor.setBounds(350, 150, 80, 25);
        txtPreisSektionaltor.setEditable(false);
        super.getPnlSonderwunsch().add(lblSektionaltorEuro);
        lblSektionaltorEuro.setBounds(440, 150, 50, 25);
        super.getPnlSonderwunsch().add(chckBxSektionaltor);
        chckBxSektionaltor.setBounds(470, 150, 25, 25);

        super.getPnlSonderwunsch().add(lblEleAntriebGaragentor);
        lblEleAntriebGaragentor.setBounds(10, 175, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEleAntriebGaragentor);
        txtPreisEleAntriebGaragentor.setBounds(350, 175, 80, 25);
        txtPreisEleAntriebGaragentor.setEditable(false);
        super.getPnlSonderwunsch().add(lblEleAntriebGaragentorEuro);
        lblEleAntriebGaragentorEuro.setBounds(440, 175, 50, 25);
        super.getPnlSonderwunsch().add(chckBxEleAntriebGaragentor);
        chckBxEleAntriebGaragentor.setBounds(470, 175, 25, 25);

         super.getPnlSonderwunsch().add(lblGesamtpreis);
    	lblGesamtpreis.setBounds(10, 225, 350, 25);
    	super.getPnlSonderwunsch().add(txtGesamtpreis);
    	txtGesamtpreis.setBounds(350, 225, 150, 25);
    	txtGesamtpreis.setEditable(false);

        lblEGAbstellraumTerrasse.setText(aussenanlageControl.getWuensche().get(0).getWunsch());
        txtPreisEGAbstellraumTerrasse.setText(String.valueOf(aussenanlageControl.getWuensche().get(0).getPreis()));
        lblEGVorbereitungEleAntriebe.setText(aussenanlageControl.getWuensche().get(1).getWunsch());
        txtPreisEGVorbereitungEleAntriebe.setText(String.valueOf(aussenanlageControl.getWuensche().get(1).getPreis()));
        lblDGVorbereitungEleAntriebe.setText(aussenanlageControl.getWuensche().get(2).getWunsch());
        txtPreisDGVorbereitungEleAntriebe.setText(String.valueOf(aussenanlageControl.getWuensche().get(2).getPreis()));
        lblEGElektrischeMarkise.setText(aussenanlageControl.getWuensche().get(3).getWunsch());
        txtPreisEGElektrischeMarkise.setText(String.valueOf(aussenanlageControl.getWuensche().get(3).getPreis()));
        lblDGElektrischeMarkise.setText(aussenanlageControl.getWuensche().get(4).getWunsch());
        txtPreisDGElektrischeMarkise.setText(String.valueOf(aussenanlageControl.getWuensche().get(4).getPreis()));
        lblEleAntriebGaragentor.setText(aussenanlageControl.getWuensche().get(5).getWunsch());
        txtPreisEleAntriebGaragentor.setText(String.valueOf(aussenanlageControl.getWuensche().get(5).getPreis()));
        lblSektionaltor.setText(aussenanlageControl.getWuensche().get(6).getWunsch());
        txtPreisSektionaltor.setText(String.valueOf(aussenanlageControl.getWuensche().get(6).getPreis()));


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
                chckBxEGAbstellraumTerrasse.setSelected(false);
                chckBxVorbereitungEleAntriebe.setSelected(false);
                chckBxDGVorbereitungEleAntriebe.setSelected(false);
                chckBxEGElektrischeMarkise.setSelected(false);
                chckBxDGElektrischeMarkise.setSelected(false);
                chckBxEleAntriebGaragentor.setSelected(false);
                chckBxSektionaltor.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });
    }

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheAussenanlagen> kundenWuensche = kunde.getKunde().getSonderwuenscheAussenanlagen();
        aussenanlageControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheAussenanlagen wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxEGAbstellraumTerrasse.setSelected(true);
                    break;
                case 2:
                    chckBxVorbereitungEleAntriebe.setSelected(true);
                    break;
                case 3:
                    chckBxDGVorbereitungEleAntriebe.setSelected(true);
                    break;
                case 4:
                    chckBxEGElektrischeMarkise.setSelected(true);
                    break;
                case 5:
                    chckBxDGElektrischeMarkise.setSelected(true);
                    break;
                case 6:
                    chckBxEleAntriebGaragentor.setSelected(true);
                    break;
                case 7:
                    chckBxSektionaltor.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

    }


    private void leseAussenanlageSonderwuensche(){this.aussenanlageControl.leseAussenanlageSonderwuensche();}

    protected  void berechneUndZeigePreisSonderwuensche(){
        double preis = aussenanlageControl.berechnePreis();
        txtGesamtpreis.setText("Gesamtpreis: " + Double.toString(preis) + " €");
    }

    protected  void speichereSonderwuensche(){
        kunde.getKunde().setSonderwuenscheAussenanlagen(aussenanlageControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde(), kunde.getKunde().getHausnummer().getId());
    }
}
