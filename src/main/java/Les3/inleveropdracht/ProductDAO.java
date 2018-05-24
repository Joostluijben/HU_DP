/*
1718331
Joost Luijben
Les3.inleveropdracht
*/

package Les3.inleveropdracht;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {
    ArrayList<Product> findAll() throws SQLException;
    List<OVchipkaart> findOVByProduct(Product product) throws SQLException, ClassNotFoundException;
}
