package com.student.Dao;

import com.student.Pojo.Course;
import com.student.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    Connection conn;
    PreparedStatement ps;

    ResultSet rs;

    //展示所有课程
    public List<Course> getAllByTno(String userName) {
        List<Course> courseList = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        String sql = "select * from  course where tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            int tno = Integer.parseInt(userName);
            ps.setInt(1, tno);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));
                courseList.add(course);
            }
            JdbcUtils.close(rs, ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }

    public List<Course> getAllCourse() {

        List<Course> courseList = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        String sql = "select * from  course ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));
                courseList.add(course);
            }
            JdbcUtils.close(rs, ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;

    }

    //返回所有当前学生未选中的课程
    public List<Course> getAllCourseUnSelected(List<Integer> idList) {

        List<Course> courseList = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        StringBuilder sql = new StringBuilder("select * from course where cid not in (?");
        try {

            for (int i = 1; i < idList.size(); i++) {
                sql.append(",?");
            }
            sql.append(")");
            System.out.println(sql);
            System.out.println(idList);
            System.out.println(idList.size());
            System.out.println(idList.get(0));
            ps = conn.prepareStatement(sql.toString());
            for (int i = 0; i < idList.size(); i++) {
                ps.setInt((i + 1), idList.get(i));
                System.out.println(idList.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));
                courseList.add(course);
            }
            JdbcUtils.close(rs, ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }
}
