package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
//此注解省略了get set等方法的实现
//@Data: 无参构造 get set toString equals hashcoode
//@AllArgsConstructor：生成有参构造器
//@NoArgsConstructor：无参构造器
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
