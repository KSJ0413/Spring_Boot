package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.addrDAO;
import com.study.model.addrDTO;
import com.study.utility.Utility;

@Controller
public class addrController {
  
  @Autowired
  private addrDAO dao;
  
  @PostMapping("/addr/delete")
  public String delete(int addressnum) {
    boolean flag = dao.delete(addressnum);
   
    
    if(flag) {
      return "redirect:list";
    }else {
      return "error";
    }
  }
  
  @GetMapping("/addr/delete/{addressnum}")
  public String delete(@PathVariable int addressnum, Model model ) {
    model.addAttribute("addressnum", addressnum);
    return "/delete";
  }
  
  @PostMapping("/addr/update")
  public String update(addrDTO dto) {
    Map map = new HashMap();
    map.put("addressnum",dto.getAddressnum());
    boolean flag = dao.update(dto);
    
    if(flag) {
      return "redirect:list";
    }
    
    else {
      return "error";
    }
  }

  
  @GetMapping("/addr/update/{addressnum}")
  public String update(@PathVariable int addressnum, Model model) {
    model.addAttribute("dto",dao.read(addressnum));
    return "/update";
  }

  @GetMapping("/")
  public String home(Locale locale, Model model) {
    
   
    return "/home";
  }
  
  @GetMapping("/addr/list")
  public String list(HttpServletRequest request) {
    //검색관련--------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if(col.equals("total"))word = "";

    //페이징 관련---------------
    int nowPage = 1;
    if(request.getParameter("nowPage") != null){
        nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }

    int recordPerPage = 5;

    int sno = ((nowPage -1) * recordPerPage);
    int eno = recordPerPage;

    //1.model 사용
    Map map = new HashMap();//sno,eno,col,word
    map.put("sno", sno);
    map.put("eno", eno);
    map.put("col", col);
    map.put("word", word);
    
    List<addrDTO> list = dao.list(map);
    int total = dao.total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    //2.request 저장 (view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("paging", paging);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("nowPage", nowPage);
    
    return "/list";
  }
  
  @PostMapping("/addr/create")
  public String create(addrDTO dto) {
    boolean flag  = dao.create(dto);
    if(!flag) return "error";
    return "redirect:list";
  }
  @GetMapping("/addr/create")
  public String create() {
    
    return "/create";
  }
  
  @GetMapping("/addr/read/{addressnum}")
  public String read(@PathVariable int addressnum, Model model) {
    model.addAttribute("dto", dao.read(addressnum));
    return "/read";
  }
  
  
}
