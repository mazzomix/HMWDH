package Gui.Aussenanlage;

import HibernateCont.SonderwuenscheAussenanlagen;

import java.util.*;

public final class AussenanlageControl {
    private AussenanlageView aussenanlageControl;
    private double preis;
    private List<SonderwuenscheAussenanlagen> wuensche = new ArrayList();
    private Set<SonderwuenscheAussenanlagen> ausgewaehlteWuensche = new HashSet<>();



    public AussenanlageControl() { this.aussenanlageControl = new AussenanlageView(this);}

    public void oeffneAussenanlageView(){this.aussenanlageControl.setVisible(true);}

    public void leseAussenanlageSonderwuensche(){}

    public boolean pruefeKonstellationSonderwuensche(int [] ausgewaehlteSw) { return true;}

    public double berechnePreis(){
        preis = 0;
        this.ausgewaehlteWuensche = new HashSet<>();
        if(aussenanlageControl.chckBxEGAbstellraumTerrasse.isSelected() == true){
            preis += this.getWuensche().get(0).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(0));
        }
        if(aussenanlageControl.chckBxVorbereitungEleAntriebe.isSelected() == true){
            preis += this.getWuensche().get(1).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(1));
        }
        if(aussenanlageControl.chckBxDGVorbereitungEleAntriebe.isSelected() == true){
            preis += this.getWuensche().get(2).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(2));
        }
        if(aussenanlageControl.chckBxEGElektrischeMarkise.isSelected() == true){
            preis += this.getWuensche().get(3).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(3));
        }
        if(aussenanlageControl.chckBxDGElektrischeMarkise.isSelected() == true){
            preis += this.getWuensche().get(4).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(4));
        }
        if(aussenanlageControl.chckBxEleAntriebGaragentor.isSelected() == true){
            preis += this.getWuensche().get(5).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(5));
        }
        if(aussenanlageControl.chckBxSektionaltor.isSelected() == true){
            preis += this.getWuensche().get(6).getPreis();
            this.addAusgewaehltenWuensch(this.getWuensche().get(6));
        }
        return preis;
    }

    public List<SonderwuenscheAussenanlagen> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheAussenanlagen> wuensche) {
        this.wuensche = wuensche;
    }

    public Set<SonderwuenscheAussenanlagen> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheAussenanlagen ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheAussenanlagen> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
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
