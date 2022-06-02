package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class CreateProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)  {
    BbsDTO dto = new BbsDTO();
    dto.setWname(request.getParameter("wname"));
    dto.setTitle(request.getParameter("title"));
    dto.setContent(request.getParameter("content"));
    dto.setPasswd(request.getParameter("passwd"));
    BbsDAO dao = new BbsDAO();
    boolean flag = dao.create(dto);
    
    request.setAttribute("flag", flag);
    return "/view/createProc.jsp";
  }

}
