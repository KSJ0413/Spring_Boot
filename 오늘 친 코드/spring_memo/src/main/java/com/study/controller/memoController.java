package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.memoDAO;
import com.study.model.memoDTO;
import com.study.utility.Utility;

@Controller
public class memoController {
  
  @Autowired
  private memoDAO dao;
  
  @PostMapping("/memo/reply")
  public String reply(memoDTO dto) {
    Map map = new HashMap();
    map.put("grpno",dto.getGrpno());
    map.put("ansnum",dto.getAnsnum());
    dao.upAnsnum(map);
    if(dao.createReply(dto)) {
      return "redirect:list";
    }else {
      return "error";
    }
    
  }
  
  @GetMapping("/memo/reply/{memono}")
  public String reply(@PathVariable int memono, Model model) {
    model.addAttribute("dto", dao.readReply(memono));
    
    return "/reply";
  }
  
  @PostMapping("/memo/delete")
  public String delete(@RequestParam Map<String,String> map ) {
    
    int memono = Integer.parseInt(map.get("memono"));
    boolean pflag = dao.passCheck(map);
    boolean flag = false;
    if(pflag)flag = dao.delete(memono); 
    
    if(!pflag)return "passwdError"; //비번오류일때 비번오류페이지 보여준다.
    else if(!flag) return "error";
    else return "redirect:list";
  }
  
  @GetMapping("/memo/delete/{memono}")
  public String delete(@PathVariable int memono, Model model) {
    model.addAttribute("memono", memono);
    return "/delete";
  }
  
  @PostMapping("/memo/update")
  public String update(@RequestParam Map<String,String> map, memoDTO dto) {
    int memono = Integer.parseInt(map.get("memono"));
    boolean pflag = dao.passCheck(map);
    boolean flag = false;
    
    if(pflag) flag = dao.update(dto);
    
    if(!pflag) return "passwdError";
    else if(!flag) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/memo/update/{memono}")
  public String update(@PathVariable int memono, Model model) {
    model.addAttribute("dto",dao.read(memono));
    return "/update";
  }

  @GetMapping("/")
  public String home(Locale locale, Model model) {
    
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
    
    String formattedDate = dateFormat.format(date);
    
    model.addAttribute("serverTime", formattedDate );
    return "/home";
  }
  
  @GetMapping("/memo/list")
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
    
    List<memoDTO> list = dao.list(map);
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
  
  @PostMapping("/memo/create")
  public String create(memoDTO dto) {
    boolean flag  = dao.create(dto);
    if(!flag) return "error";
    return "redirect:list";
  }
  @GetMapping("/memo/create")
  public String create() {
    
    return "/create";
  }
  
  @GetMapping("/memo/read/{memono}")
  public String read(@PathVariable int memono, Model model) {
    dao.upViewcnt(memono);
    model.addAttribute("dto", dao.read(memono));
    return "/read";
  }
  
  
}
