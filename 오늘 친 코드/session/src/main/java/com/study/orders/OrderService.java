package com.study.orders;

import java.util.List;
import java.util.Map;

public interface OrderService {

  void create(OrdersDTO dto) throws Exception;//AOP로 할예정, 롤백필요, 그래서 익셉션에대한 처리를 해줘야함
  
  List<OrdersDTO> list(Map map);

  int total(Map map);

  int updateState(Map map);
  
}
