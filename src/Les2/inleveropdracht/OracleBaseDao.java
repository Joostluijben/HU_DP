package Les2.inleveropdracht;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    private static Connection conn;

    protected static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:OV@//localhost:1521/xe", "OV", "oracle");
        return conn;
    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }
}
