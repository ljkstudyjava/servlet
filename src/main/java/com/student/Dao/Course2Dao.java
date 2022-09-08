package com.student.Dao;

import com.student.Pojo.Course;
import com.student.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Course2Dao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Course> getCourseList() {

        List<Course> courseList = new ArrayList<Course>();


        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql = "select * from course ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));
                courseList.add(course);
            }

            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;


    }

    public int deleteById(int cid) {
        int row=0;

        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql = "delete from course where cid =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            row = ps.executeUpdate();

            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;

    }

    public Course getUserInfoById(int cid) {
        Course course=null;
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false","root","123456");
            conn = JdbcUtils.getConnection();
            String sql="select * from course where cid =?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,cid);
            rs = ps.executeQuery();
            if (rs.next()){
                course=new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));


            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;

    }

    public int updateById(int cid, String cname, int tno) {
        int row = 0;

        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dika?useSSL=false", "root", "123456");
            conn = JdbcUtils.getConnection();
            String sql = "update course set cname=?,tno=? where cid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setInt(2, tno);
            ps.setInt(3, cid);
            row = ps.executeUpdate();

            JdbcUtils.close(ps, conn);

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;


    }

    public int addCourse(int cid,String cname,int tno) {
        int row = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into course values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            ps.setString(2,cname);
            ps.setInt(3,tno);
            row = ps.executeUpdate();

            JdbcUtils.close(ps,conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }
}
