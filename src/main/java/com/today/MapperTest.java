package com.today;

import com.today.po.User;
import com.today.mapper.UserMapper;
import com.today.po.UserCustom;
import com.today.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
//        getUsers();
//        findUsers();
//        findUserCount();
//        findUserByResultMap();
        findUserCount2();
    }

    private static void getUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user =userMapper.findUserById(10);
        System.out.println(user.toString());
        session.close();
    }
    private static void findUserByResultMap() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user =userMapper.findUserByResultMap(10);
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
    private static void findUsers() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setId(10);
        userCustom.setUsername("小");
        userQueryVo.setUserCustom((userCustom));
        UserCustom result= userMapper.findUsers(userQueryVo);
        System.out.println(result.toString());
        session.commit();
        session.close();
    }
    private static void findUserCount() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setId(10);
        userCustom.setUsername("小");
        userQueryVo.setUserCustom((userCustom));
        int result= userMapper.findUsersCount(userQueryVo);
        System.out.println(result);
        session.commit();
        session.close();
    }
    private static void findUserList() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setUsername("小");
        userCustom.setId(10);
        userCustom.setSex(1);
        userQueryVo.setUserCustom((userCustom));
        List<Integer>ids=new ArrayList<Integer>();
        ids.add(10);
        ids.add(11);
        ids.add(12);
        userQueryVo.setIds(ids);
        List<User>user= userMapper.findUsersList(userQueryVo);
        System.out.println("user.size="+user.size());
        session.commit();
        session.close();
    }
    private static void findUserCount2() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setUsername("小");
        userCustom.setId(10);
        userCustom.setSex(1);
        userQueryVo.setUserCustom((userCustom));
        List<Integer>ids=new ArrayList<Integer>();
        ids.add(10);
        ids.add(11);
        ids.add(12);
        userQueryVo.setIds(ids);
        int result= userMapper.findUsersCount2(userQueryVo);
        System.out.println("result="+result);
        session.commit();
        session.close();
    }
}
