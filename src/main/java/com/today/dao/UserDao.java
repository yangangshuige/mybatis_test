package com.today.dao;

import com.today.po.User;
/**
 * 原始Dao开发方法
 */
public interface UserDao {
    public User findUserById(int id) throws  Exception;
    public void insertUser(User user) throws  Exception;
    public void deleteUser(int id) throws  Exception;
    public void updateUser(User user) throws  Exception;
}
