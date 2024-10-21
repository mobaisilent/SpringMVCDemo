package com.mobai.springmvcdemo.service.Impl;

import com.mobai.springmvcdemo.entity.Student;
import com.mobai.springmvcdemo.mapper.HelloMapper;
import com.mobai.springmvcdemo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  HelloMapper helloMapper;

  @Override
  public Student getStudentById(int sid) {
    return helloMapper.getStudentById(sid);
  }
}
