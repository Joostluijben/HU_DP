//Joost Luijben
//1718331
//V1E
//Inleveropdracht persistentie 1
package Les1.inleveropodracht;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static Connection conn;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ReizigerDAOImpl rzi = new ReizigerDAOImpl();
        System.out.println(rzi.findAll());

        System.out.println(rzi.findByGBdatum("2002-09-17"));

        Reiziger rz = new Reiziger();
        rz.setNaam("Joost");
        rz.setGBdatum(Date.valueOf("2002-09-17"));
        rzi.save(rz);
        System.out.println(rzi.reizigers);

        rz.setNaam("John");
        rzi.update(rz);
        System.out.println(rzi.reizigers);

        rzi.delete(rz);
        System.out.println(rzi.reizigers);
    }
}
