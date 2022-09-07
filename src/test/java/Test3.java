import com.student.Pojo.Course;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement ps;

            List<Course> courseList = new ArrayList<>();
            conn = JdbcUtils.getConnection();
            String sql = "select * from  course where tno = ?";
            try {
                ps = conn.prepareStatement(sql);
                int tno = Integer.parseInt("220905");
                System.out.println(tno);
                ps.setInt(1, tno);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Course course =new Course();
                    course.setCid(rs.getInt(1));
                    course.setCname(rs.getString(2));
                    course.setTno(rs.getInt(3));
                    courseList.add(course);
                }
                JdbcUtils.close(ps, conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        System.out.println(courseList);



    }
}
