package com.book.controller;

import com.book.entity.User;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @Author Cxb
 * @Date 2021-09-06 14:03
 */
@Controller

public class UserController {
    @Autowired
    UserService userService;


    //访问/ 返回index
    @RequestMapping("/")
    public String index(@ModelAttribute  User user){
        return "index";
    }


    //访问index
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute  User user, HttpSession session, Model model){
        System.out.println(user.getName()+"----"+user.getPasswd());
        User loginUser = userService.login(user);
        if(loginUser == null){
            System.out.println("用户名或密码错误");
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }else {
            session.setAttribute("user",loginUser);
            return "redirect:/main";
        }


    }
}
