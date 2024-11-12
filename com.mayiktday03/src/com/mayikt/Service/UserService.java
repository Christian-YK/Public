package com.mayikt.Service;

import com.mayikt.Dao.UerDao;
import com.mayikt.entity.UserEntity;

public class UserService
{
    private UerDao userDao = new UerDao();

    public int rigister(UserEntity userEntity){
        String name = userEntity.getName();
        UserEntity DbuserEntity= userDao.getByName(name);
        if(DbuserEntity!=null){
            System.out.println("该用户已注册");
            return 0;
        }else{
            //该用户未注册
            int result =userDao.register(userEntity);
            return 0;
        }




    }
    public UserEntity login(UserEntity user){
        return userDao.login(user);
    }
}
