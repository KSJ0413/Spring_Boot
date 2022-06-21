package com.example.sample;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("com.example.sample.UserServiceImpl")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper mapper;

 
  
//
//  @Override
//  public int loginCheckk(String id, String pw) {
//    // TODO Auto-generated method stub
//    return mapper.loginCheckk(id,pw);
//  }
//
//
//
//
//  @Override
//  public String nameView(String id, String pw) {
//    // TODO Auto-generated method stub
//    return mapper.nameView(id,pw);
//  }
//



  @Override
  public int loginCheckk(Map<String, String> map) {
    // TODO Auto-generated method stub
    return mapper.loginCheckk(map);
  }



  @Override
  public String nameView(Map<String, String> map) {
    // TODO Auto-generated method stub
    return mapper.nameView(map);
  }

 
  

 
  }






 
  


