package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.memoDAO;
import memo.memoDTO;

public class UpdateProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
memoDAO dao = new memoDAO();
memoDTO dto = new memoDTO();
      dto.setWname(request.getParameter("wname"));
    dto.setTitle(request.getParameter("title"));
    dto.setContent(request.getParameter("content"));
    dto.setPasswd(request.getParameter("passwd"));
    dto.setMemono(Integer.parseInt(request.getParameter("memono")));
    
    
    Map map = new HashMap();
    map.put("memono", dto.getMemono());
    map.put("passwd", dto.getPasswd());
    boolean pflag = dao.passCheck(map);
    boolean flag = false;
    if(pflag) {  //올바른 비밀번호
      
      flag = dao.update(dto);  //수정처리
    }
    
    request.setAttribute("pflag", pflag);
    request.setAttribute("flag", flag);
    
    return "/view/updateProc.jsp";
  }

}
