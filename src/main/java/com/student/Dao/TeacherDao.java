package com.student.Dao;

import com.student.Pojo.Menu;
import com.student.Pojo.Teacher;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    Connection conn;
    PreparedStatement ps;
    public List<Teacher> getAllTea() {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from teacher";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTno(rs.getInt(1));
                teacher.setTname(rs.getString(2));
                teacher.setGender(rs.getString(3));
                teacher.setPhone(rs.getInt(4));
                teacherList.add(teacher);
            }
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacherList;


    }
}
