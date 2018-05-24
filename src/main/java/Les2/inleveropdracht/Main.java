//Joost Luijben
//1718331
//V1E
//Inleveropdracht persistentie 1
package Les2.inleveropdracht;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //get all the persons
        ReizigerDAOImpl rzi = new ReizigerDAOImpl();
        System.out.println(rzi.findAll());

        //find a person by date
        System.out.println(rzi.findByGBdatum("2002-09-17"));
        //create a new person and save it, print all persons to see if it is actually saved
        Reiziger rz = new Reiziger("J Luijben", Date.valueOf("2002-09-17"), 6);
        rzi.save(rz);
        System.out.println(rzi.findAll());

        //update the new persons name
        rz.setNaam("John Baker");
        rzi.update(rz);
        System.out.println(rzi.findAll());

        //and delete it again
        System.out.println(rzi.delete(rz));
        System.out.println(rzi.findAll() + "\n");

        //create a existing person with only it's id and get it's OVcards
        Reiziger reiz = new Reiziger(2);
        System.out.println(rzi.getOVchipkaarten(reiz));

        //create a new ovi and a new OV card to get the owner of the OVcard
        OVchipkaartDAOImpl ovi = new OVchipkaartDAOImpl();
        OVchipkaart ov = new OVchipkaart(35283, Date.valueOf("2018-05-31"), 2, 25.50, 2);
        System.out.println(ovi.getReiziger(ov));
    }

}
