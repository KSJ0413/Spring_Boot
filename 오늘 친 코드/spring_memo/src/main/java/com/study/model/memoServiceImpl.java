package com.study.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.model.memoServiceImpl")
public class memoServiceImpl implements memoService {
 @Autowired
 private memoMapper mapper;
 
  public List<memoDTO> list(Map map){   
    return mapper.list(map);
  }
  public int total(Map map) {
    return mapper.total(map);
  }
  public void upViewcnt(int memono) {
    mapper.upViewcnt(memono);
  }
  public memoDTO read(int memono) {
    return mapper.read(memono);
  }
  @Override
  public int create(memoDTO dto) {
    // TODO Auto-generated method stub
    return mapper.create(dto);
  }
  @Override
  public int passCheck(Map map) {
    // TODO Auto-generated method stub
    return mapper.passCheck(map);
  }
  @Override
  public int update(memoDTO dto) {
    // TODO Auto-generated method stub
    return mapper.update(dto);
  }
  @Override
  public int delete(int memono) {
    // TODO Auto-generated method stub
    return mapper.delete(memono);
  }
  @Override
  public memoDTO readReply(int memono) {
    // TODO Auto-generated method stub
    return mapper.readReoly(memono);
  }
  @Override
  public int createReply(memoDTO dto) {
    // TODO Auto-generated method stub
    return mapper.createReply(dto);
  }
  @Override
  public void upAnsnum(Map map) {
  mapper.upAnsnum(map);
  }
}
