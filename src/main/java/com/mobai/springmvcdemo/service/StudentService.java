package com.mobai.springmvcdemo.service;

import com.mobai.springmvcdemo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
  Student getStudentById(int sid);
}
