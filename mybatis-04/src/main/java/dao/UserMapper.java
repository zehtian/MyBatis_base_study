package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    @Select("select * from user")
    List<User> getUserList();

    //根据id查找用户
    //建议加上@Param注解，与sql语句#{}中的值对应
    //单个参数且为基本数据类型时可以省略，多个参数时需要加上
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    //添加一个用户
    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{pwd})")
    int insertUser(User user);

    //更新用户
    @Update("update user set pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

}
