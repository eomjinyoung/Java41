window.onload = function() {
	var login = $("#btnLogin");
	login.click( function(event) {
		$.ajax("login.do", {
			type: "POST",
			data: {
				email: $("#email").val(),
				password: $("#password").val(),
				saveId: $("#saveId").is(":checked")
			},
			dataType: "json",
			success: function(result) {
				if(result.status == "fail") {
					alert("이메일이나 암호가 맞지 않습니다.");
					$("#email").val("");
					$("#password").val("");
					$("#saveId").attr("checked", true);
				} else {
					location.href = "../main.html";
				}
			}
		});
		
		return false;
	});
};








