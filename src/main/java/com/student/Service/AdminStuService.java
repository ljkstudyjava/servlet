package com.student.Service;

import com.student.Dao.AdminStuDao;
import com.student.Pojo.Code;
import com.student.Pojo.Result;
import com.student.Pojo.Student;

import java.util.List;

public class AdminStuService {
    private AdminStuDao adminStuDao=new AdminStuDao();
    public List<Student> getStuList() {
        return adminStuDao.getStuList();
    }

    public int addStu(int sno, String sname, String gender, String address) {
        return adminStuDao.addStu(sno,sname,gender,address);
    }

    public Result deleteStu(int sno) {
        int row =adminStuDao.deleteStu(sno);
        if (row<=0){
            return new Result(Code.DB_ERROR_CODE,Code.DB_ERROR_MSG_INSERT);
        }
        return new Result(Code.SUCCESS_CODE,Code.SUCCESS_MSG);
    }

    public Student getStuInfo(int sno) {
        return adminStuDao.getStuInfo(sno);
    }

    public int updateStu(int sno, String sname, String gender, String address) {
        return adminStuDao.updateStu(sno,sname,gender,address);
    }
}
