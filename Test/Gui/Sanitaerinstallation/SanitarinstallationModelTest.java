package Gui.Sanitaerinstllation;

import Business.KundeModel;
import Gui.Basis.BasisDatabaseMethods;
import HibernateCont.Kunde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SanitaerinstallationModelTest{

    @Test
    void testGesamtpreisBerechnen() {
        SanitaerinstallationModel sm = new SanitaerinstallationModel();
        double[] array_preise1 = {590,590,690,190,190,190,990,990,990};
        double[] array_preise2 = {0,0,0,0,0,0,0,0,0};
        double[] array_preise3 = {590,590,690,190,190,0,990,990,0};
        sm.gesamtpreisBerechnen(array_preise1);
        assertEquals(5410,sm.getPreis());
        sm.gesamtpreisBerechnen(array_preise3);
        assertEquals(4230, sm.getPreis());
        sm.resetPreis();
        sm.gesamtpreisBerechnen(array_preise2);
        assertEquals(0,sm.getPreis());
    }














}