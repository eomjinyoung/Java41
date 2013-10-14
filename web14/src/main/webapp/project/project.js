function projectjs_onload() {
	listProject();
	
	$("#btnNewForm").click(function(event){
		$("#list").css("display", "none");
		
		var resetEvent = new MouseEvent('click', {
		    'view': window,
		    'bubbles': true,
		    'cancelable': true
		});
		$("#btnReset").dispatchEvent(resetEvent);
		
		$(".new-project").css("display", ""); // 등록버튼 보이기
		$(".view-project").css("display", "none"); // 수정버튼, 번호입력창 감추기
		$("#view").css("display", ""); // view 섹션 보이기
		
	});
	
	$("#btnList").click(function(event){
		$("#view").css("display", "none");
		$("#list").css("display", "");
	});
	
	$("#btnAdd").click(function(){
		addProject();
	});
	
	$("#btnUpdate").click(function(){
		updateProject();
	});
	
	$("#btnDelete").click(function(){
		deleteProject();
	});
}

function listProject() {
	$.ajax("project/list.do", {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var projects = result.data;
				$(".data-row").remove();
				var table = $("#projectTable");
				for (var i in projects) {
					$("<tr>")
					.attr("class", "data-row")
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
}

function updateProject() {
	$.ajax("project/update.do", {
		type:"POST",
		data: {
			no: $("#no").val(),
			title: $("#title").val(),
			content: $("#pcontent").val(),
			startDate: $("#startDate").val(),
			endDate: $("#endDate").val(),
			tag: $("#tag").val()
		},
		success: function(result) {
			if(result.status == "success") {
				listProject();
				$("#view").css("display", "none");
				$("#list").css("display", "");
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

function addProject() {
	$.ajax("project/add.do", {
		type:"POST",
		data: {
			title: $("#title").val(),
			content: $("#pcontent").val(),
			startDate: $("#startDate").val(),
			endDate: $("#endDate").val(),
			tag: $("#tag").val()
		},
		success: function(result) {
			if(result.status == "success") {
				listProject();
				$("#view").css("display", "none");
				$("#list").css("display", "");
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

function viewDetailProject(projectNo) {
	$.ajax("project/view.do?no=" + projectNo, {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				var project = result.data;
				$("#no").val(project.no);
				$("#title").val(project.title);
				$("#pcontent").val(project.content);
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

function deleteProject() {
	$.ajax("project/delete.do?no=" + $("#no").val(), {
		type:"GET",
		success: function(result) {
			if(result.status == "success") {
				listProject();
				$("#view").css("display", "none");
				$("#list").css("display", "");
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
























