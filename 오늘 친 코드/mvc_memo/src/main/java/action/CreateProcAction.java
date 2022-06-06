package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.memoDAO;
import memo.memoDTO;

public class CreateProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)  {
    memoDTO dto = new memoDTO();
    dto.setWname(request.getParameter("wname"));
    dto.setTitle(request.getParameter("title"));
    dto.setContent(request.getParameter("content"));
    dto.setPasswd(request.getParameter("passwd"));
    memoDAO dao = new memoDAO();
    boolean flag = dao.create(dto);
    
    request.setAttribute("flag", flag);
    return "/view/createProc.jsp";
  }

}
