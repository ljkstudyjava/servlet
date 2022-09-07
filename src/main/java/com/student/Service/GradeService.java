package com.student.Service;

import com.student.Dao.GradeDao;
import com.student.Pojo.TeacherInfoGrade;

import java.util.List;

public class GradeService {
    private GradeDao gradeDao =new GradeDao();
    public List<TeacherInfoGrade> getAllByTno(String userName) {
        return gradeDao.getAllByTno(userName);
    }

    public TeacherInfoGrade getBySnoAndCno(int sno, int cno) {
        return gradeDao.getBySnoAndCno(sno,cno);
    }

    public int updateGrade(int sno, int cno, Double score) {
        return gradeDao.updateGrade(sno,cno,score);
    }
}
