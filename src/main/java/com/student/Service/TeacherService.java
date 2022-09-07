package com.student.Service;

import com.student.Dao.TeacherDao;
import com.student.Pojo.Teacher;

import java.util.List;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();
//    获取所有的教师信息
    public List<Teacher> getAllTea() {
        return teacherDao.getAllTea();
    }
}
