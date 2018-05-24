/*
1718331
Joost Luijben
Les2.inleveropdracht
*/

package Les3.inleveropdracht;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OVchipkaartDAO {
    List<OVchipkaart> findall() throws SQLException;

    ArrayList<Product> findProductenByOV(OVchipkaart ov) throws SQLException, ClassNotFoundException;

    Reiziger getReiziger(OVchipkaart ov) throws SQLException, ClassNotFoundException;
}
