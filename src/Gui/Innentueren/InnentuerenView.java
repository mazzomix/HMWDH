package Gui.Innentueren;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Gui.Basis.BasisView;
import HibernateCont.SonderwuenscheInnentueren;

/**
 * Klasse, welche das Fenster fuer die Sonderwuensche zu den Innentueren
 * bereitstellt. 
 * 29.11 : V1 noch keine beruecksichtigung von Menge der Tueren
 * pro Geschoss . Notwendig?! JA
 *
 * 16.12 : V2 label hinzugef�gt, Maske angepasst um Tueren pro geschoss zu ber�cksichtigen
 **/
public class InnentuerenView extends BasisView {

    public static final long serialVersionUID = 1L;
    private double[] auswahl = new double[10];
    private int[] anzahl = new int[9];
    private int[] anzahl1 = new int[4];

    private InnentuerenControl innentuerenControl;
    // Definition der grafischen Oberflaeche

    private JLabel lblKlarGlasInnentuer = new JLabel("");
    private JTextField txtPreisKlarGlasInnentuer = new JTextField("");
    private JLabel lblKlarGlasInnentuerPreis = new JLabel(BasisView.currency);
    private JCheckBox chckBxKlarGlasInnentuer = new JCheckBox();

    private JLabel lblMilchglasInnentuer = new JLabel("");
    private JTextField txtPreisMilchglasInnentuer = new JTextField("");
    private JLabel lblMilchglasInnentuerPreis = new JLabel(BasisView.currency);
    private JCheckBox chckBxMilchglasInnentuer = new JCheckBox();

    private JLabel lblGaragentuerHolz = new JLabel("");
    private JTextField txtPreisGaragentuerHolz = new JTextField("");
    private JLabel lblGaragentuerHolzPreis = new JLabel(BasisView.currency);
    private JCheckBox chckBxGaragentuerHolz = new JCheckBox();    
    
    // NEU
    private JLabel lblMaenge = new JLabel("Max");
    private JLabel lblKlar = new JLabel("Klar");
    private JLabel lblMilch = new JLabel("Milch");

    private JLabel lblKG = new JLabel("KG: ");
    private JLabel lblEG = new JLabel("EG: ");
    private JLabel lblOG = new JLabel("OG: ");
    private JLabel lblDG = new JLabel("DG: ");
    private JLabel lblGG = new JLabel("Garage");
    
    private JTextField txtMaengeKGKlar = new JTextField("0");
    private JTextField txtMaengeKGMilch = new JTextField("0");
    private JTextField txtKGMax = new JTextField("0");   
    private JTextField txtMaengeEGKlar = new JTextField("0");
    private JTextField txtMaengeEGMilch = new JTextField("0");
    private JTextField txtEGMax = new JTextField("0");
    private JTextField txtMaengeOGKlar = new JTextField("0");
    private JTextField txtMaengeOGMilch = new JTextField("0");
    private JTextField txtOGMax = new JTextField("0");
    private JTextField txtMaengeDGKlar = new JTextField("0");
    private JTextField txtMaengeDGMilch = new JTextField("0");
    private JTextField txtDGMax = new JTextField("0");
    private JTextField txtGGMax = new JTextField("1");
    private JLabel lblGesamtpreis = new JLabel("Gesamtpreis: ");
    private JTextField txtGesamtpreis = new JTextField();

    public InnentuerenView(InnentuerenControl innentuerenControl) {
        this.innentuerenControl = innentuerenControl;
        this.setTitle("Sonderwuensche zu den Innentueren");
        this.innentuerenControl.setWuensche(db.holeSonderwuenscheInnentueren());
        this.initKomponenten();
        this.iniListener();
        this.leseInnentuerenSonderwuensche();
        
        // NEU
    }

    @Override
    protected void initKomponenten() {
        super.initKomponenten();
        super.getLblSonderwunsch().setText("Innentueren-Varianten");
        super.getPnlSonderwunsch().setBackground(new Color(255, 255, 255));

        auswahl[0] = 0;
        anzahl[0] = 0;
        auswahl[1] = 0;
        anzahl[1] = 0;
        auswahl[2] = 0;
        anzahl[2] = 0;
        auswahl[3] = 0;
        anzahl[3] = 0;
        auswahl[4] = 0;
        anzahl[4] = 0;
        auswahl[5] = 0;
        anzahl[5] = 0;
        auswahl[6] = 0;
        anzahl[6] = 0;
        auswahl[7] = 0;
        anzahl[7] = 0;
        auswahl[8] = 0;
        anzahl[8] = 0;

        anzahl1[0] = 0;
        anzahl1[1] = 0;
        anzahl1[2] = 0;
        anzahl1[3] = 0;
        
        //ALT
        super.getPnlSonderwunsch().add(lblKlarGlasInnentuer);
        lblKlarGlasInnentuer.setBounds(10, 50, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisKlarGlasInnentuer);
        txtPreisKlarGlasInnentuer.setBounds(280, 50, 40, 25);
        txtPreisKlarGlasInnentuer.setEditable(false);
        super.getPnlSonderwunsch().add(lblKlarGlasInnentuerPreis);
        lblKlarGlasInnentuerPreis.setBounds(330, 50, 30, 25);
        super.getPnlSonderwunsch().add(chckBxKlarGlasInnentuer);
        chckBxKlarGlasInnentuer.setBounds(470, 50, 25, 25);
        super.getPnlSonderwunsch().add(lblMilchglasInnentuer);
        lblMilchglasInnentuer.setBounds(10, 75, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisMilchglasInnentuer);
        txtPreisMilchglasInnentuer.setBounds(280, 75, 40, 25);
        txtPreisMilchglasInnentuer.setEditable(false);
        super.getPnlSonderwunsch().add(lblMilchglasInnentuerPreis);
        lblMilchglasInnentuerPreis.setBounds(330, 75, 30, 25);
        super.getPnlSonderwunsch().add(chckBxMilchglasInnentuer);
        chckBxMilchglasInnentuer.setBounds(470, 75, 25, 25);
        super.getPnlSonderwunsch().add(lblGaragentuerHolz);
        lblGaragentuerHolz.setBounds(10, 100, 350, 25);
        super.getPnlSonderwunsch().add(txtPreisGaragentuerHolz);
        txtPreisGaragentuerHolz.setBounds(280, 100, 40, 25);
        txtPreisGaragentuerHolz.setEditable(false);
        super.getPnlSonderwunsch().add(lblGaragentuerHolzPreis);
        lblGaragentuerHolzPreis.setBounds(330, 100, 30, 25);
        super.getPnlSonderwunsch().add(chckBxGaragentuerHolz);
        chckBxGaragentuerHolz.setBounds(470, 100, 25, 25);
        
        //NEU
        	
        super.getPnlSonderwunsch().add(lblMaenge);
        lblMaenge.setBounds(100, 150, 150, 25);
        super.getPnlSonderwunsch().add(lblKG);
        lblKG.setBounds(10, 175, 50, 25);
        super.getPnlSonderwunsch().add(lblEG);
        lblEG.setBounds(10, 200, 50, 25);
        super.getPnlSonderwunsch().add(lblOG);
        lblDG.setBounds(10, 225, 50, 25);
        super.getPnlSonderwunsch().add(lblDG);
        lblDG.setBounds(10, 250, 50, 25);
        super.getPnlSonderwunsch().add(lblGG);
        lblGG.setBounds(10, 275, 50, 25);
                 
        super.getPnlSonderwunsch().add(lblKlar);
        lblKlar.setBounds(185, 150, 150, 25);
        super.getPnlSonderwunsch().add(lblMilch);
        lblMilch.setBounds(260, 150, 150, 25);
      
        super.getPnlSonderwunsch().add(txtMaengeKGKlar);
        txtMaengeKGKlar.setBounds(185, 175, 40, 25);
        super.getPnlSonderwunsch().add(txtMaengeKGMilch);
        txtMaengeKGMilch.setBounds(260, 175, 40, 25);
      
        super.getPnlSonderwunsch().add(txtKGMax);
        txtKGMax.setBounds(100, 175, 40, 25);
        txtKGMax.setText(String.valueOf(innentuerenControl.initMaengeKeller(anzahl1[0])));
        txtKGMax.setEditable(false);
     
        
        super.getPnlSonderwunsch().add(txtMaengeEGKlar);
        txtMaengeEGKlar.setBounds(185, 200, 40, 25);
     
        super.getPnlSonderwunsch().add(txtMaengeEGMilch);
        txtMaengeEGMilch.setBounds(260, 200, 40, 25);

        super.getPnlSonderwunsch().add(txtEGMax);
        txtEGMax.setBounds(100, 200, 40, 25);
        txtEGMax.setText(String.valueOf(innentuerenControl.initMaengeEG(anzahl1[1])));
        txtEGMax.setEditable(false);

        super.getPnlSonderwunsch().add(txtMaengeOGKlar);
        txtMaengeEGKlar.setBounds(185, 225, 40, 25);

        super.getPnlSonderwunsch().add(txtMaengeOGMilch);
        txtMaengeEGMilch.setBounds(260, 225, 40, 25);

        super.getPnlSonderwunsch().add(txtOGMax);
        txtOGMax.setBounds(100, 225, 40, 25);
        txtOGMax.setText(String.valueOf(innentuerenControl.initMaengeOG(anzahl1[2])));
        txtOGMax.setEditable(false);
        
        super.getPnlSonderwunsch().add(txtMaengeDGKlar);
        txtMaengeDGKlar.setBounds(185, 250, 40, 25);
       
        super.getPnlSonderwunsch().add(txtMaengeDGMilch);
        txtMaengeDGMilch.setBounds(260, 250, 40, 25);

        super.getPnlSonderwunsch().add(txtDGMax);
        txtDGMax.setBounds(100, 250, 40, 25);
        txtDGMax.setText(String.valueOf(innentuerenControl.initMaengeDG(anzahl1[3])));
        txtDGMax.setEditable(false);
        
        super.getPnlSonderwunsch().add(txtGGMax);
        txtGGMax.setBounds(100, 275, 40, 25);
        txtGGMax.setEditable(false);
      
        //ALT

        super.getPnlSonderwunsch().add(lblGesamtpreis);
        lblGesamtpreis.setBounds(160, 275, 350, 25);
        super.getPnlSonderwunsch().add(txtGesamtpreis);
        txtGesamtpreis.setBounds(400, 275, 150, 25);
        txtGesamtpreis.setEditable(false);
        
        this.lblKlarGlasInnentuer.setText(innentuerenControl.getWuensche().get(0).getWunsch());
        this.lblMilchglasInnentuer.setText(innentuerenControl.getWuensche().get(1).getWunsch());
        this.lblGaragentuerHolz.setText(innentuerenControl.getWuensche().get(2).getWunsch());
        
        this.txtPreisKlarGlasInnentuer.setText(String.valueOf(innentuerenControl.getWuensche().get(0).getPreis()));
        this.txtPreisMilchglasInnentuer.setText(String.valueOf(innentuerenControl.getWuensche().get(1).getPreis()));
        this.txtPreisGaragentuerHolz.setText(String.valueOf(innentuerenControl.getWuensche().get(2).getPreis()));


        
    }

    protected void iniListener() {
        super.initListener();
        chckBxKlarGlasInnentuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
     	
                    auswahl[0] = innentuerenControl.getWuensche().get(0).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(0));
                    anzahl[0] = Integer.parseInt(txtMaengeKGKlar.getText());
                    
                    auswahl[1] = innentuerenControl.getWuensche().get(0).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(0));
                    anzahl[1] = Integer.parseInt(txtMaengeEGKlar.getText());          
                    
                    auswahl[2] = innentuerenControl.getWuensche().get(0).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(0));
                    anzahl[2] = Integer.parseInt(txtMaengeDGKlar.getText());

                    auswahl[7] = innentuerenControl.getWuensche().get(0).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(0));
                    anzahl[7] = Integer.parseInt(txtMaengeOGKlar.getText());
                    
                } else {
                	
                    auswahl[0] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[0] = 0;
                    
                    auswahl[1] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[1] = 0;
                    
                    auswahl[2] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[2] = 0;

                    auswahl[7] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[7] = 0;
                }

            }
        });
        
        chckBxMilchglasInnentuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
                 
                    auswahl[3] = innentuerenControl.getWuensche().get(1).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(1));
                    anzahl[3] = Integer.parseInt(txtMaengeKGMilch.getText());
                    
                    auswahl[4] = innentuerenControl.getWuensche().get(1).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(1));
                    anzahl[4] = Integer.parseInt(txtMaengeEGMilch.getText());          
                    
                    auswahl[5] = innentuerenControl.getWuensche().get(1).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(1));
                    anzahl[5] = Integer.parseInt(txtMaengeDGMilch.getText());

                    auswahl[8] = innentuerenControl.getWuensche().get(1).getPreis();
                    innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(1));
                    anzahl[8] = Integer.parseInt(txtMaengeOGMilch.getText());
                    
                } else {
                	
                    auswahl[3] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[3] = 0;
                    
                    auswahl[4] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[4] = 0;
                    
                    auswahl[5] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[5] = 0;

                    auswahl[8] = 0;
                    innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    anzahl[8] = 0;
                }

            }
        });
        
        chckBxGaragentuerHolz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abBttn = (AbstractButton) actionEvent.getSource();
                if (abBttn.getModel().isSelected()) {
                	 auswahl[6] = innentuerenControl.getWuensche().get(2).getPreis();
                     innentuerenControl.addAusgewaehltenWuensch(innentuerenControl.getWuensche().get(2));
                } else {
                	innentuerenControl.removeAusgewaehltenWunsch(innentuerenControl.getWuensche().get(0).getId());
                    auswahl[6] = 0;
                    
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
                chckBxKlarGlasInnentuer.setSelected(false);
                chckBxMilchglasInnentuer.setSelected(false);
                chckBxGaragentuerHolz.setSelected(false);
                txtGesamtpreis.setText("");
            }
        });


    }

    private void initFieldsFromDatabase(){
        Set<SonderwuenscheInnentueren> kundenWuensche = kunde.getKunde().getSonderwuenscheInnentueren();
        innentuerenControl.setAusgewaehlteWuensche(kundenWuensche);
        double summePreis = 0;
        for(SonderwuenscheInnentueren wunsch: kundenWuensche){
            switch (wunsch.getId()){
                case 1:
                    chckBxKlarGlasInnentuer.setSelected(true);
                    break;
                case 2:
                    chckBxMilchglasInnentuer.setSelected(true);
                    break;
                case 3:
                    chckBxGaragentuerHolz.setSelected(true);
                    break;
            }
            summePreis += wunsch.getPreis();
        }
        txtGesamtpreis.setText(String.valueOf(summePreis));

    }
    
    private void leseInnentuerenSonderwuensche() {
        this.innentuerenControl.leseInnentuerenSonderwuensche();
        
    }

    private void checkeMaenge()
    {
        //4.1 Klarglas >1 und kleiner gesamt
        if(((anzahl[0])<1)||((anzahl[0])>anzahl1[0]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[1])<1)||((anzahl[1])>anzahl1[1]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[2])<1)||((anzahl[2])>anzahl1[2]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[7])<1)||((anzahl[7])>anzahl1[3]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        //4.2 Milchglas >1 und kleiner gesamt
        if(((anzahl[3])<1)||((anzahl[3])>anzahl1[0]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[4])<1)||((anzahl[4])>anzahl1[1]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[5])<1)||((anzahl[5])>anzahl1[2]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if(((anzahl[6])<1)||((anzahl[6])>anzahl1[3]))
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        //4.1 + 4.2 < gesamt
        if((anzahl[0]+anzahl[1])>anzahl1[0])
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if((anzahl[1]+anzahl[4])>anzahl1[1])
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if((anzahl[2]+anzahl[5])>anzahl1[2])
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        if((anzahl[7]+anzahl[8])>anzahl1[3])
        {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
    }

    @Override
    protected void berechneUndZeigePreisSonderwuensche() {
    	
        if (innentuerenControl.pruefeKonstellationSonderwuensche(auswahl)) {
            innentuerenControl.zeigePreisSonderwuensche(auswahl, anzahl);

        } else {
            innentuerenControl.zeigeFehlerSonderwunsch();
        }
        checkeMaenge();
    }

    @Override
    protected void speichereSonderwuensche() {
        kunde.getKunde().setSonderwuenscheInnentueren(innentuerenControl.getAusgewaehlteWuensche());
        db.speichereKunden(kunde.getKunde());
    }

    protected JTextField getTxtGesamtpreis() {
        return this.txtGesamtpreis;
    }
}
