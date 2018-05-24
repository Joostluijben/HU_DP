/*
1718331
Joost Luijben
Les3.lesopdracht
*/

package Les3.lesopdracht;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OVchipkaartDAOImpl ovi = new OVchipkaartDAOImpl();
        OVchipkaart ov = new OVchipkaart(35283);
        System.out.println(ovi.findProductenByOV(ov));

        ProductDAOImpl pdi = new ProductDAOImpl();
        Product product = new Product(2);
        System.out.println(pdi.findOVByProduct(product));
    }
}
