if (window.appContext.getObject("sidebarjs") == undefined) {
	console.log("sidebar.js 로딩...");
	var sidebarjs = {
		init: function() {
			this.loadLoginInfo();
			this.loadMyProjects();
			
			$("#projectListAll").click( function() {
				$(this).trigger("projectManagement");
			});
			
			$("#projects").on("click", ".projectView", function() {
				$(this).trigger("projectView", [$(this).attr("data-no")]);
			});
		},
		
		loadLoginInfo: function() {
			$.getJSON("auth/loginInfo.do", function(result) {
				if(result.status == "success") {
					var loginInfo = result.data;
					
					$("#userName").text( loginInfo.name );
					$("#userTel").text( loginInfo.tel );
					$("#userEmail").text( loginInfo.email );
					
					if (loginInfo.photoPath != undefined) {
						$("#memberPhoto").attr("src", loginInfo.photoPath);
					} else {
						$("#memberPhoto").attr("src", "images/test01.png");
					}
				} else {
					location.href = "auth/login.html";
				}
			});
		},
		
		loadMyProjects: 	function() {
			$.getJSON("project/myprojects.do", function(result) {
				if(result.status == "success") {
					var projectsSection = $("#projects");
					$("#projects article").remove();
					var projects = result.data;
					for (var i in projects) {
						$("<article>")
							.append( 
									$("<a>")
										.addClass("projectView")
										.attr("href", "#")
										.attr("data-no", projects[i].no)
										.text(projects[i].title))
							.appendTo(projectsSection);
					}
				} else {
					alert("실행중 오류발생!");
					console.log(result.data);
				}
			});
		}
	};
	
	window.appContext.addObject("sidebarjs", sidebarjs);
}









