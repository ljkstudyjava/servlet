package com.student.Dao;

import com.student.Pojo.Course;
import com.student.Pojo.Student;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminStuDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;


    public List<Student> getStuList() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql = "select * from stu ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setSno(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setGender(rs.getString(3));
                student.setAddress(rs.getString(4));
                studentList.add(student);
            }

            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    public int addStu(int sno, String sname, String gender, String address) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into stu values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sno);
            ps.setString(2,sname);
            ps.setString(3,gender);
            ps.setString(4,address);
            row = ps.executeUpdate();

            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    public int deleteStu(int sno) {
        int row=0;

        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql = "delete from stu where sno =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sno);
            row = ps.executeUpdate();

            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    public Student getStuInfo(int sno) {
        Student student=null;
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql="select * from stu where sno =?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,sno);
            rs = ps.executeQuery();
            if (rs.next()){
                student=new Student();
                student.setSno(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setGender(rs.getString(3));
                student.setAddress(rs.getString(4));

            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public int updateStu(int sno, String sname, String gender, String address) {
        int row = 0;

        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false", "root", "123456");
            conn = JdbcUtils.getConnection();
            String sql = "update stu set sname=?,gender=?,address=? where sno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, sname);
            ps.setString(2, gender);
            ps.setString(3,address);
            ps.setInt(4, sno);
            row = ps.executeUpdate();

            JdbcUtils.close(ps, conn);

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }
}
