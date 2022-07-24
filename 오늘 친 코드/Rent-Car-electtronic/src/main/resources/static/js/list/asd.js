$(function(){
$("#btn11").click(function(){
 var carnumber = document.querySelector("#carnumber").value;
  var carname = document.querySelector("#carname").value;
   var carprice = document.querySelector("#carprice").value;
    var category = document.querySelector("#category").value;
    var caryearmodel = document.querySelector("#caryearmodel").value;
     var carseate = document.querySelector("#carseate").value;
      var carpoint = document.querySelector("#carpoint").value;
//       var filenameMF = document.querySelector("#filenameMF").value;


           	console.log(carnumber);
           		console.log(carname);
           			console.log(carprice);
           				console.log(category);
           					console.log(caryearmodel);
           						console.log(carseate);
           							console.log(carpoint);
//           								console.log(filenameMF);
  	var data = {
		"carnumber" : carnumber,
		"carname" : carname,
		"carprice" : carprice,
		"category" : category,
		"caryearmodel" : caryearmodel,
		"carseate" : carseate,
		"carpoint" : carpoint,
//		"filenameMF" : filenameMF
	}
	console.log(data);

//$.ajax({
//
//	    type : "post",
//	    url : "/carinfo/create",
//	     data : data,
//	    //data: data,
//	     //dataType:"json",
//	    //contentType: "application/json",
//	    success:function(data){
//		   console.log('성공입니다.');
//		   console.log(data);
//            alert("성공입니다.")
//
//	    },
//	    error:function(){
//	        alert("에러입니다");
//	    }
//	});




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