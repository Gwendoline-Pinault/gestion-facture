import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // find a user by username
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}