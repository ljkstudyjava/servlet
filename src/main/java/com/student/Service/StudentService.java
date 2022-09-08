package com.student.Service;

import com.student.Dao.CourseDao;
import com.student.Dao.StudentDao;
import com.student.Pojo.Course;
import com.student.Pojo.DoRegisterInfo;
import com.student.Pojo.Result;

import java.util.List;

public class StudentService {


    private final StudentDao studentDao = new StudentDao();

    private final CourseDao courseDao = new CourseDao();


    //查询我的选课信息
    public Result getMyCourse(int sno) {
        //根据学号去查询课程信息
        return studentDao.getMyCourse(sno);
    }


    //选课前查询所有可选选课程
    public List<Course> getAllCourse(int id) {


        //获取我选中课程的id
        List<Integer> idList = studentDao.getMyCourseId(id);

        if (idList.isEmpty()) {
            //没有选课返回所有课程
            return courseDao.getAllCourse();
        }
        //返回所有我未选中课程
        return courseDao.getAllCourseUnSelected(idList);

        //return courseDao.getAllCourse();
    }

    public Result selectCourse(int id, int tnoStr, int cnoStr) {


        return studentDao.selectCourse(id, tnoStr, cnoStr);
    }

    public Result selectUnQualified(int id) {

        return studentDao.selectUnQualified(id);
    }
}
