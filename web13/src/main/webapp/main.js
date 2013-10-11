window.onload = function() {
	var logout = document.getElementById("logout");
	logout.onclick = function(event) {
		event.preventDefault();
		
		ajax("auth/logout.do", {
			type:"GET",
			success: function(result) {
				if(result.status == "success") {
					location.href = "auth/login.html";
				}
			}
		});
	};
	
	loadLoginInfo();
	loadMyProjects();
};

function loadLoginInfo() {
	ajax("auth/loginInfo.do", {
		type:"GET",
		success: function(result) {
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
		},
		error: function(message) {
			alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
		}
	});
}

function loadMyProjects() {
	ajax("project/myprojects.do", {
		type:"GET",
		success: function(result) {
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
		},
		error: function(message) {
			alert("서버와의 통신이 원활하지 않습니다. \n잠시후 다시 시도하세요.");
		}
	});
}









