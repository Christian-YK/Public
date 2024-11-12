package com.mayikt.Dao;

import com.mayikt.entity.StudentEntity;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.MayiktJdbcUtils;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;


     public ArrayList<StudentEntity>allstudent()  {
         /**
          * JAVA连接数据库查询所有的学生数据
          */
        try{
            connection= MayiktJdbcUtils.getConnection();
             statement=connection.createStatement();
            //执行SQL语句
             resultSet=statement.executeQuery("select * from mayikt_student");
            //对结果进行处理
            ArrayList<StudentEntity>studentEntities=new ArrayList<>();

            while(resultSet.next()){//如果返回为false则结束循环
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                Integer age=resultSet.getInt("age");
                String address=resultSet.getString("address");

                // 将DB中查询到的数据封装成JAVA学生对象
               StudentEntity studentEntity= new StudentEntity(id,name,age,address);
               studentEntities.add(studentEntity);


            }
            return studentEntities;



        }catch (Exception e){


        }finally{
//            try{
//                if(resultSet!=null)
//                    resultSet.close();
//                if (statement!=null)
//                    statement.close();
//                if (connection!=null)
//                    connection.close();
//
//            }catch (Exception e){
//                e.printStackTrace();
//
//            }
            MayiktJdbcUtils.CloseConnection(resultSet,statement,connection);



        }

         /**
          *
          * 将查询到的数据存放在我们的ArrayList<StudentEntity>集合当中
          */
return null;

     }
     public  StudentEntity  getStudentById(Long StuId){

         /**
          * 根据ID查询学生信息
          */
         if(StuId==null)
         {
             return null;
         }
         try{
             //注册SQL驱动
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             //创建数据库连接
//             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mayikt?serverTimezone=UTC","root","123.com");
//             //获取执行者对象
             connection=MayiktJdbcUtils.getConnection();
             statement=connection.createStatement();
             //执行SQL语句
             resultSet=statement.executeQuery("select * from mayikt_student where id="+StuId);
             //对结果进行处理
            boolean result= resultSet.next();
            //判断如果取不到值返回false
            if(!result)
            {
                return null;
            }
             Long id=resultSet.getLong("id");
             String name=resultSet.getString("name");
             Integer age=resultSet.getInt("age");
             String address=resultSet.getString("address");


             //如果返回为false则结束循环

                 // 将DB中查询到的数据封装成JAVA学生对象
                 StudentEntity studentEntity= new StudentEntity(id,name,age,address);
                 return studentEntity;


         }catch (Exception e){
             e.printStackTrace();
             return null;

         }finally{
//             try{
//                 if(resultSet!=null)
//                     resultSet.close();
//                 if (statement!=null)
//                     statement.close();
//                 if (connection!=null)
//                     connection.close();
//
//             }catch (Exception e){
//                 e.printStackTrace();
//
//             }
             MayiktJdbcUtils.CloseConnection(resultSet,statement,connection);

         }


     }
     public int InsertStudent(StudentEntity stu){
         /**
          * 添加学生信息
          */
         try{
//             //注册SQL驱动
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             //创建数据库连接
//             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mayikt?serverTimezone=UTC","root","123.com");
//             //获取执行者对象
             connection=MayiktJdbcUtils.getConnection();
             statement=connection.createStatement();
             //执行SQL语句来添加学生信息
             String StudentSql="insert into mayikt_student values("+stu.getId()+",'"+stu.getName()+"',"+stu.getAge()+",'"+stu.getAddress()+"')\n";
             System.out.println("StudentSql:"+StudentSql);
             int result=statement.executeUpdate(StudentSql);
             return result;



             //如果返回为false则结束循环

             // 将DB中查询到的数据封装成JAVA学生对象



         }catch (Exception e){
             e.printStackTrace();
             return 0;


         }finally{
//             try{
//                 if (statement!=null)
//                     statement.close();
//                 if (connection!=null)
//                     connection.close();
//
//             }catch (Exception e){
//                 e.printStackTrace();
//
//             }
//

          MayiktJdbcUtils.CloseConnection(null,statement,connection);

         }


     }
     public int UpdateStudent(StudentEntity stu){

         /**
          * 更新学生信息
          */
         try{
//             //注册SQL驱动
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             //创建数据库连接
//             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mayikt?serverTimezone=UTC","root","123.com");
//             //获取执行者对象
             connection=MayiktJdbcUtils.getConnection();
             statement=connection.createStatement();
             //执行SQL语句来添加学生信息
             String UpdateSql="Update mayikt_student set name='"+stu.getName()+"',age="+stu.getAge()+",address='"+stu.getAddress()+"' where id="+stu.getId()+"";
             System.out.println("UpdateStudentSql:"+UpdateSql);
             int result=statement.executeUpdate(UpdateSql);
             return result;



             //如果返回为false则结束循环

             // 将DB中查询到的数据封装成JAVA学生对象



         }catch (Exception e){
             e.printStackTrace();
             return 0;


         }finally{
//             try{
//                 if (statement!=null)
//                     statement.close();
//                 if (connection!=null)
//                     connection.close();
//
//             }catch (Exception e){
//                 e.printStackTrace();
//
//             }
             MayiktJdbcUtils.CloseConnection(null,statement,connection);

         }



     }
    /**
     *根据主键ID删除学生信息
     *
     */
    public int DeleteStudent(Long id){
        if (id==null)
        {
            return 0;
        }
        try{
            //注册SQL驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //创建数据库连接
//            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mayikt?serverTimezone=UTC","root","123.com");
//            //获取执行者对象
            connection=MayiktJdbcUtils.getConnection();
            statement=connection.createStatement();
            //执行SQL语句来添加学生信息
            String DeleteSql="delete from mayikt_student where id="+id;
            System.out.println("DeleteStudentSql:"+DeleteSql);
            int result=statement.executeUpdate(DeleteSql);
            return result;
            //如果返回为false则结束循环

            // 将DB中查询到的数据封装成JAVA学生对象
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally{
//            try{
//                if (statement!=null)
//                    statement.close();
//                if (connection!=null)
//                    connection.close();
//
//            }catch (Exception e){
//                e.printStackTrace();
//
//            }
            MayiktJdbcUtils.CloseConnection(null,statement,connection);

        }



    }




}
