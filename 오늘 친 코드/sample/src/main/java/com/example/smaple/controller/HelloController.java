package com.example.smaple.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.bean.Member;
 
@Controller// restcontorller는 responsebody 생략 jsp리턴못함. controller는 jsp리턴
public class HelloController {
  
  @RequestMapping("/test4/{id}/{name}")
  public String test4(
      @PathVariable String id,
      @PathVariable String name,
      Model model) {
    model.addAttribute("id",id);//request.setAttribute(id,id)
    model.addAttribute("name",name);
    
    return "test4";
  }
  
  
  
  
  
  @RequestMapping("/test3")
  public String test3(Member member, Model model) {
    model.addAttribute("member",member);
    return "test3";
  }
  
  
  @RequestMapping("/test2")
  public String test2(
      @RequestParam String id, 
      @RequestParam String name, 
      Model model) {
    model.addAttribute("id",id);//request
    model.addAttribute("name",name);
    
    return "test2";
  }
  
  
  @RequestMapping("/test1")
  public String test1(HttpServletRequest request, Model model) {
    String id = request.getParameter("id");
    String name= request.getParameter("name");
    
    model.addAttribute("id",id);
    model.addAttribute("name",name);
    
    
    
    return "test1";
  }
  
  
@GetMapping
@ResponseBody//responsebody는 데이터 리턴
public String hello() {
 
return "Hello World!";
}
@GetMapping("/test")//uri 명령이 들어오면 익스큐트가 test메소드로 바뀌고
public String test() {
  return "test";//view페이지 test, 확장자가 jsp인 파일이 응답(application,properties에서 찻아서)
}


}