package com.mobai.springmvcdemo.controller;

import com.mobai.springmvcdemo.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @Autowired
  StudentServiceImpl service;

  @RequestMapping(value = "/")
  public String index(@RequestParam int sid, Model model) {
    model.addAttribute("student", service.getStudentById(sid));
    System.out.println("这里查看浏览器请求的sid信息" + sid);
    System.out.println(service.getStudentById(sid));
    return "index";
  }
}