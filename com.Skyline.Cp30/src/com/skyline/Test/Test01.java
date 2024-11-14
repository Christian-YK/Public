package com.skyline.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.skylien.Entity.UserEntity;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Test01 {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        // 创建c3p0连接池
        ComboPooledDataSource pool = new ComboPooledDataSource();
        // 设置jdbc连接信息
        pool.setUser("root");//设置连接的用户名
        pool.setPassword("123.com");//设置连接的密码
        pool.setJdbcUrl("jdbc:mysql://localhost:3306/mayikt?serverTimezone=UTC");//设置连接的url
        pool.setDriverClass("com.mysql.cj.jdbc.Driver");//设置连接的驱动
        //获取连接者对象
        Connection connection = pool.getConnection();
        //获取预编译执行者对象 防止SQL注入

        PreparedStatement preparedStatement = connection.prepareStatement("select * from mayikt_user where id=?");
        //设置占位符的值
        preparedStatement.setInt(1, 1);
        //执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();
       if(!resultSet.next()) {
           return;
       }
       Long id = resultSet.getLong("id");
       String name = resultSet.getString("name");
       String pwd= resultSet.getString("pwd");
       UserEntity userEntity= new UserEntity(id,name,pwd);
       System.out.println(userEntity.toString());
       //关闭连接
       resultSet.close();
       preparedStatement.close();
       connection.close();
    }


}
