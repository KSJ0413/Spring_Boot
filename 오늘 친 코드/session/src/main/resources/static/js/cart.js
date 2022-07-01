function addCart(param){
	return fetch('/cart/create',{
        method: 'post',
        body: JSON.stringify(param),
        headers: {'Content-Type': "application/json; charset=utf-8"}
        })
        .then(response => response.text())
        .catch(console.log);
}
//get방식에서는 중괄호 부분 생략가능 대신 주소창에 이것저것 많이 넣어야됨 ${}이런거