package Gui.Heizung;

import HibernateCont.SonderwuenscheHeizung;

import java.util.ArrayList;
import java.util.List;

public class HeizungModel {
    private double _preis = 0;
    public void gesamtpreisBerechnen (List<SonderwuenscheHeizung> wuensche) {
        for (SonderwuenscheHeizung wunsch: wuensche
             ) {
            _preis += wunsch.getPreis();
        }

    }
    public double getPreis() {
        return _preis;
    }
    public void resetPreis() {
        _preis = 0;
    }
}
