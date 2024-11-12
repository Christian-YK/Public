package com.mayikt.Service;

import com.mayikt.Dao.StudentDao;
import com.mayikt.entity.StudentEntity;

import java.util.ArrayList;

public class StudentService {
    /**
     * new出学生对象Dao层
     */
    private StudentDao studentDao = new StudentDao();

    /**
     * 查询所有学生信息
     * @return
     */

    public ArrayList<StudentEntity> allStudent() {
        ArrayList<StudentEntity>studentEntitites=studentDao.allstudent();
        return studentEntitites;

    }
    public StudentEntity getStudentById(Long StuId) {

        StudentEntity studentEntity=studentDao.getStudentById(StuId);
        return studentEntity;
    }
    public int InsertStudent(StudentEntity stu) {
        return studentDao.InsertStudent(stu);
    }

    public int UpdateStudent(StudentEntity stu) {

    return studentDao.UpdateStudent(stu);
    }
    public int DeleteStudent(Long Id) {
        return studentDao.DeleteStudent(Id);

    }
}


