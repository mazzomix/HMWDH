package hibernateCont;

import java.util.HashSet;
import java.util.Set;

public class SonderwuenscheInnentueren {
    private Integer id;
    private String wunsch;
    private Double preis;

    private Set<Kunde> kunden = new HashSet<>();

    public SonderwuenscheInnentueren() {
    }

    public SonderwuenscheInnentueren(String wunsch, Double preis) {
        this.wunsch = wunsch;
        this.preis = preis;
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

    public String getWunsch() {
        return wunsch;
    }

    public void setWunsch(String wunsch) {
        this.wunsch = wunsch;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Set<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(Set<Kunde> kunden) {
        this.kunden = kunden;
    }
}
