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
//  删除教师信息
    public int deleteTea(int tno) {
        return teacherDao.deleteTea(tno);
    }
//回显数据用于修改
    public Teacher getTeaByTno(int tno) {
        return teacherDao.getTeaByTno(tno);
    }

    public int updateTea(int tno, String tname, String gender, int phone) {
        return teacherDao.updateTea(tno,tname,gender,phone);
    }

    public int addTea(int tno, String tname, String gender, int phone,String password) {
        return teacherDao.addTea(tno,tname,gender,phone,password);
    }
}
