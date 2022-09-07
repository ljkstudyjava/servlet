package com.student.Dao;

import com.student.Pojo.DoRegisterInfo;
import com.student.Pojo.Result;
import com.student.Pojo.StudentInfoCourse;
import com.student.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.student.Pojo.Code.*;

public class StudentDao {

    Connection conn;
    PreparedStatement ps;

    ResultSet rs;

    public Result getMyCourse(int sno) {

        conn = JdbcUtils.getConnection();

        List<StudentInfoCourse> list = new ArrayList<>();

        String sql = "SELECT course.cname,  course.cid,teacher.tname,grade.score \n" +
                "FROM course,grade,teacher \n" +
                "WHERE grade.cno=course.cid \n" +
                "AND course.tno=teacher.tno\n" +
                "AND grade.sno = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sno);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentInfoCourse studentInfoCourse = new StudentInfoCourse();
                studentInfoCourse.setCname(rs.getString(1));
                studentInfoCourse.setCid(rs.getString(2));
                studentInfoCourse.setTname(rs.getString(3));
                studentInfoCourse.setScore(rs.getDouble(4));
                list.add(studentInfoCourse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Result(SUCCESS_CODE, SUCCESS_MSG, list);
    }

    public Result selectCourse(int id, int tnoStr, int cnoStr) {

        conn = JdbcUtils.getConnection();
        String sql = "insert into grade  (sno,tno,cno) values (?,?,?)";
        int row;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, tnoStr);
            ps.setInt(3, cnoStr);
            row = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (row <= 0) {
            return new Result(DB_ERROR_CODE, DB_ERROR_MSG_INSERT);
        }
        return new Result(SUCCESS_CODE, SUCCESS_MSG);
    }

    //获取已选课程的id
    public List<Integer> getMyCourseId(int sno) {

        conn = JdbcUtils.getConnection();

        List<Integer> list = new ArrayList<>();

        String sql = "SELECT course.cid \n" +
                "FROM course,grade,teacher \n" +
                "WHERE grade.cno=course.cid \n" +
                "AND course.tno=teacher.tno\n" +
                "AND grade.sno = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sno);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public void doInsertStudent(DoRegisterInfo doRegisterInfo) {
        conn = JdbcUtils.getConnection();
        String sql = "insert into stu (sno, sname, gender, address) values (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,doRegisterInfo.getSno());
            ps.setString(2,doRegisterInfo.getSname());
            ps.setString(3,doRegisterInfo.getSex());
            ps.setString(3,doRegisterInfo.getAddress());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
