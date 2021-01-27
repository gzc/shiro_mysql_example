package com.example.shiro_mysql.dao;

import com.example.shiro_mysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    public User findUserByUsername(String username);

}
