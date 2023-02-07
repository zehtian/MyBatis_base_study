package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//获取sqlSessionFactory对象 -> 获取sqlSession实例
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory; //提升作用域，在方法下使用

    //一初始就加载了
    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //从SqlSessionFactory中获得SqlSession的实例。
    //SqlSession提供了在数据库执行SQL命令所需的所有方法
    public static SqlSession getSqlSession(){
        //设置为true，则不需要手动进行事务的提交
        return sqlSessionFactory.openSession(true);
    }
}
