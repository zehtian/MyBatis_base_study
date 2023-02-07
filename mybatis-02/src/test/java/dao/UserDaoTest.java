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

        //1.获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.执行SQL
        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式二：selectXxx 不推荐使用
        // List<User> userList = sqlSession.selectList("dao.UserDao.getUserList");

        for (User user:userList){
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

}
