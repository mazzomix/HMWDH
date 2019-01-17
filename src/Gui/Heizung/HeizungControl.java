package Gui.Heizung;

import Gui.Heizung.HeizungModel;
import Gui.Heizung.HeizungView;
import HibernateCont.SonderwuenscheHeizung;

import java.util.*;

public class HeizungControl {

    // das View-Objekt des Heizung-Fensters
    private HeizungView HeizungView;
    private HeizungModel HeizungModel;
    private List<SonderwuenscheHeizung> wuensche = new ArrayList();
    private List<SonderwuenscheHeizung> ausgewaehlteWuensche = new ArrayList<>();

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Heizung-Fenster und
     * oeffnet das View.
     */
    public HeizungControl(){

        this.HeizungView = new HeizungView(this);
        this.HeizungModel = new HeizungModel();
    }

    /**
     * macht das HeizungView-Objekt sichtbar.
     */
    public void oeffneHeizungView(){
        this.HeizungView.setVisible(true);
    }

    public void leseHeizungSonderwuensche(){
    }
    public void zeigePreisSonderwuensche() {
        this.HeizungModel.gesamtpreisBerechnen(this.ausgewaehlteWuensche);
        this.HeizungView.getTxtGesamtpreis().setText(""+HeizungModel.getPreis());
        this.HeizungModel.resetPreis();
    }

    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
        return true;
    }

    public List<SonderwuenscheHeizung> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheHeizung> wuensche) {
        this.wuensche = wuensche;
    }

    public List<SonderwuenscheHeizung> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheHeizung ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(List<SonderwuenscheHeizung> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheHeizung> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheHeizung element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }

    public void berechneAnzahl(int count, int wunschId){
        List<SonderwuenscheHeizung> liste = null;
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
        Map test = new HashMap();
        for (SonderwuenscheHeizung ausgewahlterWunsch: this.getAusgewaehlteWuensche()
             ) {
            if (ausgewahlterWunsch == null)continue;
            if(ausgewahlterWunsch.getId() == wunschId) count++;

        }
        return count;
    }
}