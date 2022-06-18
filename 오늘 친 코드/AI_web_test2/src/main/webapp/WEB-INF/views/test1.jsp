<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript">
 
 
function testAjax(){
	var id=$("#id").val();
	var pw=$("#pw").val();
	
	$.ajax({
		 
        type : "POST",

        url : "/login",

        data : "id=" + id + "&pw=" + pw,

        dataType : "text",

        success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
            if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                $('.id_ok').css("display","inline-block"); 
                $('.id_already').css("display", "none");
            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                $('.id_already').css("display","inline-block");
                $('.id_ok').css("display", "none");
            }
        },
        error:function(){
            alert("에러입니다");
        }
    });
    };
	
	
	
	
	
	
/* 	var ajax = new XMLHttpRequest();
	 ajax.onreadystatechange = function () {
		 if(this.readyState == 4 && this.status ==200){
			 console.log(ajax.responseText)
		 }
	 };
	 ajax.open("GET","/",true);
	 ajax.send(); */
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="UTF-8">
    <title>Company</title>
 
    <!-- 반응형 웹 만들기 -->
    <!-- 1. 모바일용 css -->
    <link rel="stylesheet" href="/css/test1_2.css" media="(max-width:600px)">
 
    <!-- 2. 데스크탑용 외부 스타일시트 적용 -->
    <link rel="stylesheet" href="/css/test1_1.css" media="(min-width:600px)">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="/js/test.js" type="text/javascript"></script>
	
	<script type="text/javascript">

	</script>

</head>
<body>
    
    <div id="page">
 
        <header>
            <div id="logo">
                <img src="/imgs/logo.png" alt="Logo">
            </div>
 
            <div id="top_menu">
                <a href="#">HOME</a> | 
                <a href="#">NOTICE</a> |
<!--                 <a href="#">LOGIN</a> | -->
                <a href="#">JOIN</a> | 
              <!--  1. 버튼을 누르면 aJax 요청을 하기 위해서 testAjax라는 함수를 호출한다. -->
                ID <input class="login" id="id"> PW <input type="password" class="login" id="pw"> <button id="login_btn" onclick="testAjax()" >LOGIN </button>
            	<input type="hidden" id="div1">
            </div>
 
            <nav>
                <ul>
                    <li><a href="#">COMPANY</a></li>
                    <li><a href="#">PRODUCT</a></li>
                    <li><a href="#">CUSTOMER</a></li>
                    <li><a href="#">SERVICE</a></li>
                    <li><a href="#">RECRUIT</a></li>
                </ul>
            </nav>
 
        </header>
 
        <article id="content">
            <section id="main">
                <img id="main_img" src="/imgs/main_img.png" alt="main img" >
            </section>
            <section>
                <ul id="banner">
                    <li><a href="#"><img src="/imgs/banner1.png" alt="banner1"></a></li>
                    <li><a href="#"><img src="/imgs/banner2.png" alt="banner2"></a></li>
                </ul>
 
            </section>
            <section>
            	<div>${message}</div>
            </section>
 
        </article>
 
        <footer>
            <img id="address_img" src="/imgs/address.png" alt="address">
        </footer>

    </div>
</body>
</html>