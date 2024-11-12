package com.mayikt.Test;

import com.mayikt.Service.StudentService;
import com.mayikt.entity.StudentEntity;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
//        ArrayList<StudentEntity>studentEntities=studentService.allStudent();
//        for(StudentEntity stu:studentEntities){
//            System.out.println(stu);
//        }

//        StudentEntity studentEntity = studentService.getStudentById();
//        System.out.println(studentEntity);
        StudentEntity studentEntity= new StudentEntity(9L,"小孩",21,"湖北麻城");
          int result= studentService.InsertStudent(studentEntity);
          if(result>0){
              System.out.println("插入成功");
          }else{
              System.out.println("插入失败");

          }
//        updateTestStudent();

//        DeleteTestStudent();
//
//
//
//
//    }
//    public static void updateTestStudent(){
//        StudentService studentService = new StudentService();
//        Long studentId = 1L;
//        StudentEntity studentEntity = studentService.getStudentById(studentId);
//        if(studentEntity== null){
//            return;
//
//        }
//        studentEntity.setName("小余");
//        studentEntity.setAge(20);
//        studentEntity.setAddress("北京朝阳");
//       int result= studentService.UpdateStudent(studentEntity);
//       if(result==1){
//           System.out.println("更新成功");
//       }else{
//           System.out.println("更新失败");
//       }

//
//    }
//    public static void DeleteTestStudent(){
//        Long Id = 2L;
//        StudentService studentService = new StudentService();
//        StudentEntity student = studentService.getStudentById(2L);
//        if(student==null){
//            System.out.println("没有查询到该学生");
//            return;
//        }
//        int result= studentService.DeleteStudent(Id);
//        if(result>0){
//            System.out.println("删除成功");
//        }else{
//            System.out.println("删除失败");
//        }
//
//
//
    }

    }
