package Gui.Grundriss;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import HibernateCont.Kunde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrundrissModelTest {


    @Test
    void testGesamtpreisBerechnen() {
        GrundrissModel gm = new GrundrissModel();
        double[] preis_array1 = {300,300,0, 890, 990,8990};
        double[] preis_array2 = {300,300,0,0,0,0};
        gm.gesamtpreisBerechnen(preis_array1);
        assertEquals(11470,gm.getPreis());
        gm.resetPreis();
        gm.gesamtpreisBerechnen(preis_array2);
        assertEquals(600, gm.getPreis());
    }


    @Test
    void testCheckAuswahl() {
        KundeModel kundeModel = KundeModel.getInstance();
        BasisDatabaseMethods db = BasisDatabaseMethods.getInstance();
        double[] auswahl_array1 = {300,300,0, 890, 990,8990};
        double[] auswahl_array2 = {300,300,0,0,0,0};
        GrundrissModel gm = new GrundrissModel();

        kundeModel.setKunde(db.holeKunde(1));
        gm.checkAuswahl(auswahl_array2);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();
        gm.checkAuswahl(auswahl_array1);
        assertFalse(gm.getAuswahl());
        gm.resetAuswahl();


        kundeModel.setKunde(db.holeKunde(2));
        gm.checkAuswahl(auswahl_array2);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();
        gm.checkAuswahl(auswahl_array1);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();

        kundeModel.setKunde(db.holeKunde(3));
        gm.checkAuswahl(auswahl_array2);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();
        gm.checkAuswahl(auswahl_array1);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();

        kundeModel.setKunde(db.holeKunde(4));
        gm.checkAuswahl(auswahl_array2);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();
        gm.checkAuswahl(auswahl_array1);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();

        kundeModel.setKunde(db.holeKunde(5));
        gm.checkAuswahl(auswahl_array2);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();
        gm.checkAuswahl(auswahl_array1);
        assertTrue(gm.getAuswahl());
        gm.resetAuswahl();

    }

}
