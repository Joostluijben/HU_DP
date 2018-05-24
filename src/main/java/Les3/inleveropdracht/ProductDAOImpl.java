/*
1718331
Joost Luijben
Les3.inleveropdracht
*/

package Les3.inleveropdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAOImpl extends OracleBaseDao implements ProductDAO {
    private Connection conn = getConnection();

    public ProductDAOImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public ArrayList<Product> findAll() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM PRODUCT");
        ArrayList<Product> producten = new ArrayList<>();
        while (result.next()) {
            int productnummer = Integer.parseInt(result.getString(1));
            String productnaam = result.getString(2);
            String beschrijving = result.getString(3);
            double prijs = Double.parseDouble(result.getString(4));
            Product product = new Product(productnummer, productnaam, beschrijving, prijs);
            producten.add(product);
        }
        return producten;
    }

    @Override
    public List<OVchipkaart> findOVByProduct(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM OV_CHIPKAART, OV_CHIPKAART_PRODUCT WHERE PRODUCTNUMMER = ? AND OV_CHIPKAART.KAARTNUMMER = OV_CHIPKAART_PRODUCT.KAARTNUMMER");
        statement.setString(1, String.valueOf(product.getProductNummer()));
        ResultSet result = statement.executeQuery();
        List<OVchipkaart> OVs = new ArrayList<>();
        while (result.next()) {
            int kaartnummer = Integer.parseInt(result.getString(1));
            Date geldigTot = result.getTimestamp(2);
            int klasse = Integer.parseInt(result.getString(3));
            double saldo = Double.parseDouble(result.getString(4));
            int reizigerID = Integer.parseInt(result.getString(5));
            OVchipkaart OV = new OVchipkaart(kaartnummer, geldigTot, klasse, saldo, reizigerID);
            OVs.add(OV);
        }
        product.setOVs(OVs);

        ArrayList<OVchipkaart> Ovs = new ArrayList<>();
        OVchipkaartDAOImpl ovi = new OVchipkaartDAOImpl();
        for (OVchipkaart ov : ovi.findall()) {
            for (Product product1 : ovi.findProductenByOV(ov)) {
                if (product1.getProductNummer() == product.getProductNummer()) {
                    ArrayList<Product> products = new ArrayList<>();
                    products.add(product);
                    ov.setProducten(products);
                    Ovs.add(ov);
                }
            }
        }

        return Ovs;
    }
}
