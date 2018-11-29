package HibernateCont;

import java.util.HashSet;
import java.util.Set;

public class Haustyp {
    private Integer id;
    private Byte dachgeschoss;

    public Haustyp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getDachgeschoss() {
        return dachgeschoss;
    }

    public void setDachgeschoss(Byte dachgeschoss) {
        this.dachgeschoss = dachgeschoss;
    }
}
