package dao;

import pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    void addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map<String,Object> map);
    List<Blog> queryBlogChoose(Map<String,Object> map);

}
