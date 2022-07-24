    <%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="util" uri="/ELFunctions" %>
    <!DOCTYPE html>
    <html>
    <head>
  <script src="/js/list/read.js" defer></script>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width">
      <title>JS Bin</title>
       <link rel="stylesheet" type="text/css" href="/css/list2.css"/>
       <script src="https://code.jquery.com/jquery-latest.min.js"></script>

<style>
  .container {
    width: 900px;
    margin: 0 auto;
    position: relative;
  }

  </style>
    </head>
    <body>

<input type="hidden" name="listno" value="${dto.listno}">
      <div class="container">
        <div id="div1">
         <table class="table table-striped">
          <th><img src="https://cdn-icons-png.flaticon.com/512/1828/1828413.png" style="height:20px; width:20px ">&nbsp;${dto.wname}</th>
          <th>&emsp;${dto.rdate}&emsp;</th>
          <th>조회수: ${dto.cnt}</th>
             <div style="display: inline-block; margin: 0 5px;  float: right;">
            <button id='btn' class='btn' style="width:10; height:5;" >글 삭제</button>
             </div>


          </table>
        </div>
        <br>
        <div style="display: inline-block; margin: 0 5px;  float: right;"><span style="color: #787878;">
        <a style="color: #787878;" href="/contents/list">목록</a>
    |   <a style="color: #787878;" href="javascript:void(0);" onClick="document.getElementById('powerbbsCmt2').scrollIntoView();">추천(<span style="color:#F94B4B;">${dto.recommend}</span>)</a>
          </span></div>
          <br><br><br>
        <h1>${dto.title}</h1>

        <br><br><br>
        <h3>${dto.content}</h3>

          <br><br><br>
          <div style="display: flex;   justify-content : center;">
          <button id="btn1" style="border-radius: 30px;"><img src="/images/SJ/free-icon-thumb-up-889221.png" style="height:130px;"></button>
          </div>
            <br><br><br>
            <div id=review>
                   <img src="https://cdn-icons-png.flaticon.com/512/4909/4909922.png" style="height:30px; width:30px "> <span style="font-size: 25px;">댓글</span>  <a style="color: #787878;">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;등록순</a>
                <a style="display: inline-block; margin: 0 5px;  float: right; cursor: pointer; color: #787878;"  onClick="window.location.reload()">새로고침</a>
            </div>
            <hr>
            <!-- -------------------------------------------------------------------------  -->

 <table class="table table-striped">

   <tbody>

<c:choose>
<c:when test="${empty list}">
   <tr><td colspan="6">댓글이 없습니다.</td></tr>
</c:when>
<c:otherwise>

   <c:forEach var="list" items="${list}">
<input type="hidden" value="${list.rnum}" id="rnum">

<strong class="title">
<img src="https://cdn-icons-png.flaticon.com/128/1465/1465265.png" style=" height:30px; width:30px;">
<span class="nickname" data-is-writer="1" style="padding: 1em;">${dto.wname}</span>
<span class="date">(${list.regdate})</span>



</strong>
<br><br>



    <a >${list.content}</a>
    <div style="display: inline-block; margin: 0 5px;  float: right;">
   <button id='delete' class='delete' style="width:20; height:20;">삭 제</button>
    </div>
    <br>
      <br>
    <hr>




   </c:forEach>
   </c:otherwise>
   </c:choose>

   </tbody>

  </table>


              <!-- -------------------------------------------------------------------------  -->

             <table  style=" width:930px; height:150px; margin:0 auto;">
             <th>
                <textarea id="review11" name="content" class="content" rows="8" tabindex="99" placeholder="명예훼손,개인정보 유출,분쟁,허위사실 유포 등의 글은 이용약관에 의해 제재는
법률에 의해 처벌 받을 수 있습니다. 건전한 커뮤니티를 위해 자제를 당부 드립니다." style="width:830px; height:70px;"></textarea>
             </th>
             <th>
             <button id='addreviewBtn' class='btn btn-primary btn-xs pull-right' type="button" style="width:100px; height:85px;" >등 록</button>

             </th>
             </table>







    </div>
                   <script>
                     let listno = "${dto.listno}";
                    let sno = "${sno}";
                     let eno = "${eno}";
                     <!-- 댓글용 paging 로그인 id -->
                     let nPage = "${nPage}";
                     let id = "${sessionScope.id}";
                  </script>








    </body>
    </html>