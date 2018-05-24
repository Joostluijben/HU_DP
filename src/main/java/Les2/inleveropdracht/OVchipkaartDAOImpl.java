/*
1718331
Joost Luijben
Les2.inleveropdracht
*/

package Les2.inleveropdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OVchipkaartDAOImpl extends OracleBaseDao implements OVchipkaartDAO {
    private Connection conn = getConnection();

    public OVchipkaartDAOImpl() throws SQLException, ClassNotFoundException {
    }

    public List<OVchipkaart> findall() throws SQLException {
        Statement statement = conn.createStatement();
        //get all the OV cards
        ResultSet result = statement.executeQuery("SELECT * FROM OV_CHIPKAART");
        List<OVchipkaart> OVs = new ArrayList<>();

        //fill in the constructor of the OV card and add to the list
        while (result.next()) {
            int kaartnummer = Integer.parseInt(result.getString(1));
            Date geldigTot = Date.valueOf(result.getString(2).split(" ")[0]);
            int klasse = Integer.parseInt(result.getString(3));
            double saldo = Double.parseDouble(result.getString(4));
            int reizigerID = Integer.parseInt(result.getString(5));

            OVchipkaart OV = new OVchipkaart(kaartnummer, geldigTot, klasse, saldo, reizigerID);
            OVs.add(OV);
        }
        return OVs;
    }

    public Reiziger getReiziger(OVchipkaart ov) throws SQLException, ClassNotFoundException {
        //loop through all of the OV cards, if the persons ID matches return person
        ReizigerDAOImpl rzi = new ReizigerDAOImpl();
        for (Reiziger rz : rzi.findAll()) {
            if (rz.getReizigersID() == ov.getReizigerID()) {
                return rz;
            }
        }
        return null;
    }

}
