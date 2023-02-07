package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

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

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> mapList = new HashMap<String, Integer>();
        mapList.put("startIndex", 2);
        mapList.put("pageSize", 2);
        List<User> userByLimit = mapper.getUserByLimit(mapList);

        for (User user : userByLimit) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void log4jTest(){
        //日志的不同级别，我们添加时一般用info，表示提示
        logger.info("info:进入了log4jTest");
        logger.debug("debug:进入了log4jTest");
        logger.error("error:进入了log4jTest");
    }

}
