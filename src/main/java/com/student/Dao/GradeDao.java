package com.student.Dao;

import com.student.Pojo.Course;
import com.student.Pojo.TeacherInfoGrade;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao {
    Connection conn;
    PreparedStatement ps;
    public List<TeacherInfoGrade> getAllByTno(String userName) {
        List<TeacherInfoGrade> GradeTeacherList = new ArrayList<>();
        conn = JdbcUtils.getConnection();
        String sql = "SELECT grade.sno,stu.sname,grade.cno,grade.score FROM grade INNER JOIN stu ON grade.sno=stu.sno WHERE grade.tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            int tno = Integer.parseInt(userName);
            ps.setInt(1, tno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TeacherInfoGrade teacherInfoGrade =new TeacherInfoGrade();
                teacherInfoGrade.setSno(rs.getInt(1));
                teacherInfoGrade.setSname(rs.getString(2));
                teacherInfoGrade.setCno(rs.getInt(3));
                teacherInfoGrade.setScore(rs.getDouble(4));
                GradeTeacherList.add(teacherInfoGrade);
            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return GradeTeacherList;
    }

    public TeacherInfoGrade getBySnoAndCno(int sno, int cno) {
        TeacherInfoGrade teacherInfoGrade =new TeacherInfoGrade();
        conn = JdbcUtils.getConnection();
        String sql = "SELECT grade.sno,stu.sname,grade.cno,grade.score FROM grade INNER JOIN stu ON grade.sno=stu.sno WHERE grade.sno = ? and grade.cno = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sno);
            ps.setInt(2,cno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                teacherInfoGrade.setSno(rs.getInt(1));
                teacherInfoGrade.setSname(rs.getString(2));
                teacherInfoGrade.setCno(rs.getInt(3));
                teacherInfoGrade.setScore(rs.getDouble(4));
            }
            JdbcUtils.close(ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherInfoGrade;
    }

    public int updateGrade(int sno, int cno, Double score) {
        int row =0;
        conn = JdbcUtils.getConnection();
        String sql = "update grade set score = ? where sno = ? and cno = ? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,score);
            ps.setInt(2,sno);
            ps.setInt(3,cno);
            row = ps.executeUpdate();
            JdbcUtils.close(ps, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
