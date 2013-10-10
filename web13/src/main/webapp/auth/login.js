window.onload = function() {
	var login = document.getElementById("btnLogin");
	login.onclick = function(event) {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var saveId = document.getElementById("saveId").checked;
		
		if ( email == ""	|| password == "") {
			alert("이메일과 암호는 필수 입력항목입니다.");
		}
		
		var params = "email=" + email + "&password=" + password;
		if (saveId) {
			params += "&saveId=on";
		}
		
		var xhr = new XMLHttpRequest(); // 1. 도구준비
		xhr.open("POST", "login.do", false); // 2. 요청정보준비(동기)
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // only post
		xhr.send(params); // 3. 요청(서버에서 응답이 올 때까지 리턴안함)
		//console.log(xhr.responseText); // 4. 서버의 응답 꺼내기
		
		// 자바스크립트 객체 생성 코드를 실행하는 방법
		//1) eval()
		//var result = eval("[" + xhr.responseText + "]")[0];
		//2) JSON객체 사용
		// - JSON에서 속성 이름은 반드시 ""을 사용해야 한다.
		// - 문자열도 반드시 ""을 사용해야 한다.
		var result = JSON.parse(xhr.responseText);
		
		
		if(result.status == "fail") {
			alert("이메일이나 암호가 맞지 않습니다.");
		} else {
			alert("로그인 성공입니다.");
			alert(result.data);
		}
		
		
		return false;
	};
};








