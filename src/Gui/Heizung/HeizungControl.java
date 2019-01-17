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
    private Set<SonderwuenscheHeizung> ausgewaehlteWuensche = new HashSet<>();

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
    public void zeigePreisSonderwuensche(double[] auswahl,int [] stueck) {
        this.HeizungModel.gesamtpreisBerechnen(auswahl,stueck);
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

    public Set<SonderwuenscheHeizung> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheHeizung ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheHeizung> ausgewaehlteWuensche) {
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
}