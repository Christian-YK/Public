package com.mayikt.Test;

import com.mayikt.Service.StudentService;
import com.mayikt.entity.StudentEntity;

import java.util.ArrayList;
import java.util.Scanner;

public class IndexTest {
    private static StudentService studentService = new StudentService();
    public static void main(String[] args) {

        mainMenu();



    }
    public static void mainMenu(){
        while(true){
            System.out.println("=======欢迎来到学生管理系统=====");
            System.out.println("---------1.查询所有学生信息-----");
            System.out.println("---------2.根据ID查询学生信息-------");
            System.out.println("---------3.新增学生信息-------");
            System.out.println("---------4.修改学生信息-------");
            System.out.println("---------5.删除学生信息-------");
            System.out.println("请输入你的选项:");
            Scanner scanner= new Scanner(System.in);
            int boutton= scanner.nextInt();

            switch (boutton){
                case 1:ShowAllStudent();
                    break;
                case 2:ShowStudentById();
                    break;
                    case 3:InsertStudentById();
                    break;
                    case 4:UpdateStudentById();
                    break;
                case 5:DeleteStudentById();
                break;

            }



        }

    }

public static void ShowStudentById() {
        System.out.println("根据ID查询学生信息:\n");
    System.out.println("请输入查询的学生ID:");
    Scanner scanner = new Scanner(System.in);
    Long stuId = scanner.nextLong();
    //根据用户输入的学生ID查
//         studentService= new StudentService();
        StudentEntity student=studentService.getStudentById(stuId);
        if(student==null){
            System.out.println("没有查询到该ID的学生"+stuId);
            return;
        }
        System.out.println("查询到的学生信如下:");
        System.out.println(student);







}

    /**
     * 定义主菜单程序入口
     */
    public static void ShowAllStudent(){
        System.out.println("查询到的所有学生信息:");
//         studentService= new StudentService();
        ArrayList< StudentEntity >studentEntities=studentService.allStudent();
        for(StudentEntity stu:studentEntities){
            System.out.println(stu);
        }

    }

    public static void DeleteStudentById() {
        System.out.println("根据ID删除学生信息:\n");
        System.out.println("请输入要删除的学生ID:");
        Scanner scanner = new Scanner(System.in);
        Long stuId = scanner.nextLong();
//        studentService= new StudentService();
         int result =studentService.DeleteStudent(stuId);
         if(result>0){
             System.out.println("删除学生信息成功!:"+"以删除ID为"+stuId+"的学生");
         }else{
             System.out.println("删除学生信息失败");
         }


    }
    public static void InsertStudentById() {
        System.out.println("新增学生信息:\n");
        System.out.println("请输入新增学生的ID:");
        Scanner scanner = new Scanner(System.in);
        Long stuId = scanner.nextLong();
        System.out.println("请输入新增学生的姓名:");
        Scanner scanner1 = new Scanner(System.in);
        String stuName = scanner1.next();
        System.out.println("请输入新增学生的年龄:");
        Scanner scanner2 = new Scanner(System.in);
        int stuAge = scanner2.nextInt();
        System.out.println("请输入新增学生的地址:");
        scanner2 = new Scanner(System.in);
        String stuAddress = scanner2.next();
        StudentEntity studentEntity = new StudentEntity(stuId,stuName,stuAge,stuAddress);
        int result =studentService.InsertStudent(studentEntity);
        if(result>0){
            System.out.println("新增学生信息成功!:"+studentEntity);
            ShowAllStudent();
        }else{
            System.out.println("新增学生信息失败");
        }


    }
    public static void UpdateStudentById() {
        /**
         * 先根据ID查询学生信息
         * 如果查询不到则结束
         * 如果查询到则修改学生信息
         */
        System.out.println("修改学生信息:\n");
        System.out.println("请输入修改学生的ID:");
        Scanner scanner = new Scanner(System.in);
        Long stuId = scanner.nextLong();
        //先根据学生ID查询学生信息
       StudentEntity student= studentService.getStudentById(stuId);
        if (student==null){
            System.out.println("没有查询到该ID的学生:"+stuId);
            return;
        }
        System.out.println("请输入修改学生的姓名:");
        Scanner scanner1 = new Scanner(System.in);
        String stuName = scanner1.next();
        System.out.println("请输入修改学生的年龄:");
        Scanner scanner2 = new Scanner(System.in);
        int stuAge = scanner2.nextInt();
        System.out.println("请输入修改学生的地址:");
        scanner2 = new Scanner(System.in);
        String stuAddress = scanner2.next();
        //将用户输入的学生信息封装成JAVA学生对象
        StudentEntity studentEntity = new StudentEntity(stuId,stuName,stuAge,stuAddress);
        int  result =studentService.UpdateStudent(studentEntity);
        if(result>0){
            System.out.println("修改学生信息成功!:"+studentEntity);
            ShowAllStudent();
        }else{
            System.out.println("修改学生信息失败");
        }





    }

}
