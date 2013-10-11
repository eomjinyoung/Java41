function headerjs_onload () {
	//console.log("headerjs_onload 호출됨..");
	var logout = $("#logout");
	logout.onclick = function(event) {
		event.preventDefault();
		
		$.ajax("auth/logout.do", {
			type:"GET",
			success: function(result) {
				if(result.status == "success") {
					location.href = "auth/login.html";
				}
			}
		});
	};
}
