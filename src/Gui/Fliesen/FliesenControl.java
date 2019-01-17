package Gui.Fliesen;

import Business.KundeModel;
import HibernateCont.SonderwuenscheFliesen;

import java.util.*;

public class FliesenControl {

    // das View-Objekt des Fliesen-Fensters
    private FliesenView fliesenView;
    private FliesenModel fliesenModel;
    private KundeModel kunde;
    private List<SonderwuenscheFliesen> wuensche = new ArrayList();
    private Set<SonderwuenscheFliesen> ausgewaehlteWuensche = new HashSet<>();

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Fliesen-Fenster und
     * oeffnet das View.
     */
    public FliesenControl(){
        this.kunde = KundeModel.getInstance();
        this.fliesenView = new FliesenView(this);
        this.fliesenModel = new FliesenModel();
    }

    /**
     * macht das FliesenView-Objekt sichtbar.
     */
    public void oeffneFliesenView(){
        this.fliesenView.setVisible(true);
    }

    public void leseFliesenSonderwuensche(){
    }
    public void zeigePreisSonderwuensche(double[] auswahl) {
        this.fliesenModel.gesamtpreisBerechnen(auswahl);
        this.fliesenView.getTxtGesamtpreis().setText(""+fliesenModel.getPreis());
        this.fliesenModel.resetPreis();
    }

    public void zeigeFehlerSonderwunsch () {
        this.fliesenView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.fliesenModel.resetAuswahl();
    }

    public boolean pruefeKonstellationSonderwuensche(double[] ausgewaehlteSw){
        this.fliesenModel.checkAuswahl(ausgewaehlteSw, kunde);
        return this.fliesenModel.getAuswahl();
    }
    public List<SonderwuenscheFliesen> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheFliesen> wuensche) {
        this.wuensche = wuensche;
    }

    public Set<SonderwuenscheFliesen> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheFliesen ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheFliesen> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheFliesen> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheFliesen element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }
}

