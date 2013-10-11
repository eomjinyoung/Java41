window.onload = function() {
	var logout = document.getElementById("logout");
	logout.onclick = function(event) {
		event.preventDefault();
		
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "auth/logout.do", false);
		xhr.send();
		
		location.href = "auth/login.html";
	};
	
	
	var xhr = new XMLHttpRequest();
	// 비동기 요청의 경우, 
	// XMLHttpRequest의 실행상태 변경시 마다 호출됨. 5단계
	// 0. 초기화 안됨.
	// 1. open() 호출 
	// 2. send() 호출 
	// 3. 서버로부터 데이터를 받고 있는 중
	// 4. 서버로부터 데이터 수신 완료.
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			var result = JSON.parse(xhr.responseText);
			if(result.status == "success") {
				document.getElementById("userName").innerHTML = result.data.name;
				document.getElementById("userTel").innerHTML = result.data.tel;
				document.getElementById("userEmail").innerHTML = result.data.email;
				if (result.data.photoPath != undefined) {
					document.getElementById("memberPhoto").src = result.data.photoPath;
				} else {
					document.getElementById("memberPhoto").src = "images/test01.png";
				}
			} else {
				location.href = "auth/login.html";
			}
		}
	};
	xhr.open("GET", "auth/loginInfo.do", true);
	xhr.send();
};









