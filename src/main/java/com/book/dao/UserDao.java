package com.book.dao;

import com.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Cxb
 * @Date 2021-09-06 13:52
 */
public interface UserDao extends JpaRepository<User,Integer> {

    //查找根据用户名密码  login查找

    public User findByNameAndPasswd(String name,String passwd);

}
