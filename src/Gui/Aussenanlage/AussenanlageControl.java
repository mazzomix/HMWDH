package Gui.Aussenanlage;

import Business.KundeModel;
import HibernateCont.SonderwuenscheAussenanlagen;

import java.util.*;

public final class AussenanlageControl {
    private AussenanlageView aussenanlageView;
    private  AussenanlageModel aussenanlageModel;
    private double preis;
    KundeModel kunde;
    private List<SonderwuenscheAussenanlagen> wuensche = new ArrayList();
    private Set<SonderwuenscheAussenanlagen> ausgewaehlteWuensche = new HashSet<>();



    public AussenanlageControl() {
        this.aussenanlageView = new AussenanlageView(this);
        this.aussenanlageModel = new AussenanlageModel();
        this.kunde = KundeModel.getInstance();
    }

    public void oeffneAussenanlageView(){
        this.aussenanlageView.setVisible(true);
    }

    public void leseAussenanlageSonderwuensche(){}

    public boolean pruefeKonstellationSonderwuensche(double [] ausgewaehlteSw)
    {
        this.aussenanlageModel.checkAuswahl(ausgewaehlteSw);
        return this.aussenanlageModel.getAuswahl();

    }

   /* public double berechnePreis(){
        preis = 0;
        this.ausgewaehlteWuensche = new HashSet<>();
        if(aussenanlageView.chckBxEGAbstellraumTerrasse.isSelected() == true){
            preis += this.getWuensche().get(0).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(0));
        }
        if(aussenanlageView.chckBxVorbereitungEleAntriebe.isSelected() == true){
            preis += this.getWuensche().get(1).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(1));
        }
        if(aussenanlageView.chckBxDGVorbereitungEleAntriebe.isSelected() == true){
            preis += this.getWuensche().get(2).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(2));
        }
        if(aussenanlageView.chckBxEGElektrischeMarkise.isSelected() == true){
            preis += this.getWuensche().get(3).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(3));
        }
        if(aussenanlageView.chckBxDGElektrischeMarkise.isSelected() == true){
            preis += this.getWuensche().get(4).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(4));
        }
        if(aussenanlageView.chckBxEleAntriebGaragentor.isSelected() == true){
            preis += this.getWuensche().get(5).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(5));
        }
        if(aussenanlageView.chckBxSektionaltor.isSelected() == true){
            preis += this.getWuensche().get(6).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(6));
        }
        return preis;
    }*/

    public void zeigePreisSonderwuensche(double[] auswahl) {
        this.aussenanlageModel.gesamtpreisBerechnen(auswahl);
        this.aussenanlageView.getTxtGesamtpreis().setText(""+aussenanlageModel.getPreis());
        this.aussenanlageModel.resetPreis();
    }

    public void zeigeFehlerSonderwunsch () {
        this.aussenanlageView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.aussenanlageModel.resetAuswahl();
    }

    public void addWunsch(SonderwuenscheAussenanlagen wunsch) {
        this.wuensche.add(wunsch);
    }

    public Set<SonderwuenscheAussenanlagen> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheAussenanlagen> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheAussenanlagen ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public List<SonderwuenscheAussenanlagen> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheAussenanlagen> wuensche) {
        this.wuensche = wuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheAussenanlagen> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheAussenanlagen element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }

}
