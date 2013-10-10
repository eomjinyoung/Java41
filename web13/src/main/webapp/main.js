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
	xhr.open("GET", "auth/loginInfo.do", false);
	xhr.send();
	
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
	
	
	
};