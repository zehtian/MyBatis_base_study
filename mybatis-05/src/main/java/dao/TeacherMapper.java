package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;

public interface TeacherMapper {

    //查询一个老师
    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);

}
