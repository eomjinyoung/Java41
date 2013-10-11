window.onload = function() {
	$("#header").load("header.html");
	$("#sidebar").load("sidebar.html");
	$("#footer").load("footer.html");
	
	document.body.addEventListener("projectListAllClick", function(event) {
		console.log(event.test);
		$("#content").load("project/project.html");
	});
};
