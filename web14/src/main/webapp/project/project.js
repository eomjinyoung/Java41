function projectjs_onload() {
	$.ajax("project/list.do", {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var projects = result.data;
				var table = $("#projectTable");
				for (var i in projects) {
					$("<tr>")
						.append($("<td>").html( projects[i].no ))
						.append($("<td>").append(
									$("<a>").html(projects[i].title)
											.attr("href", "#")))
						.append($("<td>").html( projects[i].startDate ))
						.append($("<td>").html( projects[i].endDate ))
						.appendTo(table);
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









