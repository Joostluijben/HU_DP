package Les3.lesopdracht;

import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;
    private int reizigerID;
    private ArrayList<OVchipkaart> OVs;

    public Reiziger() {

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

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int ID) {
        reizigerID = ID;
    }


}
