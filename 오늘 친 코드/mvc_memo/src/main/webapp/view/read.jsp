<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="memo.*" %>
<%
  int memono = Integer.parseInt(request.getParameter("memono"));
  memoDTO dto = (memoDTO)request.getAttribute("dto"); //한건의 레코드 조회
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
    function update(memono){//수정페이지 이동
      //alert(memono);
      let url = 'update.do?memono='+memono;
      location.href = url;
    }
    function del(memono){//삭제 페이지 이동
        //alert(memono);
        let url = 'delete.do?memono='+memono;
        location.href = url;
      }
    function reply(memono){//답변 페이지 이동
         //alert(memono);
         let url = 'reply.do?memono='+memono;
        location.href = url;
       }
  </script>
</head>
<body> 
<div class="container">

<h2>조회</h2>
<div class="panel panel-default">
<div class="panel-heading">작성자</div>
<div class="panel-body"><%=dto.getWname() %></div>
 
<div class="panel-heading">제목</div>
<div class="panel-body"><%=dto.getTitle() %></div>
 
<div class="panel-heading">내용</div>
<div class="panel-body" style="height: 200px"><%=dto.getContent() %></div>
 
<div class="panel-heading">조회수</div>
<div class="panel-body"><%=dto.getViewcnt() %></div>
 
<div class="panel-heading">등록일</div>
<div class="panel-body"><%=dto.getWdate() %></div>
</div>

<div>
  <button onclick="lacation.href='create.do'">등록</button>
  <button onclick="update('<%=memono%>')">수정</button>
  <button onclick="del('<%=memono%>')">삭제</button>
  <button onclick="reply('<%=memono%>')">답변</button>
  <button onclick="location.href='list.do'">목록</button>
</div>
<br>
</div>
</body> 
</html> 