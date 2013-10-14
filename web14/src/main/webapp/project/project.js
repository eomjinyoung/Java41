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
						.attr("href", "#")
						.attr("data-no", projects[i].no)
						.click(function(event){
							viewDetailProject(this.attr("data-no"));
						})))
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
	
	$("#btnNewForm").click(function(event){
		$("#list").css("display", "none");
		
		$(".new-project").css("display", ""); // 등록버튼 보이기
		$(".view-project").css("display", "none"); // 수정버튼, 번호입력창 감추기
		$("#view").css("display", ""); // view 섹션 보이기
		
	});
	
	$("#btnList").click(function(event){
		$("#view").css("display", "none");
		$("#list").css("display", "");
	});
}

function viewDetailProject(projectNo) {
	$.ajax("project/view.do?no=" + projectNo, {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var project = result.data;
				$("#no").val(project.no);
				$("#title").val(project.title);
				$("#content").val(project.content);
				$("#startDate").val(project.startDate);
				$("#endDate").val(project.endDate);
				$("#tag").val(project.tag);
				$("#list").css("display", "none");
				$(".new-project").css("display", "none");
				$(".view-project").css("display", "");
				$("#view").css("display", "");
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

























