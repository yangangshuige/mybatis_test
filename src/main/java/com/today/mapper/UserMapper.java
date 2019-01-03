package com.today.mapper;

import com.today.po.User;
import com.today.po.UserCustom;
import com.today.po.UserQueryVo;

import java.util.List;

/**
 * mapper代理开发方法
 */
public interface UserMapper {
    public User findUserById(int id) throws  Exception;
    public User findUserByResultMap(int id) throws  Exception;
    public List<User> findUserByName(String name) throws  Exception;
    public void insertUser(User user) throws  Exception;
    public void deleteUser(int id) throws  Exception;
    public void updateUser(User user) throws  Exception;
    public UserCustom findUsers(UserQueryVo userQueryVo) throws  Exception;
    public int findUsersCount(UserQueryVo userQueryVo) throws  Exception;
    public int findUsersCount2(UserQueryVo userQueryVo) throws  Exception;
    public  List<User> findUsersList(UserQueryVo userQueryVo) throws  Exception;
}
