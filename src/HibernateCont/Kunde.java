package HibernateCont;

import java.util.HashSet;
import java.util.Set;

public class Kunde {
    private Integer id;
    private String vorname;
    private String nachname;
    private String telefonNummer;
    private String email;
    private Byte deleted;
    private Hausnummer hausnummer;
    private Set<SonderwuenscheAussenanlagen> sonderwuenscheAussenanlagen = new HashSet<>();
    private Set<SonderwuenscheFensterAussentueren> sonderwuenscheFensterAussentueren = new HashSet<>();
    private Set<SonderwuenscheFliesen> sonderwuenscheFliesen = new HashSet<>();
    private Set<SonderwuenscheGrundriss> sonderwuenscheGrundriss = new HashSet<>();
    private Set<SonderwuenscheHeizung> sonderwuenscheHeizung = new HashSet<>();
    private Set<SonderwuenscheInnentueren> sonderwuenscheInnentueren = new HashSet<>();
    private Set<SonderwuenscheParkett> sonderwuenscheParkett = new HashSet<>();
    private Set<SonderwuenscheSanitaerinstallation> sonderwuenscheSanitaerinstallation = new HashSet<>();

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

    public Hausnummer getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(Hausnummer hausnummer) {
        this.hausnummer = hausnummer;
    }

    public Set<SonderwuenscheAussenanlagen> getSonderwuenscheAussenanlagen() {
        return sonderwuenscheAussenanlagen;
    }

    public void setSonderwuenscheAussenanlagen(Set<SonderwuenscheAussenanlagen> sonderwuenscheAussenanlagen) {
        this.sonderwuenscheAussenanlagen = sonderwuenscheAussenanlagen;
    }

    public Set<SonderwuenscheFensterAussentueren> getSonderwuenscheFensterAussentueren() {
        return sonderwuenscheFensterAussentueren;
    }

    public void setSonderwuenscheFensterAussentueren(Set<SonderwuenscheFensterAussentueren> sonderwuenscheFensterAussentueren) {
        this.sonderwuenscheFensterAussentueren = sonderwuenscheFensterAussentueren;
    }

    public Set<SonderwuenscheFliesen> getSonderwuenscheFliesen() {
        return sonderwuenscheFliesen;
    }

    public void setSonderwuenscheFliesen(Set<SonderwuenscheFliesen> sonderwuenscheFliesen) {
        this.sonderwuenscheFliesen = sonderwuenscheFliesen;
    }

    public Set<SonderwuenscheGrundriss> getSonderwuenscheGrundriss() {
        return sonderwuenscheGrundriss;
    }

    public void setSonderwuenscheGrundriss(Set<SonderwuenscheGrundriss> sonderwuenscheGrundriss) {
        this.sonderwuenscheGrundriss = sonderwuenscheGrundriss;
    }

    public Set<SonderwuenscheHeizung> getSonderwuenscheHeizung() {
        return sonderwuenscheHeizung;
    }

    public void setSonderwuenscheHeizung(Set<SonderwuenscheHeizung> sonderwuenscheHeizung) {
        this.sonderwuenscheHeizung = sonderwuenscheHeizung;
    }

    public Set<SonderwuenscheInnentueren> getSonderwuenscheInnentueren() {
        return sonderwuenscheInnentueren;
    }

    public void setSonderwuenscheInnentueren(Set<SonderwuenscheInnentueren> sonderwuenscheInnentueren) {
        this.sonderwuenscheInnentueren = sonderwuenscheInnentueren;
    }

    public Set<SonderwuenscheParkett> getSonderwuenscheParkett() {
        return sonderwuenscheParkett;
    }

    public void setSonderwuenscheParkett(Set<SonderwuenscheParkett> sonderwuenscheParkett) {
        this.sonderwuenscheParkett = sonderwuenscheParkett;
    }

    public Set<SonderwuenscheSanitaerinstallation> getSonderwuenscheSanitaerinstallation() {
        return sonderwuenscheSanitaerinstallation;
    }

    public void setSonderwuenscheSanitaerinstallation(Set<SonderwuenscheSanitaerinstallation> sonderwuenscheSanitaerinstallation) {
        this.sonderwuenscheSanitaerinstallation = sonderwuenscheSanitaerinstallation;
    }
}
