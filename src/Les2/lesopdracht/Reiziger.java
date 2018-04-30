package Les2.lesopdracht;

import java.util.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;
    private int reizigersID;

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

    public int getID() {
        return reizigersID;
    }

    public void setID(int ID) {
        reizigersID = ID;
    }

    @Override
    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;
        if (andereObject instanceof Reiziger) {
            Reiziger andereReiziger = (Reiziger) andereObject;
            if (andereReiziger.naam.equals(this.naam) &&
                    andereReiziger.gbdatum.equals(this.gbdatum)) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }
}
