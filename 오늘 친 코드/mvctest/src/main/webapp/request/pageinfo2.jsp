<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="request.*"%>
<% 
PageInfo info = (PageInfo)request.getAttribute("info"); 
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="font-size: xx-large; text-align: center;"> 
<h2>  pageinfo2.jsp 입니다.</h2> 
    nowPage:      <%=info.getNowPage() %> <br/> 
    searchColumn: <%=info.getSearchColumn()%> <br/> 
    searchWord:   <%=info.getSearchWord() %> <br/> 
 
</div> 
</body>
</html>