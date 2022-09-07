package com.student.Dao;

import com.student.Pojo.Menu;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {
    Connection conn;
    PreparedStatement ps;
    public List<Menu> getLeftList(int roleId) {
        List<Menu> menuList = new ArrayList<Menu>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select menu.* from menu INNER JOIN role_menu ON menu.id = role_menu.menu_id where role_menu.role_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,roleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Menu menu = new Menu();
                menu.setId(rs.getInt(1));
                menu.setName(rs.getString(2));
                menu.setUrl(rs.getString(3));
                menu.setPId(rs.getInt(4));
                menu.setTarget(rs.getString(5));
                menuList.add(menu);
            }
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return menuList;
    }
}
