package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class UpeateAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    int bbsno = Integer.parseInt(request.getParameter("bbsno"));
    BbsDAO dao = new BbsDAO();
    BbsDTO dto = dao.read(bbsno);
    
    request.setAttribute("dto", dto);
    return "/view/updateForm.jsp";
  }

}
