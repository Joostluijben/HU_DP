package Les2.inleveropdracht;

import java.util.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;
    private int reizigersID;

    public Reiziger() {

    }

    public Reiziger(int ID) {
        reizigersID = ID;
    }

    public Reiziger(String nm, Date gb, int ID) {
        naam = nm;
        gbdatum = gb;
        reizigersID = ID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGBdatum() {
        return gbdatum;
    }

    public void setGBdatum(Date datum) {
        gbdatum = datum;
    }

    public String toString() {
        return naam + " " + gbdatum;
    }

    public int getReizigersID() {
        return reizigersID;
    }

}
