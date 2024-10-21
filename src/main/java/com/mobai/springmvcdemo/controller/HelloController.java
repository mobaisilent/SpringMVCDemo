package com.mobai.springmvcdemo.controller;

import com.mobai.springmvcdemo.entity.Student;
import com.mobai.springmvcdemo.mapper.HelloMapper;
import com.mobai.springmvcdemo.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//  @Autowired
//  StudentServiceImpl studentService;

  @ResponseBody
  @RequestMapping(value = "/")
  public String index() {  //这里不仅仅可以是Model，还可以是Map、ModelMap
//    return studentService.getStudentById(1).toString();
    return
            "hello world";
  }
}