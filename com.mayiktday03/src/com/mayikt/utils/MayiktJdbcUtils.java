package com.mayikt.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MayiktJdbcUtils {
    /**
     * 需要将我们的构造方法私有化
     */
    private MayiktJdbcUtils() {

    }
        /**
         * 定义我们工具类需要 声明 变量
         */
        private static String driverClass;
        private static String url;
        private static String user;
        private static String password;
        /**
         * 需要使用到静态代码块给声明好的jdbc变量赋值（读取config.properties）
         */
        static {
            try {
                //1.读取到配置文件 相对路径
                InputStream resourceAsStream = MayiktJdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");

                //2.赋值给声明好的变量
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                driverClass = properties.getProperty("driverClass");
                url = properties.getProperty("url");
                user = properties.getProperty("user");
                password = properties.getProperty("password");

                //3.加载驱动
                Class.forName(driverClass);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    /*
    封装连接方法
     */
      public static Connection getConnection() {
       try {
           Connection connection = DriverManager.getConnection(url, user, password);
           return connection;


       }catch (Exception e){
            e.printStackTrace();
            return null;
       }

    }
    /*
    封装释放方法
     */
    public static void CloseConnection(ResultSet resultSet, Statement statement, Connection connection) {

        //1. 查询 释放连接 statement resultSet connection
        try{
            if(resultSet!=null)
                resultSet.close();
            if (statement!=null)
                statement.close();
            if (connection!=null)
                connection.close();

        }catch (Exception e){
            e.printStackTrace();

        }
        //2. 增删改 释放连接 statement connection
    }
    public static void CloseConnection( Statement statement, Connection connection){
            CloseConnection(null, statement, connection);

    }

   public static void main(String[] args) {
     System.out.println(driverClass);
   }

}

