package HibernateCont;

import java.util.Objects;

public class Hausnummer {
    private Integer id;
    private Integer hausnummer;
    private Haustyp haustyp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(Integer hausnummer) {
        this.hausnummer = hausnummer;
    }

    public Haustyp getHaustyp() {
        return haustyp;
    }

    public void setHaustyp(Haustyp haustyp) {
        this.haustyp = haustyp;
    }
}
