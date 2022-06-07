function check(f){
	if(f.menu.value ==''){
		alert("메뉴를 입력하세요");
		f.menu.focus();
		return false;
	}
		if(f.price.value ==''){
		alert("가격을 입력하세요");
		f.price.focus();
		return false;
	}
			if(f.price.value <1000 || f.price.value >=10000000){
		alert("금액은 천원이상 천만원 미만으로 입력해야합니다.");
		f.price.value='';
		f.price.focus();
		return false;
	}
	if(f.count.value==''){
		alert("갯수를 입력하세요.");
		f.count.focus();
		return false;
	}
	if(f.count.value <=0 || f.count.value >= 1000){
		alert("수량은 1개이상 천개 이하여야 합니다.");
		f.count.valye='';
		f.count.focus();
		return false;
	}
	
}