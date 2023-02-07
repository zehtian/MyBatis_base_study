import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import javax.sound.midi.Soundbank;

public class MyTest {

    //一级缓存测试
    @Test
    public void cache1Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.clearCache();  //手动清理缓存

        System.out.println("==============================");

        User userById2 = mapper.getUserById(1);
        System.out.println(userById2);

        System.out.println(userById==userById2);

        sqlSession.close();
    }

    //二级缓存测试
    @Test
    public void cache2Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();

        System.out.println("==============================");
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper2.getUserById(1);
        System.out.println(userById2);

        System.out.println(userById==userById2);

        sqlSession2.close();
    }



}
