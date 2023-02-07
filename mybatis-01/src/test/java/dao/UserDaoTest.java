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

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //查询id为1的用户
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    //增删改需要提交事务
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4, "哈哈", "123333"));
        if (res>0){
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        //此处的名称 userId和userName 要与配置文件中key的名称一致
        //设置插入内容
        map.put("userId", 5);
        map.put("userName", "小明");

        int res = mapper.addUser2(map);
        if (res>0){
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4, "呵呵", "123123"));
        if (res>0){
            System.out.println("更新成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(1);
        if (res>0){
            System.out.println("删除成功！");
        }

        sqlSession.commit();
        sqlSession.close();

    }


}
