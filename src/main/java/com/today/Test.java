package com.today;

import com.today.po.User;
import com.today.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static SqlSessionFactory sqlSessionFactory;
    private static void init() {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static void main(String[] args) {
        init();
        try {
            getUserFromDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Dao原始开发方法
    private static void getUserFromDao() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.findUserById(10);
    }

    private static void getUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("test.findUserById", 10);
        System.out.println(user.toString());
        session.close();
    }

    private static void getUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        List<User> users = session.selectList("test.findUserByName", "y");
        System.out.println(users.size());
        session.close();
    }

    private static void insertUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User("张飞", "6325541", "cc@163.com", "2018-12-30");
        int result = session.insert("test.insertUser", user);
        session.commit();
        System.out.println(user.getId());
        session.close();
    }

    private static void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User("刘备", "856269", "xx@193.com", "2018-12-30");
        user.setId(11);
        int result = session.update("test.updateUser", user);
        session.commit();
        System.out.println(result);
        session.close();
    }

    private static void deleteUser() {
        SqlSession session = sqlSessionFactory.openSession();
        int result = session.delete("test.deleteUser", 9);
        session.commit();
        System.out.println(result);
        session.close();
    }

}
