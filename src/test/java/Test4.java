import com.student.Pojo.TeacherInfoGrade;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement ps;

            List<TeacherInfoGrade> GradeTeacherList = new ArrayList<>();
            conn = JdbcUtils.getConnection();
            String sql = "SELECT grade.sno,stu.sname,grade.cno,grade.score FROM grade INNER JOIN stu ON grade.sno=stu.sno WHERE grade.tno = ?";
            try {
                ps = conn.prepareStatement(sql);
                int tno = Integer.parseInt("220905");
                ps.setInt(1, tno);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    TeacherInfoGrade teacherInfoGrade =new TeacherInfoGrade();
                    teacherInfoGrade.setSno(rs.getInt(1));
                    teacherInfoGrade.setSname(rs.getString(2));
                    teacherInfoGrade.setCno(rs.getInt(3));
                    teacherInfoGrade.setScore(rs.getDouble(4));
                    GradeTeacherList.add(teacherInfoGrade);
                }
                JdbcUtils.close(ps, conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            System.out.println(GradeTeacherList);

    }
}
