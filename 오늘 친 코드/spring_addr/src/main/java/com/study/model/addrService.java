package com.study.model;

import java.util.List;
import java.util.Map;

public interface addrService {

  List<addrDTO> list(Map map);

  int total(Map map);

  addrDTO read(int addressnum);

  int create(addrDTO dto);

  int update(addrDTO dto);

  int delete(int addressnum);

}
