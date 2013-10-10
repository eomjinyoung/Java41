window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "auth/loginInfo.do", false);
	xhr.send();
	
	var result = JSON.parse(xhr.responseText);
	if(result.status == "success") {
		alert(result.data.name);
	} else {
		location.href = "auth/login.html";
	}
	
};