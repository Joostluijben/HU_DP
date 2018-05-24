package Les1.inleveropodracht;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReizigerDAO {
    List<Reiziger> findAll() throws SQLException, ClassNotFoundException;

    List<Reiziger> findByGBdatum(String GBdatum) throws SQLException, ClassNotFoundException;

    Reiziger save(Reiziger reiziger) throws SQLException, ClassNotFoundException;

    Reiziger update(Reiziger reiziger) throws SQLException, ClassNotFoundException;

    boolean delete(Reiziger reiziger) throws SQLException, ClassNotFoundException;
}
