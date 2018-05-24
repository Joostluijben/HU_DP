/*
1718331
Joost Luijben
Les2.voorbereidendeopdracht
*/

package Les3.inleveropdracht;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OVchipkaart {
    private int kaartnummer;
    private Date geldigTot;
    private int klasse;
    private double saldo;
    private int reizigerID;
    private ArrayList<Product> producten = new ArrayList<>();

    public OVchipkaart(int kaartnummer, Date geldigTot, int klasse, double saldo, int reizigerID) {
        this.kaartnummer = kaartnummer;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reizigerID = reizigerID;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }

    ArrayList<Product> getProducten() {
        return producten;
    }

    void setProducten(ArrayList<Product> producten) {
        this.producten = producten;
    }

    @Override
    public String toString() {
        return "OVchipkaart{" +
                "kaartnummer=" + kaartnummer +
                ", geldigTot=" + geldigTot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reizigerID=" + reizigerID +
                ", producten=" + producten +
                "}\n";
    }
}
