<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.*, com.study.model.addrDTO, com.study.utility.*" %>
 <% 
//검색관련--------------
String col = (String)request.getAttribute("col");
String word = (String)request.getAttribute("word");
int nowPage = (int)request.getAttribute("nowPage");
List<addrDTO> list = (List<addrDTO>)request.getAttribute("list");
String paging = (String)request.getAttribute("paging");
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script type="text/javascript">
  function update(addressnum){//삭제 페이지 이동
      // let dContinue = confirm("정말 삭제하시겠습니까?");
        let url = 'update/'+addressnum;
        location.href = url;
      }
  
  
    function del(addressnum){//삭제 페이지 이동
      // let dContinue = confirm("정말 삭제하시겠습니까?");
        let url = 'delete/'+addressnum;
        location.href = url;
      }
   function read(addressnum){
       let url = 'read/'+addressnum;
       location.href = url;
    }
  </script>
</head>
<style>
#btn8{
 border-radius: 10px; 
border-top-left-radius: 10px; 
border-top-right-radius: 10px; 
border-bottom-left-radius: 10px; 
border-bottom-right-radius: 10px; //둥근버튼만들기 
cursor:pointer;
}
button:hover{
background : pink;


}
</style>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10"> 주소록</h1>
<form action="list" class='form-inline'>
<div class='form-group'>
 <select class='form-control' name='col'>
  <option value="name" <%if(col.equals("name")) out.print("selected");%>>이름</option>
  <option value="handphone" <%if(col.equals("handphone ")) out.print("selected");%>>전화번호</option>
  <option value="total" <%if(col.equals("total")) out.print("selected");%>>전체출력</option>
 </select>
</div>
<div class="form-group">
  <input type='text' class='form-control' placeholder='Enter 검색어' name='word' value="<%=word%>">
</div>
<button class='btn btn-default'>검색</button>
<button class='btn btn-default' type='button' onclick="location.href='create'">등록</button>
</form>
<table class="table table-striped">
  <thead>
    <tr>
     <th>번호</th>
      <th>이름</th>
      <th>전화번호</th>
      <th>주소</th>
      <th>수정</th>
      <th>삭제</th>
    </tr>
  </thead>
  <tbody>
<%  if(list.size()==0){ %>  
  <tr><td colspan='7'>등록된 주소가 없습니다.</td></tr>
  
<%  }else {
    for(int i=0 ; i < list.size() ; i++) { 
      addrDTO dto = list.get(i); 
%>  
    <tr>
      <td><%=dto.getAddressnum() %></td>
      <td><a href="javascript:read('<%=dto.getAddressnum() %>')"><%=dto.getName() %></a></td>
      <td><%=dto.getHandphone () %></td>
      <td><%=dto.getAddress() %></td> 
      <td><button id="btn8" onclick="update('<%=dto.getAddressnum() %>')">수정</button></td>
      <td><button  id="btn8" onclick="del('<%=dto.getAddressnum() %>')">삭제</button></td>
    </tr>
    
    
<%   
} //for end
} //if end
%>    
  </tbody>
</table>
<div>
  <%=paging %>
</div>
</div>
</body> 
</html> 