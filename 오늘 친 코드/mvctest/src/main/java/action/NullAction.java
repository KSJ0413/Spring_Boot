package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    
    
    
    return "/view/nullCommand.jsp";
  }

}
