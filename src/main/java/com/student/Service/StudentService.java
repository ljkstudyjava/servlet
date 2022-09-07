package com.student.Service;

import com.student.Dao.StudentDao;
import com.student.Pojo.Result;

public class StudentService {


    private final StudentDao studentDao = new StudentDao();

    public Result getMyCourse(int sno) {
        //根据学号去查询课程信息
        return studentDao.getMyCourse(sno);
    }
}
