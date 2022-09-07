package com.student.Dao;

import com.student.Pojo.Course;
import com.student.Pojo.User;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    Connection conn;
    PreparedStatement ps;
    public List<Course> getAllByTno(String userName) {
        List<Course> courseList = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        String sql = "select * from  course where tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            int tno = Integer.parseInt(userName);
            ps.setInt(1, tno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course =new Course();
                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTno(rs.getInt(3));
                courseList.add(course);
            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }
}
