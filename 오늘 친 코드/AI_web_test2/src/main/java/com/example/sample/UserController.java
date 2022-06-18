package com.example.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

  @Autowired
  @Qualifier("com.example.sample.UserServiceImpl")
  private UserService service;
  private static final Logger log = LoggerFactory.getLogger(UserController.class);



  @RequestMapping(value="/")
  public int loginCheck(@RequestParam("id") String id, @RequestParam("pw") String pw ) {
    log.info("userIdCheck 진입");
    log.info("전달받은 id:"+id);
    log.info("전달받은 pw:"+pw);
    int cnt = service.loginCheck(id,pw);
   
    log.info("확인 결과:"+cnt);
    
    
    
    return cnt;
  }
}
  

 
  
  

