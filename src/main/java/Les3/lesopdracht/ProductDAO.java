/*
1718331
Joost Luijben
Les3.lesopdracht
*/

package Les3.lesopdracht;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    List<Product> findAll();

    List<OVchipkaart> findOVByProduct(Product product) throws SQLException;
}
