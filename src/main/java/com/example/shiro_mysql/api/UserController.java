package com.example.shiro_mysql.api;


import com.example.shiro_mysql.dao.UserDao;
import com.example.shiro_mysql.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequiresPermissions("user:query")
    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    @PostMapping("/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            System.out.println("登录成功");
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

}
