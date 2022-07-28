$(function(){
$("#btn11").click(function(){
 var noticeno = document.querySelector("#noticeno").value;

  	var data = {
		"noticeno" : noticeno,

	}
	console.log(data);

$.ajax({
	    type : "get",
	    url : "",
	     data : data,
	    success:function(data){
		   console.log('성공입니다.');
		   console.log(data);
            alert("성공입니다.")

	    },
	    error:function(){
	        alert("에러입니다");
	    }
	});



fetch(`/carinfo/create`,{method: 'POST',
                        body : data})
               .then(response => response.text())
               .then(location.reload())
               .catch(console.log);
        		});







//      const response = await fetch("/carinfo/create", {
//        method: 'POST',
//        headers: {
//          'Content-Type': 'application/json',
//        },
//        body: JSON.stringify(data)
//      }).then((res) => {
//        if (res.status == 200) {
//          alert("등록했습니다.");
//          window.close();
//        }
//      }).catch(() => {
//        alert("잠시후 다시 시도해 보세요.");
//        window.close();
//      });
//      location.reload();
//    }
















});
});