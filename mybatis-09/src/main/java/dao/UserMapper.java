package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;


public interface UserMapper {

    //根据id查询用户
    User getUserById(@Param("id") int id);
}
