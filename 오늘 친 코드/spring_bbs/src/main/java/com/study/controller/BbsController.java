package com.study.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.bbs.UploadBbs;
import com.study.model.BbsDTO;
import com.study.model.BbsService;
import com.study.utility.Utility;

@Controller
public class BbsController {
  
  @Autowired
  @Qualifier("com.study.model.BbsServiceImpl")
  private BbsService dao;
  
  @PostMapping("/bbs/reply")
  public String reply(BbsDTO dto) {
    Map map = new HashMap();
    map.put("grpno",dto.getGrpno());
    map.put("ansnum",dto.getAnsnum());
    dao.upAnsnum(map);
    if(dao.createReply(dto)==1) {
      return "redirect:list";
    }else {
      return "error";
    }
    
  }
  
  @GetMapping("/bbs/reply/{bbsno}")
  public String reply(@PathVariable int bbsno, Model model) {
    model.addAttribute("dto", dao.readReply(bbsno));
    
    return "/reply";
  }
  
  @PostMapping("/bbs/delete")
  public String delete(int bbsno, String passwd, String oldfile) {
    Map map = new HashMap();
    map.put("bbsno", bbsno);
    map.put("passwd", passwd);
    
    String upDir = UploadBbs.getUploadDir();
    
    int pflag = dao.passCheck(map);
    int flag = 0;
    if(pflag==1) {
      flag = dao.delete(bbsno);
      if(oldfile !=null) Utility.deleteFile(upDir, oldfile);
    }
    
    
    
    
    
    if(pflag!=1)return "passwdError"; //비번오류일때 비번오류페이지 보여준다.
    else if(flag!=1) return "error";
    else return "redirect:list";
  }
  
  @GetMapping("/bbs/delete/{bbsno}/{oldfile}")
  public String delete(@PathVariable int bbsno, Model model,@PathVariable String oldfile) {
    model.addAttribute("bbsno", bbsno);
    model.addAttribute("oldfile", oldfile);
    return "/delete";
  }
  
  @PostMapping("/bbs/update")
  public String update(BbsDTO dto, @PathVariable String oldfile) {
    String upDir = UploadBbs.getUploadDir();
    if(dto.getFilenameMF().getSize()>0) {
      if(oldfile !=null) Utility.deleteFile(upDir, oldfile);
      dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
        dto.setFilesize((int)dto.getFilenameMF().getSize());
      
    }
    
    
    Map map = new HashMap();
    map.put("bbsno",dto.getBbsno());
    map.put("passwd",dto.getPasswd());
    int pflag = dao.passCheck(map);
    int flag = 0;
    
    if(pflag==1) flag = dao.update(dto);
    
    if(pflag!=1) return "passwdError";
    else if(flag!=1) return "error";
    else {
      return "redirect:list";
    }
  }
  
  @GetMapping("/bbs/update/{bbsno}")
  public String update(@PathVariable int bbsno, Model model) {
    model.addAttribute("dto",dao.read(bbsno));
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
  
  @GetMapping("/bbs/list")
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
    
    List<BbsDTO> list = dao.list(map);
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
  
  @PostMapping("/bbs/create")
  public String create(BbsDTO dto) {
    
    String upDir = UploadBbs.getUploadDir();
    
    if(dto.getFilenameMF().getSize()>0) {//브라우저에서 파일을 보냈다.
      dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
      dto.setFilesize((int)dto.getFilenameMF().getSize());
    }else {
      dto.setFilename("");
    }
    
    int cnt  = dao.create(dto);
    if(cnt!=1) return "error";
    return "redirect:list";
  }
  @GetMapping("/bbs/create")
  public String create() {
    
    return "/create";
  }
  
  @GetMapping("/bbs/read/{bbsno}")
  public String read(@PathVariable int bbsno, Model model) {
    dao.upViewcnt(bbsno);
    model.addAttribute("dto", dao.read(bbsno));
    return "/read";
  }
  
  
}

