/*
1718331
Joost Luijben
Les2.inleveropdracht
*/

package Les2.inleveropdracht;

import java.sql.SQLException;
import java.util.List;

public interface OVchipkaartDAO {
    List<OVchipkaart> findall() throws SQLException;

    Reiziger getReiziger(OVchipkaart ov) throws SQLException, ClassNotFoundException;
}
