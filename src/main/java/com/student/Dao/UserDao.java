package com.student.Dao;

import com.student.Pojo.User;

import java.sql.*;

public class UserDao {
    Connection conn;
    PreparedStatement ps;

    public User getByName(String userName) {
        User user = new User();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cour", "root", "123456");
            String sql = "select * from  user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleId(rs.getInt(4));


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return user;
    }
}
