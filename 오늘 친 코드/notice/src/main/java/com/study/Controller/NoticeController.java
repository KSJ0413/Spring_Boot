package com.study.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.model.NoticeDTO;
import com.study.model.NoticeService;
import com.study.utility.Utility;

public class NoticeController {

  @Controller
  public class NoticeControoler{
    
    @Autowired
    @Qualifier("com.study.model.NoticeServiceImpl")
    private NoticeService service;
    
    @GetMapping("/read")
    public String read(int noticeno,Model model) {
      
      service.upCnt(noticeno);
      
      NoticeDTO dto = service.read(noticeno);
      
      String content = dto.getContent().replaceAll("\r\n", "<br>");
      
      dto.setContent(content);
      
      model.addAttribute("dto",dto);
      
      return "/read";
    }
    
    @GetMapping("update")
    public String update(int noticeno, Model model) {
      
      model.addAttribute("dto", service.read(noticeno));
   
      return "/update";
    }
   
    @PostMapping("update")
    public String update(NoticeDTO dto) {
   
      Map map = new HashMap();
      map.put("noticeno", dto.getNoticeno());
      map.put("passwd", dto.getPasswd());
      int pcnt = service.passwd(map);
      
      int cnt = 0;
      if (pcnt==1) {
        
        cnt = service.update(dto);
      }
   
      if (pcnt != 1) {
        return "./passwdError";
      } else if (cnt==1) {
        return "redirect:./list";
      } else {
        return "./error";
      }
   
    }
   
    @GetMapping("/delete")
    public String delete() {
   
   
      return "/delete";
    }
    
    @PostMapping("/delete")
    public String delete(HttpServletRequest request, int noticeno, String passwd) {
   
      Map map = new HashMap();
      map.put("noticeno", noticeno);
      map.put("passwd", passwd);
      int pcnt = service.passwd(map);
      
      int cnt = 0;
      if (pcnt==1) {
        
        cnt = service.delete(noticeno);
      }
   
      if (pcnt != 1) {
        return "./passwdError";
      } else if (cnt==1) {
        return "redirect:./list";
      } else {
        return "./error";
      }
   
    }
    
    @GetMapping("create")
    public String create() {
      
      return "/create";
    }
    
    @PostMapping("/notice/create")
    public String create(NoticeDTO dto) {
      
      if(service.create(dto)==1) {
        return "redirect:list";
      }else {
        return "error";
      }
    }
  
    
    @RequestMapping("/notice/list")
    public String list(HttpServletRequest request) {
    // 검색관련------------------------
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));
 
    if (col.equals("total")) {
      word = "";
    }
    // 페이지관련-----------------------
    int nowPage = 1;// 현재 보고있는 페이지
    if (request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    int recordPerPage = 3;// 한페이지당 보여줄 레코드갯수
 
    // DB에서 가져올 순번-----------------
    int sno = ((nowPage - 1) * recordPerPage) ;
    // int eno = nowPage * recordPerPage;
 
    Map map = new HashMap();
    map.put("col", col);
    map.put("word", word);
    map.put("sno", sno);
    map.put("cnt", recordPerPage);
 
    int total = service.total(map);
 
    List<NoticeDTO> list = service.list(map);
 
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
 
    // request에 Model사용 결과 담는다
    request.setAttribute("list", list);
    request.setAttribute("nowPage", nowPage);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("paging", paging);
 
    // view페이지 리턴
    return "/list";
    }
    
    @GetMapping("/")
    public String home(Locale locale, Model model) {
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      return "/home";
    }
  }
}


  

