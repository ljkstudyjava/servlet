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

//    根据tno删除
    public int deleteTea(int tno) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from teacher where tno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            row = ps.executeUpdate();
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

//    根据tno获取
    public Teacher getTeaByTno(int tno) {
        Teacher teacher = new Teacher();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from teacher where tno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                teacher.setTno(rs.getInt(1));
                teacher.setTname(rs.getString(2));
                teacher.setGender(rs.getString(3));
                teacher.setPhone(rs.getInt(4));
            }
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacher;
    }

    public int updateTea(int tno, String tname, String gender, int phone) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update teacher set tname = ? ,gender = ? ,phone = ? where tno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,tname);
            ps.setString(2,gender);
            ps.setInt(3,phone);
            ps.setInt(4,tno);
            row = ps.executeUpdate();
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }
//  添加教师列表以及账号
    public int addTea(int tno, String tname, String gender, int phone,String password) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into teacher values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            ps.setString(2,tname);
            ps.setString(3,gender);
            ps.setInt(4,phone);
            row = ps.executeUpdate();
            if(row > 0){
                row = addTeaLogin(tno, password);
            }
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

//    添加教师登录账号
    public int addTeaLogin(int tno,String password) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user (username, password, role_id) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            ps.setString(2,password);
            ps.setInt(3,2);
            row = ps.executeUpdate();
            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }
}
