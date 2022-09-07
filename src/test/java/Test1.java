import com.student.Pojo.User;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConnection();
        User user = new User();
        String sql = "select * from user where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
            }
            JdbcUtils.close(rs,ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(user.toString());


    }
}
