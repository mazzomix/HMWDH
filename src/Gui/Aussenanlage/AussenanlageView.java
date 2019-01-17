package Gui.Aussenanlage;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheAussenanlagen;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

public class AussenanlageView extends  BasisView {
    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[7];
    private AussenanlageControl aussenanlageControl;

    private List<SonderwuenscheAussenanlagen> sonderwuenscheAussenanlagen = db.holeSonderwuenscheAussenanlagen();


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
        this.inisListener();
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

         super.getPnlSonderwunsch().add(lblDGElektrischeMarkise);
        lblDGElektrischeMarkise.setBounds(10, 150, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisDGElektrischeMarkise);
        txtPreisDGElektrischeMarkise.setBounds(350, 150, 80, 25);
        txtPreisDGElektrischeMarkise.setEditable(false);
        super.getPnlSonderwunsch().add(lblDGElektrischeMarkiseEuro);
        lblDGElektrischeMarkiseEuro.setBounds(440, 150, 50, 25);
        super.getPnlSonderwunsch().add(chckBxDGElektrischeMarkise);
        chckBxDGElektrischeMarkise.setBounds(470, 150, 25, 25);

        super.getPnlSonderwunsch().add(lblSektionaltor);
        lblSektionaltor.setBounds(10, 175, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisSektionaltor);
        txtPreisSektionaltor.setBounds(350, 175, 80, 25);
        txtPreisSektionaltor.setEditable(false);
        super.getPnlSonderwunsch().add(lblSektionaltorEuro);
        lblSektionaltorEuro.setBounds(440, 175, 50, 25);
        super.getPnlSonderwunsch().add(chckBxSektionaltor);
        chckBxSektionaltor.setBounds(470, 175, 25, 25);

        super.getPnlSonderwunsch().add(lblEleAntriebGaragentor);
        lblEleAntriebGaragentor.setBounds(10, 200, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisEleAntriebGaragentor);
        txtPreisEleAntriebGaragentor.setBounds(350, 200, 80, 25);
        txtPreisEleAntriebGaragentor.setEditable(false);
        super.getPnlSonderwunsch().add(lblEleAntriebGaragentorEuro);
        lblEleAntriebGaragentorEuro.setBounds(440, 200, 50, 25);
        super.getPnlSonderwunsch().add(chckBxEleAntriebGaragentor);
        chckBxEleAntriebGaragentor.setBounds(470, 200, 25, 25);

        super.getPnlSonderwunsch().add(lblGesamtpreis);
    	lblGesamtpreis.setBounds(10, 250, 350, 25);
    	super.getPnlSonderwunsch().add(txtGesamtpreis);
    	txtGesamtpreis.setBounds(350, 250, 150, 25);
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

  
    protected void inisListener() {
        super.initListener();

        chckBxEGAbstellraumTerrasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(0));
                    auswahl[0] = sonderwuenscheAussenanlagen.get(0).getPreis();


                }else {
                    auswahl[0] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(0).getId());
                }

            }
        });
        chckBxVorbereitungEleAntriebe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(1));
                    auswahl[1] = sonderwuenscheAussenanlagen.get(1).getPreis();

                }else {
                    auswahl[1] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(1).getId());
                }

            }
        });
        chckBxDGVorbereitungEleAntriebe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(2));
                    auswahl[2] = sonderwuenscheAussenanlagen.get(2).getPreis();

                }else {
                    auswahl[2] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(2).getId());
                }

            }
        });
        chckBxEGElektrischeMarkise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(3));
                    auswahl[3] = sonderwuenscheAussenanlagen.get(3).getPreis();

                }else {
                    auswahl[3] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(3).getId());
                }

            }
        });
        chckBxDGElektrischeMarkise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(4));
                    auswahl[4] = sonderwuenscheAussenanlagen.get(4).getPreis();

                }else {
                    auswahl[4] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(4).getId());
                }

            }
        });
        chckBxEleAntriebGaragentor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(5));
                    auswahl[5] = sonderwuenscheAussenanlagen.get(5).getPreis();

                }else {
                    auswahl[5] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(5).getId());
                }

            }
        });
        chckBxSektionaltor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton)actionEvent.getSource();
                if(abBttn.getModel().isSelected()) {
                    aussenanlageControl.addAusgewaehltenWuensch(sonderwuenscheAussenanlagen.get(6));
                    auswahl[6] = sonderwuenscheAussenanlagen.get(6).getPreis();

                }else {
                    auswahl[6] = 0;
                    aussenanlageControl.removeAusgewaehltenWunsch(aussenanlageControl.getWuensche().get(6).getId());
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
        if(aussenanlageControl.pruefeKonstellationSonderwuensche(auswahl)) {
            aussenanlageControl.zeigePreisSonderwuensche(auswahl);

        }else {
            aussenanlageControl.zeigeFehlerSonderwunsch();
        }



        //double preis = aussenanlageControl.berechnePreis();
        //txtGesamtpreis.setText("" + Double.toString(preis) + " €");
    }

    protected  void speichereSonderwuensche(){
        kunde.getKunde().setSonderwuenscheAussenanlagen(aussenanlageControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde());
    }

    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;

    }
}
