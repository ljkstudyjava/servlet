package com.student.Service;

import com.student.Dao.Course2Dao;
import com.student.Pojo.Code;
import com.student.Pojo.Course;
import com.student.Pojo.Result;

import java.util.List;

public class Course2Service {
    private Course2Dao course2Dao=new Course2Dao();
    public List<Course> getCourseList() {
        return course2Dao.getCourseList();
    }

    public Result deleteById(int cid) {
        int row=course2Dao.deleteById(cid);
        if (row<=0){
            return new Result(Code.DB_ERROR_CODE,Code.DB_ERROR_MSG_INSERT);
        }
        return new Result(Code.SUCCESS_CODE,Code.SUCCESS_MSG);

    }

    public Course getUserInfoById(int cid) {
        return course2Dao.getUserInfoById(cid);
    }

    public int updateCourse(int cid, String cname, int tno) {
        return course2Dao.updateById(cid,cname,tno);
    }

    public int addCourse(int cid, String cname, int tno) {
        return course2Dao.addCourse(cid,cname,tno);
    }
}
