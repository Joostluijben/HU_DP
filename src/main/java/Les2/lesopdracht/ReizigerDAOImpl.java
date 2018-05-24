package Les2.lesopdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOImpl extends OracleBaseDao implements ReizigerDAO {
    private Connection conn = getConnection();

    public ReizigerDAOImpl() throws SQLException, ClassNotFoundException {
    }

    public List<Reiziger> findAll() throws SQLException {
        //execute the query and get the rows
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM REIZIGER");

        //prepare a list
        List<Reiziger> reizigers = new ArrayList<>();

        //for every row, create a user. Fill the attributes and add to arraylist
        while (result.next()) {
            Reiziger rz = new Reiziger();

            //because it is a datetime object (2002-09-17 00:00:00.0) take the first element
            rz.setGBdatum(Date.valueOf(result.getString(5).split(" ")[0]));

            //create the name. First the first name
            String naam = result.getString(2) + " ";
            if (result.getString(3) != null) {
                //if there is an infix, add it
                naam += result.getString(3) + " ";
            }
            //add surname
            naam += result.getString(4);
            //because every is string, parse it to int
            rz.setID(Integer.parseInt(result.getString(1)));
            rz.setNaam(naam);
            reizigers.add(rz);
        }
        return reizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException {
        //use a prepared statement where date is parameter
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM REIZIGER WHERE GEBORTEDATUM = TO_DATE(?, 'yyyy-MM-dd')");
        //put date in parameter
        statement.setString(1, GBdatum);
        ResultSet result = statement.executeQuery();

        //because there could be more than one person with same date, arraylist
        List<Reiziger> reizigers = new ArrayList<>();

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

    public Reiziger save(Reiziger reiziger) throws SQLException {
        //prepare statement with values as parameter
        PreparedStatement statement = conn.prepareStatement("INSERT INTO REIZIGER VALUES(?, ?, ?, ?, TO_DATE(?, 'yyyy-MM-dd'))");

        //everything has to be string, so convert number to string
        statement.setString(1, String.valueOf(reiziger.getID()));
        //get the first letter of the name and make it uppercase
        statement.setString(2, String.valueOf(reiziger.getNaam().toUpperCase().charAt(0)));

        //split the name and put it in an stringarray
        String[] naam = reiziger.getNaam().split(" ");
        //if the name has a prefix, fill it with the prefix. Else fill it with null
        if (naam.length == 3) {
            statement.setString(3, naam[1]);
            statement.setString(4, naam[2]);
        } else {
            statement.setString(3, null);
            statement.setString(4, naam[1]);
        }

        //fill in the date
        statement.setString(5, reiziger.getGBdatum().toString());
        statement.execute();
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) throws SQLException {
        //loop through all the persons, using the findAll method
        for (Reiziger rz : findAll()) {
            //if ID is equal, update the person
            if (reiziger.getID() == rz.getID()) {
                //update all of its attributes, because you don't know which attribute has to be updated
                PreparedStatement statement = conn.prepareStatement("UPDATE REIZIGER SET VOORLETTERS = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ?, GEBORTEDATUM = TO_DATE(?, 'yyyy-MM-dd') WHERE REIZIGERID = ?");

                //fill in the user same way as with the save method
                statement.setString(1, String.valueOf(reiziger.getNaam().toUpperCase().charAt(0)));

                String[] naam = reiziger.getNaam().split(" ");
                if (naam.length == 3) {
                    statement.setString(2, naam[1]);
                    statement.setString(3, naam[2]);
                } else {
                    statement.setString(2, null);
                    statement.setString(3, naam[1]);
                }

                statement.setString(4, reiziger.getGBdatum().toString());
                statement.setString(5, String.valueOf(rz.getID()));
                statement.execute();
            }
        }
        return reiziger;
    }

    public boolean delete(Reiziger reiziger) throws SQLException {
        boolean deleted = false;
        //loop through all the persons using the findAll method
        for (Reiziger rz : findAll()) {
            if (rz.getID() == reiziger.getID()) {
                //if the right person is found, delete it using it's ID
                PreparedStatement stament = conn.prepareStatement("DELETE FROM REIZIGER WHERE REIZIGERID = ?");
                stament.setString(1, String.valueOf(reiziger.getID()));
                stament.execute();
            }
        }

        //validate if the persons still exists using findAll method and contains
        List<Reiziger> reizigers = findAll();
        if (!(reizigers.contains(reiziger))) {
            deleted = true;
        }
        return deleted;
    }
}
