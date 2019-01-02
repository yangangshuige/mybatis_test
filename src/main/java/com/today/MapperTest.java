package com.today;

import com.today.bean.User;
import com.today.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MapperTest {
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
    public static void main(String[] args) throws Exception {
        init();
//        deleteUser();
//        insertUser();
//        getUser();
        getUsers();
    }

    private static void getUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user =userMapper.findUserById(10);
        System.out.println(user.toString());
        session.close();
    }

    private static void getUsers() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> users =userMapper.findUserByName("小");
        System.out.println(users.size());
        session.close();
    }

    private static void insertUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User("小鸟", "6325411", "xn@163.com", "2019-01-02");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        session.commit();
        System.out.println(user.getId());
        session.close();
    }

    private static void updateUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User("小香", "856269", "xx@193.com", "2019-01-02");
        user.setId(11);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }
    private static void deleteUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        userMapper.deleteUser(7);
        session.commit();
        session.close();
    }
}
