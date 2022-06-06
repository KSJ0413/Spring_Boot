package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.memoDAO;
import memo.memoDTO;

public class ReplyProcAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    memoDTO dto = new memoDTO();
dto.setWname(request.getParameter("wname"));
dto.setTitle(request.getParameter("title"));
dto.setContent(request.getParameter("content"));
dto.setPasswd(request.getParameter("passwd"));

dto.setMemono(Integer.parseInt(request.getParameter("memono")));
dto.setGrpno(Integer.parseInt(request.getParameter("grpno")));
dto.setIndent(Integer.parseInt(request.getParameter("indent")));
dto.setAnsnum(Integer.parseInt(request.getParameter("ansnum")));



memoDAO dao = new memoDAO();

    Map map = new HashMap();
    map.put("grpno",dto.getGrpno());
    map.put("ansnum", dto.getAnsnum());
    
    dao.upAnsnum(map);
    boolean flag = dao.createReply(dto);
    
    
    request.setAttribute("flag", flag);
    
    return "/view/replyProc.jsp";
  }

}
