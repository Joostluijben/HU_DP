/*
1718331
Joost Luijben
Les2.inleveropdracht
*/

package Les3.inleveropdracht;

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

    @Override
    public ArrayList<Product> findProductenByOV(OVchipkaart ov) throws SQLException, ClassNotFoundException {
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
        ov.setProducten(producten);

       /* ArrayList<Product> products = new ArrayList<>();
        ProductDAOImpl pdi = new ProductDAOImpl();
        for (Product product : pdi.findAll()) {
            for (OVchipkaart ov1 : pdi.findOVByProduct(product)) {
                if (ov1.getKaartnummer() == ov.getKaartnummer()) {
                    ArrayList<OVchipkaart> ovs = new ArrayList<>();
                    ovs.add(ov);
                    product.setOVs(ovs);
                    products.add(product);
                }
            }
        }*/
        return producten;
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
