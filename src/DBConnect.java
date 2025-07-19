import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// manage connection to the MySQL database
public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/invoices";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
