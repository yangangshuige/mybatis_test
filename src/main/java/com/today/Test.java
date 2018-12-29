package com.today;

import com.today.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        deleteUser();
    }

    private static void getUser() {
        SqlSession session = getSession();
        User user = session.selectOne("findUserById", 10);
        System.out.println(user.toString());
        session.close();
    }

    private static void getUsers() {
        SqlSession session = getSession();
        List<User> users = session.selectList("findUserByName", "y");
        System.out.println(users.size());
        session.close();
    }

    private static void insertUser() {
        SqlSession session = getSession();
        User user = new User("曹操", "458741", "cc@163.com", "2018-12-30");
        int result = session.insert("insertUser", user);
        session.commit();
        System.out.println(user.getId());
        session.close();
    }

    private static void updateUser() {
        SqlSession session = getSession();
        User user = new User("香香", "856269", "xx@193.com", "2018-12-30");
        user.setId(11);
        int result = session.update("updateUser", user);
        session.commit();
        System.out.println(result);
        session.close();
    }
    private static void deleteUser() {
        SqlSession session = getSession();
        int result = session.delete("deleteUser", 9);
        session.commit();
        System.out.println(result);
        session.close();
    }

    private static SqlSession getSession() {
        String resource = "config/SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }
}
