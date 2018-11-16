package hibernateCont;

import java.util.HashSet;
import java.util.Set;

public class Haustyp {
    private Integer id;
    private Byte dachgeschoss;
    private Set<Kunde> kunden = new HashSet<>();

    public Haustyp() {
    }

    public void addKunde(Kunde kunde) {
        this.kunden.add(kunde);
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

    public Set<Kunde> getKunden() { return kunden; }

    public void setKunden(Set<Kunde> kunden) { this.kunden = kunden; }
}
