$(function(){
	$("#login_btn").click(function(){

 var id_v =document.querySelector("#id").value;
 var pw_v =document.querySelector("#pw").value;
 var url = 'loginCheck';
 
     alert(id_v+":"+pw_v);
     
     
/*	return fetch("/test1",{
		method: "GET",
		body: JSON.stringify(),
		headers: {'Content-Type': "application/json; charset=utf-8"}
	}).then(response => response.json(result))
	.then(alert())*/

     


		
	});

});
