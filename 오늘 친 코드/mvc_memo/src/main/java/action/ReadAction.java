package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.memoDAO;
import memo.memoDTO;

public class ReadAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    int memono = Integer.parseInt(request.getParameter("memono"));
    memoDAO dao = new memoDAO();
    dao.upViewcnt(memono); //조회수 증가
    memoDTO dto = dao.read(memono);
     
     request.setAttribute("dto", dto);
     
     return "/view/read.jsp";
   }

 }
