package Les2.inleveropdracht;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reiziger {
    private String naam;
    private Date gbdatum;
    private int reizigersID;
    private List<OVchipkaart> oVchipkaart;

    public Reiziger() {

    }

    public Reiziger(int ID) {
        reizigersID = ID;
    }

    public Reiziger(String naam, Date gbdatum, int reizigersID) {
        this.naam = naam;
        this.gbdatum = gbdatum;
        this.reizigersID = reizigersID;
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

    public int getReizigersID() {
        return reizigersID;
    }

    public List<OVchipkaart> getoVchipkaart() {
        return oVchipkaart;
    }

    public void setoVchipkaart(List<OVchipkaart> oVchipkaart) {
        this.oVchipkaart = oVchipkaart;
    }

    public String toString() {
        return "Reiziger{" +
                "naam='" + naam + '\'' +
                ", gbdatum=" + gbdatum +
                ", reizigersID=" + reizigersID +
                ", oVchipkaart=" + oVchipkaart +
                '}';
    }
}
