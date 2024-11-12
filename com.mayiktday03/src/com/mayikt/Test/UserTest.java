package com.mayikt.Test;

import com.mayikt.Service.UserService;
import com.mayikt.entity.UserEntity;

import java.util.Scanner;

public class UserTest {
    private  UserService userService=new UserService();

    public static void main(String[] args) {
        UserTest test=new UserTest();
        test.index();
    }
      public  void   index(){

          Scanner scanner = new Scanner(System.in);
          System.out.println("请输入数字1:用户注册");
          System.out.println("请输入数字2:用户登录");
          int number= scanner.nextInt();
          switch (number){
              case 1:registerUser();
              break;
              case 2:login();
              break;


          }

    }

    public  void registerUser(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name=scanner.nextLine();
        System.out.println("请输入密码:");
        String pwd=scanner.nextLine();
         int result=userService.rigister(new UserEntity(name,pwd));
         if(result>0){
             System.out.println("注册成功");
             return;
         }else{
             System.out.println("注册失败");
         }
    }

    public  void login() {
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();
            System.out.println("请输入密码:");
            String pwd = scanner.nextLine();
            UserEntity DbuserEntity = userService.login(new UserEntity(username, pwd));
            if (DbuserEntity != null) {
                System.out.println("登录成功");
                return;
            } else {
                System.out.println("登录失败,输入的密码或用户名错误"+"还有"+(2-i)+"次机会");
            }
        }
    }
}