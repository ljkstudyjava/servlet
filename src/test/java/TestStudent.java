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

        List<Integer> list = new ArrayList<>();

        String sql = "SELECT course.cid \n" +
                "FROM course,grade,teacher \n" +
                "WHERE grade.cno=course.cid \n" +
                "AND course.tno=teacher.tno\n" +
                "AND grade.sno = 2209011";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //String idList = String.valueOf(list);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
        String ss = "select * from course where cid not in (?";

        for (int i = 1; i < 2; i++) {
            ss += ",?";
        }
        ss += ")";

        System.out.println(ss);
    }
}
