<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%
    List<Map> list  =(List<Map>) request.getAttribute("team");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container"> 
<h3>팀목록</h3>
<table class="table table-striped-columns">
<thead>
<tr>
<th>이름</th><th>보유기술</th><th>전화번호</th><th>주소</th>
</tr>
</thead>
<tbody>
<% for(int i=0; i<list.size(); i++){
 Map map = list.get(i);
  %>

<tr>
<td><%=map.get("name") %></td>
<td><%=map.get("skill") %></td>
<td><%=map.get("phone") %></td>
<td><%=map.get("address") %></td>
</tr>
<%} %>
</tbody>
</table>
</div> 
</body>
</html>