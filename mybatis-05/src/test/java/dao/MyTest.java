package dao;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.MybatisUtils;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacherTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();

    }

    @Test
    public void getStudentTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent2();

        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();

    }

}
