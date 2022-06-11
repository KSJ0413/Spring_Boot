package com.study.model;

import java.util.List;
import java.util.Map;

public interface BbsMapper {
  List<BbsDTO> list(Map map);
  int total(Map map);
  void upViewcnt(int bbsno);
  BbsDTO read(int bbsno);
  int create(BbsDTO dto);
  int passCheck(Map map);
  int update(BbsDTO dto);
  int delete(int bbsno);
  BbsDTO readReoly(int bbsno);
  int createReply(BbsDTO dto);
  void upAnsnum(Map map);
}
