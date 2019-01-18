package Gui.Innentueren;

import Business.KundeModel;
import HibernateCont.SonderwuenscheInnentueren;

import java.util.*;

public class InnentuerenControl {

    
    private InnentuerenView innentuerenView;
    private InnentuerenModel innentuerenModel;
    private List<SonderwuenscheInnentueren> wuensche = new ArrayList();
    private List<SonderwuenscheInnentueren> ausgewaehlteWuensche = new ArrayList<>();
    KundeModel kunde;

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Innentueren-Fenster und
     * oeffnet das View.
     */
    public InnentuerenControl() {
        this.innentuerenView = new InnentuerenView(this);
        this.innentuerenModel = new InnentuerenModel();
        this.kunde = KundeModel.getInstance();
    }

    public void oeffneInnentuerenView() {
        this.innentuerenView.setVisible(true);
    }

    public void leseInnentuerenSonderwuensche() {
    }

    public boolean pruefeKonstellationSonderwuensche() {
        this.innentuerenModel.initializeData();
        for (SonderwuenscheInnentueren wunsch: this.ausgewaehlteWuensche
             ) {
            switch (wunsch.getId()){
                case 1:
                    if(!this.innentuerenModel.check41(this.getAnzahlSonderwunsch(1))) return false;
                    break;
                case 2:
                    if(!this.innentuerenModel.check42(this.getAnzahlSonderwunsch(2))) return false;
                    break;
                case 3:
                    if(!this.innentuerenModel.check43()) return false;
                    break;
            }
        }
        return this.innentuerenModel.getAuswahl();
    }

    public void zeigePreisSonderwuensche(double[] auswahl, int[] anzahl) {
        this.innentuerenModel.gesamtpreisBerechnen(this.ausgewaehlteWuensche);
        this.innentuerenView.getTxtGesamtpreis().setText("" + innentuerenModel.getPreis());
        this.innentuerenModel.resetPreis();
       
    }

    public void zeigeFehlerSonderwunsch() {
        this.innentuerenView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.innentuerenModel.resetAuswahl();
    }
    
    public List<SonderwuenscheInnentueren> getWuensche() {
        return wuensche;
    }
    
    public void setWuensche(List<SonderwuenscheInnentueren> wuensche) {
        this.wuensche = wuensche;
    }
    
    public List<SonderwuenscheInnentueren> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }
    
    public void addAusgewaehltenWuensch(SonderwuenscheInnentueren ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }
    
    public void setAusgewaehlteWuensche(List<SonderwuenscheInnentueren> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }
    
    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheInnentueren> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheInnentueren element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }

    public void berechneAnzahl(int count, int wunschId){
        List<SonderwuenscheInnentueren> liste = null;
        if(this.getAusgewaehlteWuensche() == null){
            liste = new ArrayList<>();
        } else{
            liste = this.getAusgewaehlteWuensche();
        }
        for (int i = 0; i<count; i++){
            liste.add(this.getWuensche().get(wunschId));
        }
        this.setAusgewaehlteWuensche(liste);
    }

    public int getAnzahlSonderwunsch(int wunschId){
        int count = 0;
        for (SonderwuenscheInnentueren ausgewahlterWunsch: this.getAusgewaehlteWuensche()
        ) {
            if (ausgewahlterWunsch == null)continue;
            if(ausgewahlterWunsch.getId() == wunschId) count++;

        }
        return count;
    }
    
}
