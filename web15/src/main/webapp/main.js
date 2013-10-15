window.onload = function() {
	$("#header").load("header.html");
	$("#sidebar").load("sidebar.html");
	$("#footer").load("footer.html");
	

	$('body').on("projectManagement", function(event) {
		$("#content").load("project/project.html");
	});
	
	$('body').on("projectChanged", function(event) {
		loadMyProjects();
	});
	
	$('body').on("projectView", function(event, projectNo) {
		$("#content").load("project/project.html", function() {
			viewDetailProject(projectNo);
		});
	});
	
	/*	
	document.body.addEventListener("memberManagement", function(event) {
		console.log(event.test);
		$("#content").load("member/member.html");
	});
	
	document.body.addEventListener("taskManagement", function(event) {
		console.log(event.test);
		$("#content").load("task/task.html");
	});
	
	document.body.addEventListener("feed", function(event) {
		console.log(event.test);
		$("#content").load("feed/feed.html");
	});
	*/
};
