/*
1718331
Joost Luijben
Les3.lesopdracht
*/

package Les3.lesopdracht;

import java.sql.SQLException;
import java.util.List;

public interface OVchipkaartDAO {
    List<OVchipkaart> findAll();

    List<Product> findProductenByOV(OVchipkaart ov) throws SQLException;
}
