package Gui.FensterAussentueren;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FensterAussentuerenViewTest {

    @Test
    void speichereSonderwuensche() {
        FensterAussentuerenControl gc = new FensterAussentuerenControl();
        FensterAussentuerenView gv = new FensterAussentuerenView(gc);
        KundeModel kundeModel = KundeModel.getInstance();
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();

        kundeModel.setKunde(db.holeKunde(1));

        kundeModel.getKunde().setSonderwuenscheFensterAussentueren(gc.getAusgewaehlteWuensche());
        assertTrue(kundeModel.getKunde().getSonderwuenscheFensterAussentueren() == gc.getAusgewaehlteWuensche());
    }
}