import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAO {
    public void save(Consultation consultation) {
        String sql = "INSERT INTO consultations (date, client, type, description, rate, user_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, consultation.getDate());
            stmt.setString(2, consultation.getClient());
            stmt.setString(3, consultation.getType());
            stmt.setString(4, consultation.getDescription());
            stmt.setInt(5, consultation.getRate());
            stmt.setInt(6, consultation.getUserId());

            System.out.println(consultation.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consultation> findAll(int userId) {
        String sql = "SELECT * FROM consultations WHERE user_id = ?";
        List<Consultation> consultations = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consultation consultation = new Consultation();
                consultation.setId(rs.getInt("id"));
                consultation.setDate(rs.getString("date"));
                consultation.setClient(rs.getString("client"));
                consultation.setType(rs.getString("type"));
                consultation.setDescription(rs.getString("description"));
                consultation.setRate(rs.getInt("rate"));
                consultation.setUserId(rs.getInt("user_id"));
                consultations.add(consultation);
            }
            return consultations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Consultation findById(int id) {
        String sql = "SELECT * FROM consultations WHERE id = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Consultation consultation = new Consultation();
                consultation.setId(rs.getInt("id"));
                consultation.setDate(rs.getString("date"));
                consultation.setClient(rs.getString("client"));
                consultation.setType(rs.getString("type"));
                consultation.setDescription(rs.getString("description"));
                consultation.setRate(rs.getInt("rate"));
                consultation.setUserId(rs.getInt("user_id"));
                return consultation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
