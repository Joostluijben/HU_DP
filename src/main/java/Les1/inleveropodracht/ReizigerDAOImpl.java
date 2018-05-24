package Les1.inleveropodracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOImpl implements ReizigerDAO {
    private static Connection conn;
    public ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();

    public List<Reiziger> findAll() throws SQLException, ClassNotFoundException{
        // Per ongeluk te ver doorgewerkt! Dit is om verbinding te maken met de DB, maar ik heb het er in gelaten

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:OV@//localhost:1521/xe", "OV", "oracle");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM REIZIGER");
        while (result.next()) {
            Reiziger rz = new Reiziger();
            rz.setGBdatum(Date.valueOf(result.getString(5).split(" ")[0]));
            String naam = result.getString(2) + " ";
            if (result.getString(3) != null) {
                naam += result.getString(3) + " ";
            }
            naam += result.getString(4);
            rz.setNaam(naam);
            reizigers.add(rz);
        }
        return reizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException, ClassNotFoundException{
        // Per ongeluk te ver doorgewerkt! Dit is om verbinding te maken met de DB!

        /*Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:OV@//localhost:1521/xe", "OV", "oracle");
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM REIZIGER WHERE GEBORTEDATUM = TO_DATE(?, 'dd-mm-yyyy')");
        statement.setString(1, GBdatum);
        ResultSet result = statement.executeQuery();
        List<Reiziger> reizigers = new ArrayList<Reiziger>();
        while (result.next()) {
            Reiziger rz = new Reiziger();
            rz.setGBdatum(Date.valueOf(result.getString(5).split(" ")[0]));
            String naam = result.getString(2) + " ";
            if (result.getString(3) != null) {
                naam += result.getString(3) + " ";
            }
            naam += result.getString(4);
            rz.setNaam(naam);
            reizigers.add(rz);
        }*/


        ArrayList<Reiziger> rzs = new ArrayList<Reiziger>();
        for (Reiziger rz : reizigers) {
            if (rz.getGBdatum().equals(Date.valueOf(GBdatum))) {
                rzs.add(rz);
            }
        }
        return rzs;
    }

    public Reiziger save(Reiziger reiziger) {
        reizigers.add(reiziger);
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) {
        for (Reiziger rz : reizigers) {
            if (rz.equals(reiziger)) {
                reizigers.remove(rz);
                reizigers.add(reiziger);
            }
        }
        return reiziger;
    }

    public boolean delete(Reiziger reiziger) {
        reizigers.remove(reiziger);
       return reizigers.contains(reiziger);
    }
}
