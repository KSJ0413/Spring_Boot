package action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class DeleteProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
  
    
    
    int bbsno = Integer.parseInt(request.getParameter("bbsno"));
    String passwd = request.getParameter("passwd");
      
    Map map = new HashMap();
      map.put("bbsno",bbsno);
      map.put("passwd", passwd);
      BbsDAO dao = new BbsDAO();
      BbsDTO dto = new BbsDTO();
      boolean pflag = dao.passCheck(map);
      boolean flag = false;
      if(pflag) {  //올바른 비밀번호
        
        flag = dao.delete(bbsno);  //수정처리
      }
    request.setAttribute("pflag", pflag);
    request.setAttribute("flag", flag);
    
    return "/view/deleteProc.jsp";
  }

}
