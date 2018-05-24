/*
1718331
Joost Luijben
Les3.lesopdracht
*/

package Les3.lesopdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAOImpl extends OracleBaseDao implements ProductDAO {
    Connection conn = getConnection();

    public ProductDAOImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<OVchipkaart> findOVByProduct(Product product) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM OV_CHIPKAART, OV_CHIPKAART_PRODUCT WHERE PRODUCTNUMMER = ? AND OV_CHIPKAART.KAARTNUMMER = OV_CHIPKAART_PRODUCT.KAARTNUMMER");
        statement.setString(1, String.valueOf(product.getProductNummer()));
        ResultSet result = statement.executeQuery();
        ArrayList<OVchipkaart> OVs = new ArrayList<>();
        while (result.next()) {
            int kaartnummer = Integer.parseInt(result.getString(1));
            Date geldigTot = result.getTimestamp(2);
            int klasse = Integer.parseInt(result.getString(3));
            double saldo = Double.parseDouble(result.getString(4));
            int reizigerID = Integer.parseInt(result.getString(5));
            OVchipkaart OV = new OVchipkaart(kaartnummer, geldigTot, klasse, saldo, reizigerID);
            OVs.add(OV);
        }
        return OVs;
    }
}
