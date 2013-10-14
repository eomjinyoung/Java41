window.onload = function() {
	$("#header").load("header.html");
	$("#sidebar").load("sidebar.html");
	$("#footer").load("footer.html");
	
	document.body.addEventListener("projectManagement", function(event) {
		console.log(event.test);
		$("#content").load("project/project.html");
	});
	
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
};
