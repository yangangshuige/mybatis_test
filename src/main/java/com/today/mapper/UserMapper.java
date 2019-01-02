package com.today.mapper;

import com.today.bean.User;

import java.util.List;

/**
 * mapper代理开发方法
 */
public interface UserMapper {
    public User findUserById(int id) throws  Exception;
    public List<User> findUserByName(String name) throws  Exception;
    public void insertUser(User user) throws  Exception;
    public void deleteUser(int id) throws  Exception;
    public void updateUser(User user) throws  Exception;
}
