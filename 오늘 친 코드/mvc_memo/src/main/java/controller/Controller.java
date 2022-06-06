package controller; 
 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.Properties; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import action.NullAction; 
import action.Action; 
 
public class Controller extends HttpServlet { 
    private boolean usingTemplate = false; 
    private String templatePage = null; 
    
    //명령어=명령처리Action객체
    private Map map = new java.util.HashMap(); 
     
    public void init(ServletConfig config) throws ServletException { 
        String configFile = config.getInitParameter("configFile"); 
         
        Properties prop = new Properties(); 
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(configFile); 
            prop.load(fis); //파일을 객체로 로딩,키와 문자열 값 저장.
        } catch (IOException e) { 
            throw new ServletException(e); 
        } finally { 
            if (fis != null) try { fis.close(); } catch(IOException ex) {} 
        } 
         
        Iterator keyIter = prop.keySet().iterator(); //properties 객체에서 키목록 가져온다.
        while( keyIter.hasNext() ) { 
            String command = (String)keyIter.next(); //하나의 키를 가져옵니다.
            System.out.println("command: " + command); 
 
            String handlerClassName = prop.getProperty(command).trim();  //추출된 키에 해당값을 가져옵니다
            System.out.println("handlerClassName: " + handlerClassName); 
             
            try { 
                //클래스를 JVM으로 로딩합니다. 
                Class handlerClass = Class.forName(handlerClassName); // 클래스 소스를 읽어 옵니다.
                 
                //읽어들인 클래의 객체를 생성합니다. 
                Object handlerInstance = handlerClass.newInstance(); //읽어들인 객체를 생성한다.
                 
                //MAP에 키와 각 클래스별 객체가 저장합니다. 
                map.put(command, handlerInstance); //MAP에 키와 각 클래스별 객체가 저장됩니다.
                
            } catch (ClassNotFoundException e) { 
                throw new ServletException(e); 
            } catch (InstantiationException e) { 
                throw new ServletException(e); 
            } catch (IllegalAccessException e) { 
                throw new ServletException(e); 
            } 
        } 
      
        templatePage = config.getInitParameter("templatePage"); //템플릿 파일을 web.xml(template.jsp)에서 읽어옵니다. 
        
        if (templatePage != null && !templatePage.equals("")) { 
            usingTemplate = true; // 템플릿 페이지 존재 
        } 
    } 
 // 1.http 요청받음  -----------------------------------------------
    public void doGet( //Form Method GET일 경우
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
 
    protected void doPost( //Form Method POST일 경우
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
     
    private void process( // DO GET 처리
        HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException { 
      // 2. 요청기능 분석   -------------------------------------------
        String command = request.getRequestURI(); //Client가 요청한 URI 주소
        System.out.println("RequestURI: " + request.getRequestURI()); 
        
        //URI:/www_mvc/mvc/list.do  
        // 주소가 /www_mvc 로 시작하는지 검사 
        //context root 로 시작하면 context root 문자열 제거
        if (command.indexOf(request.getContextPath()) == 0) { 
            command = command.substring(request.getContextPath().length()); 
            System.out.println("command: " + command); 
        } 
         
 // 주어진 URL에 해당하는 핸들러 클래스가 존재하는지 검색
        Action action =  
            (Action)map.get(command); 
         
        // 핸들러가 없는 경우 
        if (action == null) { 
            action = new NullAction(); 
        } 
         
        String viewPage = null; 
        try { 
                  // "view/hello.jsp" 3.model사용,4.request 결과저장, 5.view선택(리턴)
          
          //Model 비즈니스로직 처리
          //Model 부분이 처리된루에는 처리된 내용을 출력학 view페이지가 리턴된다.
            viewPage = action.execute(request, response); 
        } catch(Throwable e) { 
            throw new ServletException(e); 
        } 
         //템플릿을 사용중이면 "CONTENT_PAGE" 속성에 보여줄 파일을 지정한다.
        if (usingTemplate) { 
            request.setAttribute("CONTENT_PAGE", viewPage); 
        } 
        // forward 처리 <jsp:forward page=""/> 6. 뷰포워드 처리
        
        RequestDispatcher dispatcher =  // 클라이언트로 들어온 요청을 jsp/servlet 내에 원하는 곳에 넘기는 클래스
           request.getRequestDispatcher( 
                   usingTemplate ? templatePage : viewPage); 
        dispatcher.forward(request, response); 
    } 
} 