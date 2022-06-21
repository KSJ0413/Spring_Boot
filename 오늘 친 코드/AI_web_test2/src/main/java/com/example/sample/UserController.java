package com.example.sample;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class UserController {

  @Autowired
  @Qualifier("com.example.sample.UserServiceImpl")
  private UserService service;
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  



  @GetMapping("/")
  public String loginCheck() {
    

 
    return "test1";
  }
  @ResponseBody
  @GetMapping("/loginCheckk") 
  public String loginCheckk( 
      @RequestParam Map<String,String> map
  ) {
    
    System.out.println("Map:" + map.toString());
    int cnt = service.loginCheckk(map);
    if(cnt > 0) {
      
      ObjectMapper om = new ObjectMapper();
      String nameView = service.nameView(map);
      System.out.println("nameView:" + nameView);
      return nameView;
    }
    
    return "fail";
  }
}

  
  

