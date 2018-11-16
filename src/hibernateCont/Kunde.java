package hibernateCont;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Kunde {
    private Integer id;
    private String vorname;
    private String nachname;
    private String telefonNummer;
    private String email;
    private Byte deleted;
    private Haustyp haustyp;
    private Set<SonderwuenscheAussenanlagen> sonderwuenscheAussenanlagen = new HashSet<>();

    public Kunde() {
        this.deleted = 0;
    }

    public Kunde(String vorname, String nachname, String telefonNummer, String email) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonNummer = telefonNummer;
        this.email = email;
        this.deleted = 0;
    }

    public void addSonderWunsch(SonderwuenscheAussenanlagen sonderWunsch) {
        this.sonderwuenscheAussenanlagen.add(sonderWunsch);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Haustyp getHaustyp() { return haustyp; }

    public void setHaustyp(Haustyp haustyp) { this.haustyp = haustyp; }

    public Set<SonderwuenscheAussenanlagen> getSonderwuenscheAussenanlagen() {
        return sonderwuenscheAussenanlagen;
    }

    public void setSonderwuenscheAussenanlagen(Set<SonderwuenscheAussenanlagen> sonderwuenscheAussenanlagen) {
        this.sonderwuenscheAussenanlagen = sonderwuenscheAussenanlagen;
    }
}
