package Gui.Innentueren;

import Gui.Basis.BasisDatabaseMethods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InnentuerenPreisTest {


    @Test
    void testGesamtpreisBerechnen() {
        InnentuerenModel im = new InnentuerenModel();
        double[] preis_array1 = {10,20,40,80,160,320,640};
        int[] anzahle = {2,5,1,2,4,5,1};
        double[] preis_array2 = {25,50,100};
        int[] anzahle2 = {1,1,1};
        double[] preis_array3 = {412,3,7};
        int[] anzahle3 = {1,50,0};
        
        im.gesamtpreisBerechnen(preis_array1, anzahle);
        assertEquals(3056,im.getPreis());
        im.resetPreis();
        im.gesamtpreisBerechnen(preis_array2,anzahle2);
        assertEquals(175, im.getPreis());
        im.gesamtpreisBerechnen(preis_array2,anzahle2);
        assertEquals(562, im.getPreis());
        
    }

}
