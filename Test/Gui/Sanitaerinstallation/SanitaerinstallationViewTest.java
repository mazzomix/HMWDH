package Gui.Sanitaerinstallation;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SanitaerinstallationViewTest {

    @Test
    void speichereSonderwuensche() {
        SanitaerinstallationControl sc = new SanitaerinstallationControl();
        SanitaerinstallationView sv = new SanitaerinstallationView(sc);
        KundeModel kundeModel = KundeModel.getInstance();
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();

        kundeModel.setKunde(db.holeKunde(1));

        kundeModel.getKunde().setSonderwuenscheSanitaerinstallation(sc.getAusgewaehlteWuensche());
        assertTrue(kundeModel.getKunde().getSonderwuenscheSanitaerinstallation() == sc.getAusgewaehlteWuensche());

    }
}