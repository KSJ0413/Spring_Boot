package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class HelloAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
   //model 사용
    CommandService service = new CommandService();
    StringBuffer sb =service.getHello();
    //결과 request 저장
    request.setAttribute("hello", sb);
    
    //결과보여줄 view
    
    return  "/view/hello.jsp"; 
  }

}
