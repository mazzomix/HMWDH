package Gui.FensterAussentueren;

import HibernateCont.SonderwuenscheFensterAussentueren;

import java.util.*;

public class FensterAussentuerenControl {

    // das View-Objekt des FensterAussentueren-Fensters
    private FensterAussentuerenView fensterAussentuerenView;
    private FensterAussentuerenModel fensterAussentuerenModel;
    private List<SonderwuenscheFensterAussentueren> wuensche = new ArrayList();
    private Set<SonderwuenscheFensterAussentueren> ausgewaehlteWuensche = new HashSet<>();

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum FensterAussentueren-Fenster und
     * oeffnet das View.
     */
    public FensterAussentuerenControl(){

        this.fensterAussentuerenView = new FensterAussentuerenView(this);
        this.fensterAussentuerenModel = new FensterAussentuerenModel();

    }

    /**
     * macht das FensterAussentuerenView-Objekt sichtbar.
     */
    public void oeffneFensterAussentuerenView(){
        this.fensterAussentuerenView.setVisible(true);
    }

    public void leseFensterAussentuerenSonderwuensche(){
    }
    public void zeigePreisSonderwuensche(double[] auswahl) {
        this.fensterAussentuerenModel.gesamtpreisBerechnen(auswahl);
        this.fensterAussentuerenView.getTxtGesamtpreis().setText(""+fensterAussentuerenModel.getPreis());
        this.fensterAussentuerenModel.resetPreis();
    }

    public void zeigeFehlerSonderwunsch () {
        this.fensterAussentuerenView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.fensterAussentuerenModel.resetAuswahl();
    }

    public boolean pruefeKonstellationSonderwuensche(double[] ausgewaehlteSw){

        this.fensterAussentuerenModel.checkAuswahl(ausgewaehlteSw);
        return this.fensterAussentuerenModel.getAuswahl();
    }

    public List<SonderwuenscheFensterAussentueren> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheFensterAussentueren> wuensche) {
        this.wuensche = wuensche;
    }

    public Set<SonderwuenscheFensterAussentueren> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheFensterAussentueren ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheFensterAussentueren> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheFensterAussentueren> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheFensterAussentueren element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }
}
