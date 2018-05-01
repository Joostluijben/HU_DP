//Joost Luijben
//1718331
//V1E
//lesopdracht persistentie 1
package Les2.lesopdracht;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ReizigerDAOImpl rzi = new ReizigerDAOImpl();
        System.out.println(rzi.findAll());

        System.out.println(rzi.findByGBdatum("2002-09-17"));

        Reiziger rz = new Reiziger();
        rz.setNaam("J Luijben");
        rz.setGBdatum(Date.valueOf("2002-09-17"));
        rz.setID(6);
        rzi.save(rz);
        System.out.println(rzi.findAll());

        rz.setNaam("John Baker");
        rzi.update(rz);
        System.out.println(rzi.findAll());

        System.out.println(rzi.delete(rz));
        System.out.println(rzi.findAll());
        OracleBaseDao.closeConnection();
    }
}
