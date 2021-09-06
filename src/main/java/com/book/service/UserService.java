package com.book.service;

import com.book.dao.UserDao;
import com.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Cxb
 * @Date 2021-09-06 13:56
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //login方法  根据user对象的 getname，getpasswd find查询，return user1
    public User login(User user){
        User user1 = userDao.findByNameAndPasswd(user.getName(),user.getPasswd());
        return user1;
    }



}
