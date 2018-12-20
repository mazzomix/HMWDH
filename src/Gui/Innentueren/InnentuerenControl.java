package Gui.Innentueren;

import HibernateCont.SonderwuenscheInnentueren;

import java.util.*;

public class InnentuerenControl {

    // das View-Objekt des Grundriss-Fensters TESTZWECK
    private InnentuerenView innentuerenView;
    private InnentuerenModel innentuerenModel;
    private List<SonderwuenscheInnentueren> wuensche = new ArrayList();
    private Set<SonderwuenscheInnentueren> ausgewaehlteWuensche = new HashSet<>();

    /**
     * erzeugt ein das View-Objekt und Model-Objekt zum Innentueren-Fenster und
     * oeffnet das View.
     */
    public InnentuerenControl() {
        this.innentuerenView = new InnentuerenView(this);
        this.innentuerenModel = new InnentuerenModel();
    }

    public void oeffneInnentuerenView() {
        this.innentuerenView.setVisible(true);
    }

    public void leseInnentuerenSonderwuensche() {
    }

    public boolean pruefeKonstellationSonderwuensche(double[] auswahl) {
        return this.innentuerenModel.getAuswahl();
    }

    public void zeigePreisSonderwuensche(double[] auswahl, int[] anzahl) {
        this.innentuerenModel.gesamtpreisBerechnen(auswahl, anzahl);
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
    
    public Set<SonderwuenscheInnentueren> getAusgewaehlteWuensche() {
        return ausgewaehlteWuensche;
    }
    
    public void addAusgewaehltenWuensch(SonderwuenscheInnentueren ausgewaehlterWuensch) {
        this.ausgewaehlteWuensche.add(ausgewaehlterWuensch);
    }
    
    public void setAusgewaehlteWuensche(Set<SonderwuenscheInnentueren> ausgewaehlteWuensche) {
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
    
}
