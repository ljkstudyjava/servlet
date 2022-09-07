package com.student.Dao;

import com.student.Pojo.User;
import com.student.utils.JdbcUtils;

import java.sql.*;

public class UserDao {
    Connection conn;
    PreparedStatement ps;

    public User getByName(String userName) {
        User user = new User();

        conn = JdbcUtils.getConnection();
        String sql = "select * from  user where username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleId(rs.getInt(4));


            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }
}
