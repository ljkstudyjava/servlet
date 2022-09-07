package com.student.Service;

import com.student.Dao.CourseDao;
import com.student.Pojo.Course;

import java.util.List;

public class CourseService {
    private CourseDao courseDao = new CourseDao();
    public List<Course> getAllByTno(String userName) {
        return courseDao.getAllByTno(userName);
    }
}
