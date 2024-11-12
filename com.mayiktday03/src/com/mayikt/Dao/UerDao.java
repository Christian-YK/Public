package com.mayikt.Dao;
import com.mysql.jdbc.Driver;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.MayiktJdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UerDao {

    /**
     * 用户注册
     */
    public int register(UserEntity userEntity) {
        Connection connetion = null;
        Statement statement = null;
        try {
            connetion = MayiktJdbcUtils.getConnection();
            statement = connetion.createStatement();
            String InsertUsersql = "insert into mayikt_user(name,pwd) values('" + userEntity.getName() + "','" + userEntity.getPwd() + "')";
            System.out.println("registerSql:" + InsertUsersql);
            int result = statement.executeUpdate(InsertUsersql);

          return result;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            MayiktJdbcUtils.CloseConnection(null, statement, connetion);
        }
        return 0;
    }

    /**
     * 根据用户名查找用户信息
     *
     * @param userName
     * @return
     */
    public UserEntity getByName(String userName) {

        /**
         * 根据用户名查找用户信息
         */
        if (userName == null || userName.length() == 0) {
            return null;
        }
        Connection connetion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connetion = MayiktJdbcUtils.getConnection();
            statement = connetion.createStatement();
            resultSet = statement.executeQuery("select * from mayikt_user where name='" + userName + "'");

            boolean result = resultSet.next();
            if (!result) {
                return null;
            }
            Long id = resultSet.getLong("id");
            String Dbname = resultSet.getString("name");
            String Dbpwd = resultSet.getString("pwd");
             return   new UserEntity(id, Dbname, Dbpwd);



        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }finally {
            MayiktJdbcUtils.CloseConnection(null, statement, connetion);
        }


    }
     public UserEntity login(UserEntity user){

         Connection connetion = null;
         Statement statement = null;
         ResultSet resultSet = null;

         try {
             connetion = MayiktJdbcUtils.getConnection();
             statement = connetion.createStatement();
             resultSet = statement.executeQuery("select * from mayikt_user where name='" + user.getName() + "'and pwd='" + user.getPwd() + "'");

             boolean result = resultSet.next();
             if (!result) {
                 return null;
             }
             Long id = resultSet.getLong("id");
             String Dbname = resultSet.getString("name");
             String Dbpwd = resultSet.getString("pwd");
             return new UserEntity(id, Dbname, Dbpwd);



         } catch (Exception e) {
             e.printStackTrace();
             return null;

         }finally {
             MayiktJdbcUtils.CloseConnection(null, statement, connetion);
         }

    }
}



