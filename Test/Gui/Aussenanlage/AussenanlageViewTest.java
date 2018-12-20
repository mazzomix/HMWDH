package Gui.Aussenanlage;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AussenanlageViewTest {

    @Test
    void speichereSonderwuensche() {
        AussenanlageControl ac = new AussenanlageControl();
        AussenanlageView av = new AussenanlageView(ac);
        KundeModel kundeModel = KundeModel.getInstance();
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();

        kundeModel.setKunde(db.holeKunde(1));

        kundeModel.getKunde().setSonderwuenscheAussenanlagen(ac.getAusgewaehlteWuensche());
        assertTrue(kundeModel.getKunde().getSonderwuenscheAussenanlagen() == ac.getAusgewaehlteWuensche());
    }
}
