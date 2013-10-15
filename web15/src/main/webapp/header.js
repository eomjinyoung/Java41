$(function() {
	$("#logout").click(function(event) {
		event.preventDefault();
		
		$.getJSON("auth/logout.do", function(result) {
			if(result.status == "success") {
				location.href = "auth/login.html";
			}
		});
	});
});
