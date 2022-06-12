package com.study.model;

import java.util.List;
import java.util.Map;

public interface memoService {
  List<memoDTO> list(Map map);
  int total(Map map);
  void upViewcnt(int memono);
  memoDTO read(int memono);
  int create(memoDTO dto);
  int passCheck(Map map);
  int update(memoDTO dto);
  int delete(int memono);
  memoDTO readReply(int memono);
  int createReply(memoDTO dto);
  void upAnsnum(Map map);
}
