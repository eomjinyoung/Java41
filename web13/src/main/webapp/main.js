window.onload = function() {
	var logout = document.getElementById("logout");
	logout.onclick = function(event) {
		event.preventDefault();
		
		var xhr = createRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					location.href = "auth/login.html";
				}
			}
		};
		xhr.open("GET", "auth/logout.do", true);
		xhr.send();
	};
	
	loadLoginInfo();
	loadMyProjects();
};

function loadLoginInfo() {
	var xhr = createRequest();
	// 비동기 요청의 경우, 
	// XMLHttpRequest의 실행상태 변경시 마다 호출됨. 5단계
	// 0. 초기화 안됨.
	// 1. open() 호출 
	// 2. send() 호출 
	// 3. 서버로부터 데이터를 받고 있는 중
	// 4. 서버로부터 데이터 수신 완료.
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
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
			} else {
				alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
			}
		}
	};
	xhr.open("GET", "auth/loginInfo.do", true);
	xhr.send();	
}

function loadMyProjects() {
	var xhr = createRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var result = JSON.parse(xhr.responseText);
				if(result.status == "success") {
					var projectsSection = document.getElementById("projects");
					var projects = result.data;
					var article = null;
					for (var i in projects) {
						article = document.createElement("article");
						article.innerHTML = 
							"<a href='/web13/project/view.do?no=" + 
							projects[i].no + "'>" +
							projects[i].title + "</a>";
						projectsSection.appendChild(article);
					}
				} else {
					alert("실행중 오류발생!");
					console.log(result.data);
				}
			} else {
				alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
			}
		}
	};
	xhr.open("GET", "project/myprojects.do", true);
	xhr.send();	
}









