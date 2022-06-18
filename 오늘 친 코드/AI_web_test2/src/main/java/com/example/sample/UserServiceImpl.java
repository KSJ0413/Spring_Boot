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







  @Override
  public int loginCheck(String id, String pw) {
    // TODO Auto-generated method stub
    return mapper.loginCheck(id, pw);
  }



 
  }






 
  


