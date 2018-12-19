package Gui.Grundriss;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrundrissViewTest {

    @Test
    void speichereSonderwuensche() {
        GrundrissControl gc = new GrundrissControl();
        GrundrissView gv = new GrundrissView(gc);
        KundeModel kundeModel = KundeModel.getInstance();
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();

        kundeModel.setKunde(db.holeKunde(1));

        kundeModel.getKunde().setSonderwuenscheGrundriss(gc.getAusgewaehlteWuensche());
        assertTrue(kundeModel.getKunde().getSonderwuenscheGrundriss() == gc.getAusgewaehlteWuensche());

    }
}