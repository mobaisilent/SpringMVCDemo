package com.mobai.springmvcdemo.mapper;

import com.mobai.springmvcdemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface HelloMapper {
  @Select("select * from student where sid = #{sid}")
  public Student getStudentById(int sid);
}
// 注意这里要添加@Mapper注解，也就是注册到Spring容器中，这样Spring容器才能扫描到这个接口，从而生成代理对象，这样我们才能使用这个接口。