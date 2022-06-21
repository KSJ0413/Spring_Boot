$(function(){
	$("#login_btn").click(function(){


	 var id = document.querySelector("#id").value;
	 var pw = document.querySelector("#pw").value;
 
      alert(id+":"+pw);
     

        
  	var data = {
		"id" : id,
		"pw" : pw
	}      
	console.log(data);
	
/*  	$.ajax({
		 
	    type : "get", 
	    url : "loginCheckk", //+ "?id=" + id + "&pw=" + pw,
	    // data : JSON.stringify(data),
	    data: data,
	    // dataType:"json",
	    contentType: "application/json",
	    success:function(nameView){ 
		   console.log('성공입니다.');
		   console.log(nameView);
		   if (nameView == "fail") {
				alert("로그인 실패");
			} else {
				 
				console.log(nameView);
				alert(nameView+"님 login ok Status Success");
			}
	    },
	    error:function(){
	        alert("에러입니다");
	    }
	}); 
        */

				//Ajax버젼도 작동 완료!
	fetch(
		'loginCheckk?id=' + id + '&pw=' + pw
		, {
	        method: 'get',
	        headers: {
				'content-Type' : 'application-json'
			}
		})
        .then(response => {
			console.log(response);
			// console.log(response);
			// return response.json();
			return response.text();
		}).then(response => {
			if (response == "fail") {
				alert("로그인 실패");
			} else {
				 
				console.log(response);
				alert(response+"님 login ok Status Success");
			}
			
			
		}).catch(err => {
			console.log(err);
			// alert("에러입니다");
		});
	});

});

