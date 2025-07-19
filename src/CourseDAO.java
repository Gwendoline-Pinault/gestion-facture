import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void save(Course course) {
        String sql = "INSERT INTO courses (date, client, type, start_hour, end_hour, module, class_level, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getDate());
            stmt.setString(2, course.getClient());
            stmt.setString(3, course.getType());
            stmt.setString(4, course.getStartHour());
            stmt.setString(5, course.getEndHour());
            stmt.setString(6, course.getModule());
            stmt.setString(7, course.getClassLevel());
            stmt.setInt(8, course.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> findAll() {
        String sql = "SELECT * FROM courses";
        List<Course> courses = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setDate(rs.getString("date"));
                course.setClient(rs.getString("client"));
                course.setType(rs.getString("type"));
                course.setStartHour(rs.getString("start_hour"));
                course.setEndHour(rs.getString("end_hour"));
                course.setModule(rs.getString("module"));
                course.setClassLevel(rs.getString("class_level"));
                course.setUserId(rs.getInt("user_id"));
                courses.add(course);
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public Course findById(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setDate(rs.getString("date"));
                course.setClient(rs.getString("client"));
                course.setType(rs.getString("type"));
                course.setStartHour(rs.getString("start_hour"));
                course.setEndHour(rs.getString("end_hour"));
                course.setModule(rs.getString("module"));
                course.setClassLevel(rs.getString("class_level"));
                course.setUserId(rs.getInt("user_id"));
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
