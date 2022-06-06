package action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.memoDAO;
import memo.memoDTO;


public class DeleteProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
  
    
    
    int memono = Integer.parseInt(request.getParameter("memono"));
    String passwd = request.getParameter("passwd");
      
    Map map = new HashMap();
      map.put("memono",memono);
      map.put("passwd", passwd);
      memoDAO dao = new memoDAO();
      memoDTO dto = new memoDTO();
      boolean pflag = dao.passCheck(map);
      boolean flag = false;
      if(pflag) {  //올바른 비밀번호
        
        flag = dao.delete(memono);  //수정처리
      }
    request.setAttribute("pflag", pflag);
    request.setAttribute("flag", flag);
    
    return "/view/deleteProc.jsp";
  }

}
