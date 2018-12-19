package Gui.FensterAussentueren;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FensterAussentuerenModelTest {

    @Test
    void testGesamtpreisBerechnen() {
        FensterAussentuerenModel fm = new FensterAussentuerenModel();
        double[] array_preise1 = {590,590,690,190,190,190,990,990,990};
        double[] array_preise2 = {0,0,0,0,0,0,0,0,0};
        double[] array_preise3 = {590,590,690,190,190,0,990,990,0};
        fm.gesamtpreisBerechnen(array_preise1);
        assertEquals(5410,fm.getPreis());
        fm.resetPreis();
        fm.gesamtpreisBerechnen(array_preise3);
        assertEquals(4230, fm.getPreis());
        fm.resetPreis();
        fm.gesamtpreisBerechnen(array_preise2);
        assertEquals(0,fm.getPreis());
    }
}
