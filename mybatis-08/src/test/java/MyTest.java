import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDutils;
import utils.MybatisUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIFTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String,Object> hashMap = new HashMap<String,Object>();
        //通过不同的参数，实现不同的效果
//        hashMap.put("title", "Java");
        hashMap.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIF(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String,Object> hashMap = new HashMap<String,Object>();
        //通过不同的参数，实现不同的效果
        hashMap.put("title", "Java");
        hashMap.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogChoose(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

}
