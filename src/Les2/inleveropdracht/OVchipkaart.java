/*
1718331
Joost Luijben
Les2.voorbereidendeopdracht
*/

package Les2.inleveropdracht;

import java.sql.Date;

public class OVchipkaart {
    private int kaartnummer;
    private Date geldigTot;
    private int klasse;
    private double saldo;
    private int reizigerID;

    public OVchipkaart(int kaartnummer, Date geldigTot, int klasse, double saldo, int reizigerID) {
        this.kaartnummer = kaartnummer;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reizigerID = reizigerID;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public String toString() {
        String str = "\n" + "OVchipkaart: \n";
        str += "kaartnummer: " + kaartnummer + "\n";
        str += "geldig tot : " + geldigTot + "\n";
        str += "klasse: " + klasse + "\n";
        str += "saldo:" + saldo + "\n";
        str += "reizigersID: " + reizigerID + "\n";
        return str;
    }
}
