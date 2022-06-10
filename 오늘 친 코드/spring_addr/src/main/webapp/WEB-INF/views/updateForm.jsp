<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="com.study.model.*" %>

<% 
addrDTO dto = (addrDTO)request.getAttribute("dto");

%>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">주소 수정</h1>
<form class="form-horizontal" 
      action="/addr/update"
      method="post"
      >
      <input type="hidden" name = 'addressnum' value="<%=dto.getAddressnum() %>">
 <div class="form-group">
    <label class="control-label col-sm-2" for="name">이름</label>
    <div class="col-sm-6">
      <input type="text" name="name" id="name" class="form-control" value="<%=dto.getName() %>">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for=handphone>전화번호</label>
    <div class="col-sm-6">
      <input type="text" name="handphone" id="handphone" class="form-control" value="<%=dto.getHandphone() %>">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="zipcode">우편번호</label>
    <div class="col-sm-2">
      <input type="text" name="zipcode" class="form-control" 
      id="sample6_postcode" placeholder="우편번호" value="<%=dto.getZipcode() %>">
    </div>
    <div>
    <button class="btn" type="button" onclick="sample6_execDaumPostcode()">주소검색</button>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="address">주소</label>
    <div class="col-sm-6">
      <input type="text" name="address" value="<%=dto.getAddress() %>" id="sample6_address" placeholder="주소" class="form-control">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="address2">상세주소</label>
    <div class="col-sm-6">
      <input type="text" name="address2" value="<%=dto.getAddress2() %>" id="sample6_detailAddress" placeholder="상세주소" class="form-control">
    </div>
  </div>
  

  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">수정</button>
    <button type="reset" class="btn">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 