package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    @Test
    public void getUserListTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user:userList){
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserListById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void insertUserTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.insertUser(new User(6, "hello", "666666"));

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(1, "123", "100000"));
        sqlSession.close();

    }

}
