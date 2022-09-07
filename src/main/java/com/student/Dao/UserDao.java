package com.student.Dao;

import com.student.Pojo.DoRegisterInfo;
import com.student.Pojo.Result;
import com.student.Pojo.User;
import com.student.utils.JdbcUtils;

import java.sql.*;

import static com.student.Pojo.Code.*;

public class UserDao {
    Connection conn;
    PreparedStatement ps;

    ResultSet rs;

    public User getByName(String userName) {
        User user = new User();

        conn = JdbcUtils.getConnection();
        String sql = "select * from  user where username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
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

    //注册用户
    public Result doRegister(DoRegisterInfo doRegisterInfo) {
        conn = JdbcUtils.getConnection();
        int row;
        String sql = "insert into user ( username, password, role_id) values (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,doRegisterInfo.getUserName());
            ps.setString(2,doRegisterInfo.getPassword());
            ps.setInt(3,3);
            row = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (row<=0){
            return new Result(DB_ERROR_CODE,DB_ERROR_MSG_INSERT);
        }
        return new Result(SUCCESS_CODE,SUCCESS_MSG);
    }

    //判断用户在数据库中是否存在
    public boolean getUserName(String userName) {
        String name = null;
        conn = JdbcUtils.getConnection();
        String sql = "select * from user where username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //如果等于空，返回真意味该用户不存在；
        return name == null;
    }
}
