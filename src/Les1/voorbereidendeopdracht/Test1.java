package Les1.voorbereidendeopdracht;

import java.sql.*;

public class Test1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "joost", "oracle");
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM MEDEWERKERS");
        ResultSetMetaData md = result.getMetaData();
        while (result.next()) {
            for (int i = 1; i < md.getColumnCount(); i++) {
                System.out.print(result.getString(i) + "\t");
            }
            System.out.println("\n");
        }
    }
}
