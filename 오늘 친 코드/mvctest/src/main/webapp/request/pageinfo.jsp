<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="request.*"%>
    
    <%
    PageInfo info = new PageInfo(); 
    
 // 객체에 값 저장 
 info.setNowPage(1); 
 info.setSearchColumn("title"); 
 info.setSearchWord("JSP"); 
  
 //설정된 값을 가지고 있는 객체를 저장 
 request.setAttribute("info", info); 
  
 //요청한 현재 페이지가 응답후 새로운 요청으로 pageinfo2.jsp가 응답된다.
 //response.sendRedirect("pageinfo2.jsp"); 
  
    %>
    <!-- 현재페이지 요청을 pageinfo2.jsp가 대신 응답된다.-->  
<jsp:forward page="/request/pageinfo2.jsp"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>