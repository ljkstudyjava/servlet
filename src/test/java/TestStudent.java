import com.student.Pojo.Result;
import com.student.Pojo.StudentInfoCourse;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.student.Pojo.Code.SUCCESS_CODE;
import static com.student.Pojo.Code.SUCCESS_MSG;

public class TestStudent {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement ps;

        ResultSet rs;


        conn = JdbcUtils.getConnection();

        List<StudentInfoCourse> list = new ArrayList<>();

        String sql = "SELECT course.cname,  course.cid,teacher.tname,grade.score \n" +
                "FROM course,grade,teacher \n" +
                "WHERE grade.cno=course.cid \n" +
                "AND course.tno=teacher.tno\n" +
                "AND grade.sno = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 220906);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentInfoCourse studentInfoCourse = new StudentInfoCourse();
                studentInfoCourse.setCname(rs.getString(1));
                studentInfoCourse.setCid(rs.getString(2));
                studentInfoCourse.setTname(rs.getString(3));
                studentInfoCourse.setScore(rs.getDouble(4));
                list.add(studentInfoCourse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.toString());
    }
}
