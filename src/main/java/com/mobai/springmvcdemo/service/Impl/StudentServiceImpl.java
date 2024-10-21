package com.mobai.springmvcdemo.service.Impl;

import com.mobai.springmvcdemo.entity.Student;
import com.mobai.springmvcdemo.mapper.HelloMapper;
import com.mobai.springmvcdemo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class StudentServiceImpl implements StudentService {

  @Autowired
  HelloMapper helloMapper;

  @Override
  public Student getStudentById(int sid) {
    System.out.println("here is student impl");
    Student student = helloMapper.getStudentById(sid);
    System.out.println(student);
    System.out.println("here after show student");
    return student;
  }
}
