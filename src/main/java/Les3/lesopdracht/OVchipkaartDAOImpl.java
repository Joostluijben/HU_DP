/*
1718331
Joost Luijben
Les3.lesopdracht
*/

package Les3.lesopdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVchipkaartDAOImpl extends OracleBaseDao implements OVchipkaartDAO {
    private Connection conn = getConnection();

    public OVchipkaartDAOImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<OVchipkaart> findAll() {
        return null;
    }

    @Override
    public List<Product> findProductenByOV(OVchipkaart ov) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PRODUCT, OV_CHIPKAART_PRODUCT WHERE KAARTNUMMER = ? AND PRODUCT.PRODUCTNUMMER = OV_CHIPKAART_PRODUCT.PRODUCTNUMMER");
        statement.setString(1, String.valueOf(ov.getKaartnummer()));
        ResultSet result = statement.executeQuery();
        ArrayList<Product> producten = new ArrayList<>();
        while (result.next()) {
            int productNummer = Integer.parseInt(result.getString(1));
            String productNaam = result.getString(2);
            String beschrijving = result.getString(3);
            double prijs = Double.parseDouble(result.getString(4));

            Product product = new Product(productNummer, productNaam, beschrijving, prijs);
            producten.add(product);
        }
        return producten;
    }
}
