package com.study.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.model.BbsServiceImpl")
public class BbsServiceImpl implements BbsService {
 @Autowired
 private BbsMapper mapper;
 
  public List<BbsDTO> list(Map map){   
    return mapper.list(map);
  }
  public int total(Map map) {
    return mapper.total(map);
  }
  public void upViewcnt(int bbsno) {
    mapper.upViewcnt(bbsno);
  }
  public BbsDTO read(int bbsno) {
    return mapper.read(bbsno);
  }
  @Override
  public int create(BbsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.create(dto);
  }
  @Override
  public int passCheck(Map map) {
    // TODO Auto-generated method stub
    return mapper.passCheck(map);
  }
  @Override
  public int update(BbsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.update(dto);
  }
  @Override
  public int delete(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.delete(bbsno);
  }
  @Override
  public BbsDTO readReply(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.readReoly(bbsno);
  }
  @Override
  public int createReply(BbsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.createReply(dto);
  }
  @Override
  public void upAnsnum(Map map) {
  mapper.upAnsnum(map);
  }
}
