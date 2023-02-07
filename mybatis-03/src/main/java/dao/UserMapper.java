package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //分页查询用户
    List<User> getUserByLimit(Map<String,Integer> map);


}
