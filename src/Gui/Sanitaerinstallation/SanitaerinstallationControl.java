package Gui.Sanitaerinstallation;


import HibernateCont.SonderwuenscheSanitaerinstallation;

import java.util.*;

public final class SanitaerinstallationControl {


    private SanitaerinstallationView sanitaerinstallationView;
    private SanitaerinstallationModel sanitaerinstallationModel;
    private List<SonderwuenscheSanitaerinstallation> wuensche = new ArrayList();
    private Set<SonderwuenscheSanitaerinstallation> ausgewaehlteWuensche = new HashSet<>();

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Innentueren-Fenster und
     * oeffnet das View.
     */

    public SanitaerinstallationControl() {

        this.sanitaerinstallationView = new SanitaerinstallationView(this);
        this.sanitaerinstallationModel = new SanitaerinstallationModel();
    }


    public void oeffneSanitärinstallationView(){
        this.sanitaerinstallationView.setVisible(true);
    }

    public void leseSanitaerinstallationSonderwuensche(){}



    public boolean pruefeKonstellationSonderwuensche(double [] auswahl) {
        return this.sanitaerinstallationModel.getAuswahl();
    }

    public void zeigePreisSonderwuensche(double[] auswahl) {
        this.sanitaerinstallationModel.gesamtpreisBerechnen(auswahl);
        this.sanitaerinstallationView.getTxtGesamtpreis().setText("" + sanitaerinstallationModel.getPreis());
        this.sanitaerinstallationModel.resetPreis();
    }


    public void zeigeFehlerSonderwunsch() {
        this.sanitaerinstallationView.getTxtGesamtpreis().setText("Fehlerhafte Konstellation");
        this.sanitaerinstallationModel.resetAuswahl();
    }

    public List<SonderwuenscheSanitaerinstallation> getWuensche() {
        return wuensche;
    }

    public void setWuensche(List<SonderwuenscheSanitaerinstallation> wuensche) {
        this.wuensche = wuensche;
    }

    public Set<SonderwuenscheSanitaerinstallation> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }

    public void setAusgewaehlteWuensche(Set<SonderwuenscheSanitaerinstallation> ausgewaehlteWuensche) {
        this.ausgewaehlteWuensche = ausgewaehlteWuensche;
    }

    public void addAusgewaehltenWuensch(SonderwuenscheSanitaerinstallation ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }

    public void removeAusgewaehltenWunsch(Integer id) {
        for (Iterator<SonderwuenscheSanitaerinstallation> i = this.getAusgewaehlteWuensche().iterator(); i.hasNext();) {
            SonderwuenscheSanitaerinstallation element = i.next();
            if (element.getId() == id) {
                i.remove();
            }
        }
    }
}
