if (window.appContext.getObject("headerjs") == undefined) {
	console.log("header.js 로딩...");
	var headerjs = {
		init: function() {
			$("#logout").click(function(event) {
				event.preventDefault();
				
				$.getJSON("auth/logout.do", function(result) {
					if(result.status == "success") {
						location.href = "auth/login.html";
					}
				});
			});
		}
	};
	
	window.appContext.addObject("headerjs", headerjs);
}
