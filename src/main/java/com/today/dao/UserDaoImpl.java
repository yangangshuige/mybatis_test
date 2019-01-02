package com.today.dao;

import com.today.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 原始Dao开发方法
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public User findUserById(int id) throws Exception {
        SqlSession session =sqlSessionFactory.openSession();
        User user = session.selectOne("test.findUserById", 10);
        System.out.println(user.toString());
        session.close();
        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSession session =sqlSessionFactory.openSession();
        int result = session.insert("test.insertUser", user);
        session.commit();
        System.out.println(user.getId());
        session.close();
    }

    public void deleteUser(int id) throws Exception {
        SqlSession session =sqlSessionFactory.openSession();
        int result = session.delete("test.deleteUser", 9);
        session.commit();
        System.out.println(result);
        session.close();
    }

    public void updateUser(User user) throws Exception {
        SqlSession session =sqlSessionFactory.openSession();
        int result = session.update("test.updateUser", user);
        session.commit();
        System.out.println(result);
        session.close();
    }
}
