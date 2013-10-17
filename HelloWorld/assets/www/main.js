$(document).ready(function() {
	$("#header").load("header.html", function() {
		var headerjs = appContext.getObject("headerjs");
		headerjs.init();
	});
	
	$("#sidebar").load("sidebar.html", function() {
		var sidebarjs = appContext.getObject("sidebarjs");
		sidebarjs.init();
	});
	
	$("#footer").load("footer.html");
	

	$('body').on("projectManagement", function(event) {
		$("#content").load("project/project.html", function() {
			var projectjs = appContext.getObject("projectjs");
			projectjs.init("list");
			projectjs.listProject();
		});
	});
	
	$('body').on("projectChanged", function(event) {
		loadMyProjects();
	});
	
	$('body').on("projectView", function(event, projectNo) {
		$("#content").load("project/project.html", function() {
			var projectjs = appContext.getObject("projectjs");
			projectjs.init("view");
			projectjs.viewDetailProject(projectNo);
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
});

function AppContext() {
	var objMap = {};
	
	this.addObject = function(name, obj) {
		objMap[name] = obj;
	};
	
	this.getObject = function(name) {
		return objMap[name];
	};
}

window.appContext = new AppContext();
















